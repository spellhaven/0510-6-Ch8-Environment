package com.spellhaven.spring0510_6;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware, InitializingBean, DisposableBean {
	
	private String adminId;
	private String adminPw;
	
	private Environment env; //이게 있어야 setEnvironment(Environment env)의 매개변수로 넣을 수 있지.
	
	
	@Override
	public void setEnvironment(Environment env) {
		System.out.println("setEnvironment 메소드 호출됨, ㅋ");
		setEnv(env);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception { // Bean 초기화 시점에서 자동 호출되는 메소드
		System.out.println("afterPropertiesSet 메소드 호출됨, ㅋ");
		setAdminId(env.getProperty("admin.Id"));
		setAdminPw(env.getProperty("admin.Pw"));
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy 메소드 호출됨, ㅋ");
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

}
