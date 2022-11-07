package br.com.texo.goldenawardsinterviewtest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import br.com.texo.goldenawardsinterviewtest.entity.Movie;
import br.com.texo.goldenawardsinterviewtest.entity.MovieFile;
import br.com.texo.goldenawardsinterviewtest.entity.Producer;
import br.com.texo.goldenawardsinterviewtest.entity.Studio;
import br.com.texo.goldenawardsinterviewtest.repository.MovieRepository;
import br.com.texo.goldenawardsinterviewtest.repository.ProducerRepository;
import br.com.texo.goldenawardsinterviewtest.repository.StudioRepository;

@SpringBootApplication
public class GoldenAwardsInterviewTestApplication {
	private static final Logger log = LoggerFactory.getLogger(GoldenAwardsInterviewTestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GoldenAwardsInterviewTestApplication.class, args);
	}
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	ProducerRepository producerRepository;
	
	@Autowired
	StudioRepository studioRepository;
	
	@Value("${movies.filename}")
	private String filename;
	
	private static final char FILE_SEPARATOR = ';';
	
	@PostConstruct
	public void init() {
		log.info("Trying to load movie list from " + filename);
		
		try{
			CsvToBean<MovieFile> csvToBean = loadMoviesFile(filename, FILE_SEPARATOR);
			
            List<Studio> studios = new ArrayList<>();
            List<Producer> producers = new ArrayList<>();
            List<Movie> movies = new ArrayList<>();
            
			for(MovieFile movieFile : csvToBean) {
			    List<Producer> movieProducers = Arrays.asList(movieFile.getProducers().split(",| and "))
			            .stream()
			            .filter(producer -> !producer.trim().isEmpty())
			            .map(producer -> Producer.builder().name(producer.trim()).build())
			            .toList();
			    
			    producers.addAll(movieProducers);
			    
			    List<Studio> movieStudios = Arrays.asList(movieFile.getStudios().split(",| and "))
                        .stream()
                        .filter(studio -> !studio.trim().isEmpty())
                        .map(studio -> Studio.builder().name(studio.trim()).build())
                        .toList();
			    
			    studios.addAll(movieStudios);
			    
			    movies.add(Movie.builder()
			            .releaseYear(movieFile.getYear())
			            .title(movieFile.getTitle())
			            .producers(movieProducers)
			            .studios(movieStudios)
			            .winner("YES".equalsIgnoreCase(movieFile.getWinner() != null ? movieFile.getWinner().toUpperCase() : ""))
			            .build());
			}
			
			studios = studios.stream().distinct().toList();
			producers = producers.stream().distinct().toList();
			
			studioRepository.saveAll(studios);
			producerRepository.saveAll(producers);
			
			for(Movie movie : movies) {
			    List<Producer> producersAux = new ArrayList<>();
			    for(Producer producer : movie.getProducers()) {
			        if(producers.contains(producer)) {
			            producersAux.add(producers.get(producers.indexOf(producer)));
			        }
			    }
			    
			    List<Studio> studiosAux = new ArrayList<>();
                for(Studio studio : movie.getStudios()) {
                    if(studios.contains(studio)) {
                        studiosAux.add(studios.get(studios.indexOf(studio)));
                    }
                }
                
                movie.setProducers(producersAux);
                movie.setStudios(studiosAux);
			}
			
			movieRepository.saveAll(movies);
		} catch (IOException e) {
			log.error("Failed to load data from " + filename, e);
			
		}
	}

    private CsvToBean<MovieFile> loadMoviesFile(String filename, char separator) throws IllegalStateException, FileNotFoundException {
        return new CsvToBeanBuilder<MovieFile>(new FileReader(filename))
        		.withSeparator(separator)
        		.withType(MovieFile.class)
        		.build();
    }

    

}
