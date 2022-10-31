package br.com.texo.goldenawardsinterviewtest.entity;

import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieFile {
	@CsvBindByName(required = true, column = "year")
	private Integer year;
	
	@CsvBindByName(required = true, column = "title")
	private String title;
	
	@CsvBindByName(required = true, column = "studios")
	private String studios;
	
	@CsvBindByName(required = true, column = "producers")
	private String producers;
	
	@CsvBindByName(required = false, column = "winner")
	private String winner;
}