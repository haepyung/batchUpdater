package com.batch;

import org.junit.Test;

public class DateTimeUTCTest
{
	@Test
	public void onTest()
	{
		int n = 15;
		System.out.println("[RESULT] : " + solution(n));
	}
	
	public int solution(int n)
    {
        int answer = 0;
        String temp = Integer.toBinaryString(n).replaceAll("0", "");
        for (int num = n + 1; num <= 1000000; num++)
        	if (Integer.toBinaryString(num).replaceAll("0", "").equals(temp)) return num;

        return answer;
    }

}
