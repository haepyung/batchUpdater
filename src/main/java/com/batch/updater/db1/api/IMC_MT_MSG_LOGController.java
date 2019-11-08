package com.batch.updater.db1.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.batch.updater.db1.model.IMC_MT_MSG_LOG;
import com.batch.updater.db1.service.IMC_MT_MSG_LOGService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/api/v1/msglog")
public class IMC_MT_MSG_LOGController {
	
	@Autowired private IMC_MT_MSG_LOGService service;
	
	@GetMapping
	public String list(@RequestParam("id") String custom)
    {
		System.out.println("show:: " + custom);
		
		List<IMC_MT_MSG_LOG> cList = service.findAll();
		for (IMC_MT_MSG_LOG c : cList)
			System.out.println("name:: " + c.getID());
	    return "show:: " + custom;		
	}
}