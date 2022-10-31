package br.com.texo.goldenawardsinterviewtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.texo.goldenawardsinterviewtest.entity.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Long>{

}
