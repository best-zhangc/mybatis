package org.tarena.entity;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.dao.VehicleDao;

public class TestMapping {

	/**
	 * 鉴别器
	 * 查询汽车表  根据类型封装成不同的对象
	 */
	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		VehicleDao vehicleDao = ctx.getBean("vehicleDao", VehicleDao.class);
		List<Vehicle> list = vehicleDao.findAll();
		for (Vehicle v : list) {
			System.out.println(v);
			
		}
	}
}
