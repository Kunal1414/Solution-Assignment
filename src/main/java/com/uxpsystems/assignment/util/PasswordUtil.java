package com.uxpsystems.assignment.util;

import javax.annotation.PostConstruct;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtil {
	private BCryptPasswordEncoder encoder;

	public static PasswordUtil instance;

	public PasswordUtil() {

		encoder = new BCryptPasswordEncoder();
	}

	@PostConstruct
	public void init() {
		PasswordUtil.instance = this;
	}

	public PasswordEncoder getPasswordEncoder() {
		return encoder;

	}

}
