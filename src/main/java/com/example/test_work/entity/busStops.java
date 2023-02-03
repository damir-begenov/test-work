package com.example.test_work.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Entity
@Data
public class busStops {
    @Id
    private int id;
    private int[] stops;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getStops() {
        return stops;
    }

    public void setStops(int[] stops) {
        this.stops = stops;
    }

    @Override
    public String toString() {
        return "busStops{" +
                "id='" + id + '\'' +
                ", stops=" + stops +
                '}';
    }
}

