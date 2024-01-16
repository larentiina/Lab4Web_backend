package com.example.lab44.services;

import com.example.lab44.model.PointData;

import java.util.List;

public interface PointService {
    PointData addPoint(PointData pointData);
    List<PointData> getAllPoints();
    void removeAllPoints();
}
