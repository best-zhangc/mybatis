package org.tarena.aspect;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的的方面组件
 * 演示Spring Aop的各种通知类型
 * 基于注解
 * @author zhangchao
 */

@Component
@Aspect
public class OperateLogger {
	
	/**
	 * 前置通知:@Before 先执行方面功能 在执行目标功能
	 * 后置通知:@AfterReturning 先执行目标功能 在执行方面功能 (目标功能无异常才执行方面)
	 * 最终通知:@After 先执行目标功能再执行方面功能(目标有无异常都执行方面)
	 */
	@Before("within(org.tarena.controller..*)") 
	public void log1() {
		//记录日志
		System.out.println("*****************>>>>记录用户操作信息");
	}
	
	/**
	 * 环绕通知:@Around  先执行方面前置部分 然后再执行目标 最后再执行方面后置部分
	 * @param p
	 * @return
	 * @throws Throwable
	 */
	@Around("within(org.tarena.controller..*)")
	public  Object log2(ProceedingJoinPoint p) throws Throwable{
		//目标组件的类名
		String className = p.getTarget().getClass().getName();
		//调用的方法名
		String method = p.getSignature().getName();
		//当前系统时间
		String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		//拼日志信息
		String msg ="*****************>>>>" + date + ", 执行了" + className + "." + method +"()";
		//记录日志信息
		System.out.println(msg);
		//执行目标组件的方法
		Object obj = p.proceed();
		//执行目标组件方法后也可以做一些业务处理
		System.out.println("*****************>>>>"+ date + "  调用目标组件业务方法后....");
		return obj;
		
	}
	
	/**
	 *异常通知: 先执行目标  抛出后执行方面
	 * @param e
	 */
	@AfterThrowing(pointcut="within(org.tarena.controller..*)" , throwing="e")
	public void log3(Exception e) {
	StackTraceElement[] elems = e.getStackTrace();	
	System.out.println("*****************>>>>"+elems[0].toString());
	
	}
}
