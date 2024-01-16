package com.example.lab44.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table
@AllArgsConstructor
public class PointData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Double coordinateY;

    private Double coordinateX;

    private double scaleR;

    private  boolean isHit;

    private  String currentDate;

    private  double scriptRunningTime;
}
