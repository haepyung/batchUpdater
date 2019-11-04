package com.batch;

import org.junit.Test;

public class DateTimeUTCTest
{
	@Test
	public void onTest()
	{
		/**
		 * 제한사항
			표(board)는 2차원 배열로 주어집니다.
			표(board)의 행(row)의 크기 : 1,000 이하의 자연수
			표(board)의 열(column)의 크기 : 1,000 이하의 자연수
			표(board)의 값은 1또는 0으로만 이루어져 있습니다.	
		 */
		int [][]board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}; //9
		
		// 4 * 4  > 3 * 4 > 3 * 4 >
		System.out.println("[RESULT] : " + solution(board));
	}
	
	public int solution(int [][]board)
    {
        int answer = 1234;

        return answer;
    }

}
