package com.xm.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LogAspects {

	/**
	 * 抽取公共的切入点表达式
	 */
	@Pointcut("execution(public int com.xm.demo.aop.MathCalculator.*(..))")
	public void pointCut() {
	}


	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		String methodName = joinPoint.getSignature().getName();
		System.out.printf("方法：%s 即将运行，参数列表：%s，切面类：logStart 方法\n",
				methodName, Arrays.asList(args));
	}

	@After("com.xm.demo.aop.LogAspects.pointCut()")
	public void logEnd(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.printf("方法：%s 结束，切面类：logEnd 方法\n", methodName);
	}

	@AfterReturning(value = "pointCut()", returning = "result")
	public void logReturn(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.printf("方法：%s 正常返回,返回结果：%s，切面类：logReturn方法\n",
				methodName, result);
	}

	@AfterThrowing(value = "pointCut()", throwing = "exception")
	public void logException(JoinPoint joinPoint, Exception exception) {
		String methodName = joinPoint.getSignature().getName();
		System.out.printf("方法：%s 异常,exception：%s，切面类：logException方法\n",
				methodName, exception);
	}

}