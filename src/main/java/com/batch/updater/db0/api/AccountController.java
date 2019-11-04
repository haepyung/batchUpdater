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
import com.batch.updater.db0.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/api/v1/account")
public class AccountController {
	
	@Autowired @Lazy private AuthenticationManager authenticationManager;
	@Autowired private AccountService service;
	
	@GetMapping
	public String list(@RequestParam("id") String account)
    {
		System.out.println("show:: " + account);
		
		List<Account> aList = service.findAll();
		for (Account a : aList)
			System.out.println("name:: " + a.getName());
		
		
	    return "show:: " + account;
	}
	
	//@AuthenticationPrincipal
	@PostMapping("/signup")
	public boolean signup(@RequestBody Account member) 
	{
		BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
		//service.save(member);
		return false;
	}
	
	@PostMapping(value="/signin")
    public boolean signin(@RequestParam("name") String name, @RequestParam("pw") String pw) 
	{
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(name, pw);
		Authentication authentication = authenticationManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return true;
    }
}