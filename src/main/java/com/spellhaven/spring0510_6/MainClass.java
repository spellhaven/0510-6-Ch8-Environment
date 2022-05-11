package com.spellhaven.spring0510_6;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {

	public static void main(String[] args) {
		
		// properties를 applicationCTX에 바로 쓰지 않고 Environment로 가져 오려고 하니, 왕관의 무게는 무겁구나.
		// 교) 사실 얘들 개념은 아주 어려운 게 아닌데, 다들 이름이랑 syntax가 한바가지임;;
		
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment(); // 어 ctx.getBean()이 아니네, ㅋ.
		
		MutablePropertySources propertySources = env.getPropertySources();
		
		// 파일을 불러 오는 놈들은 에러 날 가능성이 크니, try-catch 문으로 감싸서 예외 처리하라고 이클립스가 친절하게 안내한다.
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext) ctx;
		gCtx.load("applicationCTX.xml");
		gCtx.refresh();
		
		AdminConnection adminConn1 = gCtx.getBean("adminConn", AdminConnection.class);
		System.out.println(adminConn1.getAdminId());
		System.out.println(adminConn1.getAdminPw());
		
		gCtx.close();
		ctx.close();
		
	}
}





























