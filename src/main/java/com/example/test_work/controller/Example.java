package com.example.test_work.controller;

import com.example.test_work.entity.busStops;
import com.example.test_work.entity.Input;
import com.example.test_work.repo.BusStopsRepo;
import com.example.test_work.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class Example {

    private final Service service;

    @PostMapping("/api/create/bus")
    public busStops createBuss(@RequestBody busStops busStops){
        return service.createBus(busStops);
    }
    @GetMapping("/api/test/{from}/{to}")
    public Input firstt(@PathVariable(name = "from") int from, @PathVariable(name = "to") int to){
        return service.getInput(from,to);
    }
}