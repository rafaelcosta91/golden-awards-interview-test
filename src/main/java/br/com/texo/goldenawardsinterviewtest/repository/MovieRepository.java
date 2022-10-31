package br.com.texo.goldenawardsinterviewtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.texo.goldenawardsinterviewtest.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
