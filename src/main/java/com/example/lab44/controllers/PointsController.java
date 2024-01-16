package com.example.lab44.controllers;

import com.example.lab44.model.PointData;
import com.example.lab44.services.PointService;
import com.example.lab44.utils.AreaChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PointsController {

    private final PointService pointService;
    @PostMapping(value = "/points")
    public ResponseEntity<?> add(@RequestBody PointData pointData){
        long startTime = System.currentTimeMillis();
        pointData.setHit(AreaChecker.areaCheck(pointData.getCoordinateX(),pointData.getCoordinateY(),pointData.getScaleR()));
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        pointData.setCurrentDate(dateFormat.format(date));
        long endTime = System.currentTimeMillis();
        double totalTime = (double) (endTime - startTime) / 1000;
        pointData.setScriptRunningTime(totalTime);
        PointData point = pointService.addPoint(pointData);
        return point!=null
                ? new ResponseEntity<>(point,HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping(value = "/points")
    public ResponseEntity<List<PointData>> read(){
        final List<PointData> points = pointService.getAllPoints();
        return new ResponseEntity<>(points,HttpStatus.OK);
    }
    @DeleteMapping(value = "/points")
    public ResponseEntity<?> delete(){
        pointService.removeAllPoints();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
