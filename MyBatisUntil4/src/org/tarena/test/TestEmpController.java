package org.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.controller.EmpController;

public class TestEmpController {
	/**
	 * 测试查询员工
	 */
	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmpController empController = ctx.getBean( "empController" ,EmpController.class);
		empController.find();
	}
}
