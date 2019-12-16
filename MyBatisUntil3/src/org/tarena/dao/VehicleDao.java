package org.tarena.dao;

import java.util.List;

import org.tarena.annotation.MyBatisRepository;
import org.tarena.entity.Vehicle;

@MyBatisRepository
public interface VehicleDao {
	List<Vehicle> findAll();
}
