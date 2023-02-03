package com.example.test_work.controller;

import com.example.test_work.entity.busStops;
import com.example.test_work.entity.input;
import com.example.test_work.repo.busStopsRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
public class example {
    private final busStopsRepo busStopsRepos;


    @PostMapping("/api/create/bus")
    public busStops createBus(@RequestBody busStops busStops){
        return busStopsRepos.save(busStops);
    }
    @GetMapping("/api/test/{from}/{to}")
    public input firstt(@PathVariable(name = "from") int from,@PathVariable(name = "to") int to){
        List<busStops> busStopsList = busStopsRepos.findAll();
        input input = new input();
        boolean check = false;
        for(busStops busStopss : busStopsList){
            int[] damir = busStopss.getStops();
            for(int i=0 ; i < damir.length ; i++){
                if(check == true) break;
                for(int j = i+1 ; j < damir.length;j++){
                    if(damir[i] == from & damir[j] == to){
                        input.setTo(to);
                        input.setFrom(from);
                        input.setDirect(true);
                        check = true;
                        break;
                    }
                    input.setTo(to);
                    input.setFrom(from);
                    input.setDirect(false);
                }
            }
        }
        return input;
    }
}