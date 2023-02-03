package com.example.test_work.repo;

import com.example.test_work.entity.busStops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusStopsRepo extends JpaRepository<busStops, Long> {
}
