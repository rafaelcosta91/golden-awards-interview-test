package br.com.texo.goldenawardsinterviewtest.entity;

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
public class AwardInterval {
    String producer;
    Integer interval;
    Integer previousWin;
    Integer followingWin;
}