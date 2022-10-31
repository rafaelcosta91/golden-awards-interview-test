package br.com.texo.goldenawardsinterviewtest.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;
    
    @Column
    private String title;
    
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Producer.class)
    @EqualsAndHashCode.Exclude
    private List<Producer> producers;
    
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Studio.class)
    @EqualsAndHashCode.Exclude
    private List<Studio> studios;
    
    @Column
    private Boolean winner;
    
    @Column
    private Integer releaseYear;

}
