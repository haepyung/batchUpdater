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

public class ParserUtil
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
		String header ="OK: pushpia-cn-tunnel: Mem: pushpia-cn-tunnel Memory usage over 80%";
		//String header ="OK: https://openapi-push.tason.com:444/ping: DBMS: Connection Failed";
		// Fwd: OK: https://openapi-push.tason.com:444/ping Connection Failed
		
		// http://  https:// 이 없는데 4개 안되는 경우 실패 처리 insert
		// 4개 인경우는 그대로 처리
		// 4개 초과인경우 앞에서 한개 뒤에서 두개 외 나머지 insert
        
		String [] infos = header.split(":");
		Properties result = null;
		Date sendDate = new Date();
		if (infos.length == 4 && !header.contains("http:") && !header.contains("https:")) result = succes(infos, sendDate);
		else if (infos.length > 4 && (header.contains("http:") | header.contains("https:"))) result = succes(infos, sendDate);
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
		
	
	@Data
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
