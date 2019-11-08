package com.batch;

import org.junit.Test;

public class DateTimeUTCTest
{
	@Test
	public void onTest()
	{
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}}; //16
		System.out.println("[RESULT] : " + solution(land));
	}
	
	public int solution(int[][] land) {
        
		int size = land.length;
		for(int i=1; i< size; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }
        return Math.max(land[size-1][0], Math.max(land[size-1][1], Math.max(land[size-1][2], land[size-1][3])));
    }
}
