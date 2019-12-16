package org.tarena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp/")
public class EmpController {

	/**
	 * 查询员工
	 * @return
	 */
	@RequestMapping("findEmp.do")
	public String find() {
		//模拟查询员工数据
		System.out.println("查询员工数据 发送至列表页面");
		//制造一个异常
		//空指针异常
		/*String s = null ;
		s.length();*/
		Integer.valueOf("abc") ;
		//int a = 2/0;
		return "list.jsp";
	}
}
