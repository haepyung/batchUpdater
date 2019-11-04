package com.batch.updater.db1.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.batch.updater.db1.model.Custom;
import com.batch.updater.db1.service.CustomService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/api/v1/custom")
public class CustomController {
	
	@Autowired @Lazy private AuthenticationManager authenticationManager;
	@Autowired private CustomService service;
	
	@GetMapping
	public String list(@RequestParam("id") String custom)
    {
		System.out.println("show:: " + custom);
		
		List<Custom> cList = service.findAll();
		for (Custom c : cList)
			System.out.println("name:: " + c.getName());
	    return "show:: " + custom;		
	}
}