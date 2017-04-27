package com.lwq.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyPorxy {

	private static final Logger logger = LoggerFactory.getLogger(MyPorxy.class);

	public void breforPerformance() {
		System.out.println("MyProxy breforPerformance().");
		logger.info("MyProxy breforPerformance().");
	}

	public void afterPerformance() {
		System.out.println("MyProxy afterPerformance().");
		logger.info("MyProxy afterPerformance().");
	}

	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		// 加逻辑的时候, 不要依赖执行的的先后顺序
		System.out.println("method around start!");
		org.aspectj.lang.Signature signature = pjp.getSignature();
		Object[] obs = pjp.getArgs();
		org.aspectj.lang.JoinPoint.StaticPart part = pjp.getStaticPart();
		Object o = pjp.getTarget();
		System.out.println("methodName:"+o.getClass().getName()+"."+pjp.getSignature().getName());
		System.out.println("method around end!");
		return pjp.proceed();
	}
}
