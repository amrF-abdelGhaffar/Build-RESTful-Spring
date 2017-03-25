package com.mazmy.service.car;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mazmy.SpringBaseTest;
import com.mazmy.domainobject.CarDO;
import com.mazmy.domainvalue.EngineType;
import com.mazmy.exception.ConstraintsViolationException;
import com.mazmy.exception.EntityNotFoundException;

public class CarServiceTest extends SpringBaseTest{

	@Autowired
	private CarService carService;
	
	@Test
	public void testFind() throws EntityNotFoundException {
		long carId = 7;
		CarDO find = carService.find(carId);
		assertNotNull(find);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testFindExc() throws EntityNotFoundException {
		long carId = 15;
		carService.find(carId);
	}

	@Test
	public void testFindCarChecked() throws EntityNotFoundException {
		long carId = 8;
		CarDO find = carService.find(carId);
		assertNotNull(find);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testFindCarCheckedExc() throws EntityNotFoundException {
		long carId = 15;
		carService.find(carId);
	}
	
	@Test(expected = ConstraintsViolationException.class)
	public void testCreateEx() throws ConstraintsViolationException, EntityNotFoundException{
		CarDO carDO = carService.find(2L);
		carDO.setLicensePlate("D M RY 417");
		carService.create(carDO);
	}
	
	@Test
	public void testDelete() throws EntityNotFoundException {
		long carId = 6;
		carService.delete(carId);
		assertTrue(true);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteEx() throws EntityNotFoundException{
		long carId = 6;
		carService.delete(carId);
	}
	
	@Test
	public void testFindByEngineType(){
		String engineType = "water";
		List<CarDO> findByEngineType = carService.findByEngineType(engineType);
		assertEquals(Integer.valueOf(0), Integer.valueOf(findByEngineType.size()));
		engineType = EngineType.PETROL.type();
		List<CarDO> findByEngineType2 = carService.findByEngineType(engineType);
		assertNotEquals(Integer.valueOf(0), Integer.valueOf(findByEngineType2.size()));
	}
	
	@Test
	public void testFindByConvertible(){
		boolean convertible = true;
		List<CarDO> findByEngineType = carService.findByConvertible(convertible);
		assertNotEquals(Integer.valueOf(0), Integer.valueOf(findByEngineType.size()));
	}
	
	@Test
	public void testFindByManufacturer(){
		String manufacturerContain = "m";
		List<CarDO> findByManufacturer = carService.findByManufacturer(manufacturerContain);
		assertNotEquals(Integer.valueOf(0), Integer.valueOf(findByManufacturer.size()));
	}
}
