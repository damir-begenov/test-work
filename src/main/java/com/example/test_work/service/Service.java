package com.example.test_work.service;

import com.example.test_work.entity.Input;
import com.example.test_work.entity.busStops;
import com.example.test_work.repo.BusStopsRepo;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {
    private final BusStopsRepo busStopsRepos;

    public busStops createBus(busStops busStops){
        return busStopsRepos.save(busStops);
    }

    public Input getInput(int from, int to){
        List<busStops> busStopsList = busStopsRepos.findAll();
        Input input = new Input();
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

