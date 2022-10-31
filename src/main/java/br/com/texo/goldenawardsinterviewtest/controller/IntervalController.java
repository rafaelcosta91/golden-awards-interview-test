package br.com.texo.goldenawardsinterviewtest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.texo.goldenawardsinterviewtest.entity.AwardIntervalResponse;
import br.com.texo.goldenawardsinterviewtest.enums.IntervalType;
import br.com.texo.goldenawardsinterviewtest.service.IntervalService;

@RestController
public class IntervalController {
    Logger log = LoggerFactory.getLogger(IntervalController.class);
            
    @Autowired
    IntervalService intervalService;
    
    @GetMapping("/intervals")
    public ResponseEntity<AwardIntervalResponse> getIntervals() {
        log.info("Loading intervals::Start");
        AwardIntervalResponse response = AwardIntervalResponse.builder()
                .max(intervalService.getInterval(IntervalType.MAX))
                .min(intervalService.getInterval(IntervalType.MIN))
                .build();
        log.info("Loading intervals::Success");
        return ResponseEntity.ok(response);
    }
}   
