package com.batch;

import org.junit.Test;

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
		String [] temp = header.split(":");
		
		//TODO 유효성검사
		if (temp.length != 4)
		{
			System.out.printf("[Fail] :: 문자열 파싱 결과 실패(본문에 ':'가 3개 있는지 확인 필요");
			return;
		}
		
		System.out.println("[ORI] :: " + header + ", SIZE:: " + temp.length);
		for (String s : temp)
			System.out.println("[RESULT] :: " + s);
	}


}
