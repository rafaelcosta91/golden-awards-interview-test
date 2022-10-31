package br.com.texo.goldenawardsinterviewtest.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AwardIntervalResponse {
    List<AwardInterval> max;
    List<AwardInterval> min;
}