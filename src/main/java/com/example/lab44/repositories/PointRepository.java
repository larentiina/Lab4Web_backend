package com.example.lab44.repositories;

import com.example.lab44.model.PointData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface PointRepository extends JpaRepository<PointData,Integer> {

}
