package org.tarena.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.entity.Emp;

@Controller
@RequestMapping("/test/")
public class JsonController {
	
	@RequestMapping("test1.do")
	@ResponseBody
	public boolean test1() {
		return true ;
	}
	
	@RequestMapping("test2.do")
	@ResponseBody
	public Map<String, Object> test2(){
		Map<String, Object> map = new HashMap<String , Object>();
		map.put("id", 16);
		map.put("name", "刘备");
		return map ;
	}
	
	@RequestMapping("test3.do")
	@ResponseBody
	public List<String> test3(){
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb") ;
		list.add("ccc") ;
		return list;
	}
	
	@RequestMapping("test4.do")
	@ResponseBody
	public Emp test4() {
		Emp emp = new Emp();
		emp.setEmpno(11);
		emp.setEname("刘畅");
		emp.setAge(22);
		return emp ;
	}
	
	@RequestMapping("test5.do")
	@ResponseBody
	public List<Emp> test5(){
		List<Emp> list = new ArrayList<Emp>();
		Emp e1 = new Emp();
		e1.setEmpno(1);
		e1.setEname("aaa");
		e1.setSal(20.0);
		e1.setAge(20);
		list.add(e1);
		
		Emp e2 = new Emp();
		e2.setEmpno(1);
		e2.setEname("bbb");
		e2.setSal(30.0);
		e2.setDeptno(20);
		list.add(e2);
		
		Emp e3 = new Emp();
		e3.setEmpno(1);
		e3.setEname("ccc");
		e3.setSal(22.0);
		e3.setAge(12);
		e3.setDeptno(10);
		list.add(e3);
		
		return list;
		
	}
}
