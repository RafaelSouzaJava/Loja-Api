package com.example.rafael.api.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.example.rafael.api.security.UserSS;

public class UserService {

	public static UserSS authenticated() {
		try {
		return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
