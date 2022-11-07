package br.com.texo.goldenawardsinterviewtest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.texo.goldenawardsinterviewtest.entity.AwardInterval;
import br.com.texo.goldenawardsinterviewtest.entity.Movie;
import br.com.texo.goldenawardsinterviewtest.entity.Producer;
import br.com.texo.goldenawardsinterviewtest.enums.IntervalType;
import br.com.texo.goldenawardsinterviewtest.repository.MovieRepository;

@Service
public class IntervalService {
    Logger log = LoggerFactory.getLogger(IntervalService.class);

    @Autowired
    MovieRepository movieRepository;

    private Integer calculateInterval(Integer firstYear, Integer lastYear) {
        return lastYear - firstYear;
    }

    public List<AwardInterval> getInterval(IntervalType intervalType) {
        List<AwardInterval> intervals = new ArrayList<>();
        List<Movie> orderedMovies = getOrderedMovies();
        Map<Long, AwardInterval> winnerProducers = new HashMap<>();
        Integer interval = intervalType.getValue();

        for (Movie movie : orderedMovies) {
            for (Producer producer : movie.getProducers()) {
                if (winnerProducers.containsKey(producer.getId())) {
                    interval = validateIntervals(intervalType, intervals, winnerProducers, interval, movie, producer, calculateInterval(winnerProducers.get(producer.getId()).getPreviousWin(),movie.getReleaseYear()));
                    winnerProducers.get(producer.getId()).setPreviousWin(movie.getReleaseYear());
                } else {
                    winnerProducers.put(producer.getId(), AwardInterval.builder()
                            .previousWin(movie.getReleaseYear())
                            .build());
                }
            }
        }
        return intervals;

    }

    private Integer validateIntervals(IntervalType intervalType, List<AwardInterval> intervals,Map<Long, AwardInterval> winnerProducers, Integer interval, Movie movie, Producer producer,Integer intervalAux) {
        if (intervalType.equals(IntervalType.MAX) && interval <= intervalAux) {
            if (interval < intervalAux) {
                intervals.clear();
            }
            interval = getAndAddInterval(intervals, winnerProducers, movie, producer, intervalAux);
        } else if (intervalType.equals(IntervalType.MIN) && interval >= intervalAux) {
            if (interval > intervalAux) {
                intervals.clear();
            }
            interval = getAndAddInterval(intervals, winnerProducers, movie, producer, intervalAux);

        }
        return interval;
    }

    private Integer getAndAddInterval(List<AwardInterval> intervals, Map<Long, AwardInterval> winnerProducers, Movie movie, Producer producer, Integer intervalAux) {
        Integer interval;
        interval = intervalAux;
        intervals.add(AwardInterval.builder()
                .producer(producer.getName())
                .previousWin(winnerProducers.get(producer.getId()).getPreviousWin())
                .followingWin(movie.getReleaseYear())
                .interval(interval)
                .build());
        return interval;
    }

    private List<Movie> getOrderedMovies() {
        return movieRepository
                .findAll()
                .stream()
                .filter(Movie::getWinner)
                .sorted((o1, o2) -> o1.getReleaseYear().compareTo(o2.getReleaseYear()))
                .toList();
    }

}
