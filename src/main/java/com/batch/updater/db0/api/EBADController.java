package com.batch.updater.db0.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.batch.updater.db0.model.Account;
import com.batch.updater.db0.model.EBAD;
import com.batch.updater.db0.service.AccountService;
import com.batch.updater.db0.service.EBADService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/api/v1/ebad")
public class EBADController {
	
	@Autowired private EBADService service;
	
	@GetMapping
	public String list(@RequestParam("id") String account)
    {
		System.out.println("show:: " + account);
		
		List<EBAD> aList = service.findAll();
		for (EBAD a : aList)
			System.out.println("name:: " + a.getPOST_ID());
				
	    return "show:: " + account;
	}
}