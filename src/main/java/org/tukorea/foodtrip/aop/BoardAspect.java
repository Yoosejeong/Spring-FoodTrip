package org.tukorea.foodtrip.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.tukorea.foodtrip.domain.BoardVO;
import org.tukorea.foodtrip.domain.UserVO;

@Aspect
@Component
public class BoardAspect {
	private static final Logger logger = LoggerFactory.getLogger(BoardAspect.class);

	@Before("execution(* org.tukorea.foodtrip.persistence.*.*(..))")
	public void beforeMethod(JoinPoint jp) {
	    System.out.println("[BeforeMethod] : 메소드 호출");
	    Signature sig = jp.getSignature();
	    System.out.println("이전: " + sig.getName());
	    Object[] obj = jp.getArgs();
	    if (obj.length > 0) {
	        System.out.println("호출: " + obj[0]);
	    } else {
	        System.out.println("호출: 인자 없음");
	    }
	}
	@After("execution(* org.tukorea.foodtrip.persistence.*.*(..))")
	public void afterMethod() {
		System.out.println("[AfterMethod] : 메소드 호출 후 ");
	}
	
	
}

