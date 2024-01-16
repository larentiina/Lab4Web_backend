package com.example.lab44.services;

import com.example.lab44.model.PointData;
import com.example.lab44.repositories.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PointServiceImpl implements PointService{

    @Autowired
    private PointRepository pointRepository;

    @Override
    public PointData addPoint(PointData pointData) {
        return pointRepository.save(pointData);
    }

    @Override
    public List<PointData> getAllPoints() {
        return pointRepository.findAll();
    }

    @Override
    public void removeAllPoints() {
        pointRepository.deleteAll();
    }
}
