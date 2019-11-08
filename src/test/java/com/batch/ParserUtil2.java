package com.batch;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import lombok.Data;
import lombok.ToString;

public class ParserUtil2
{
	@Test
	public void onTest()
	{
		/**
		 * 해당 해더는 총 ":" 구분자로 4Part로 나눔 가능.
		 * 유효성: split 한 총 길이가 4가 안되면 사이즈 리턴 
		 * (만약, 저장이 목표라면, 해당 필수 값들을 기본 세팅 후 해당전체 본문 별도 컬럼 or 기존 컬럼이 추가)
		 *
		 */	
		String header ="OK: 119.207.76.115: vm.memory.used.percentage: Mem: Memory usage over 80%";
		
		//PROBLEM: 119.207.76.14: vfs.file.cksum[/etc/passwd]: etc: /etc/passwd has been changed on 119.207.76.14
        
		String [] infos = header.split(":");
		
		Properties result = null;
		Date sendDate = new Date();
		if (infos.length == 4 && !header.contains("http:") && !header.contains("https:")) result = succes(infos, sendDate);
		else if (infos.length > 4 && (header.contains("PROBLEM:") | header.contains("OK:"))) result = succes(infos, sendDate);
		else result =fail(header);
		
		if (result != null)
		{
			System.out.println("MSG_ID: " + result.m.get("MSG_ID"));
			System.out.println("SEND_DATE: " + result.m.get("SEND_DATE"));
			System.out.println("STATE: " + result.m.get("STATE"));
			System.out.println("SERVER: " + result.m.get("SERVER"));
			System.out.println("SERVER_SUB: " + result.m.get("SERVER_SUB"));
			System.out.println("RESULT: " + result.m.get("RESULT"));
			System.out.println("CONTENTS: " + result.m.get("CONTENTS"));
			System.out.println("CREATED: " + result.m.get("CREATED"));
		}
	}
	
	private Properties succes(String [] infos, Date sendDate) 
	{
		Properties prop = new Properties();

		prop.setProperty("MSG_ID", UUID.randomUUID().toString());
		prop.setProperty("SEND_DATE", sendDate.toString());
		prop.setProperty("STATE", infos[0]);
		String server = "";
		for (int i = 1; i < infos.length -2; i++) server+=infos[i];
		prop.setProperty("SERVER", server);
		prop.setProperty("SERVER_SUB", infos[infos.length -2]);
		prop.setProperty("CONTENTS", "");
		prop.setProperty("RESULT", infos[infos.length -1]);
		prop.setProperty("CREATED", new Date().toString());
		
		return prop;
	}

	private Properties fail(String header)
	{
		Properties prop = new Properties();
		prop.setProperty("MSG_ID", "FAIL" + UUID.randomUUID().toString());
		prop.setProperty("SEND_DATE", "");
		prop.setProperty("STATE", "INSERT FAIL");
		prop.setProperty("SEVER", "");
		prop.setProperty("SEVER_SUB", "");
		prop.setProperty("RESULT", "");
		prop.setProperty("CONTENTS", header);
		prop.setProperty("CREATED", new Date().toString());
		
		return prop;
	}
		
	@ToString
	public class Properties 
	{
		Map<String, String> m = new HashMap<String, String>(); 
		public void setProperty(String string, String string2) 
		{
			m.put(string, string2);
		}
	}


}
