package com.yunhao.Algorithms.Algorithms_29;

import java.util.ArrayList;

class Solution {
	//边界值真的恶心
    public int divide(int dividend, int divisor) {
    	long beichushu = dividend, chushu = divisor;
    	int sign = 1;
    	if((beichushu > 0 && chushu < 0) || (beichushu < 0 && chushu > 0))
    		sign = -1;
    	if(beichushu < 0) beichushu *= -1;
    	if(chushu < 0) chushu *= -1;
    	if(chushu == 1) {
    		if(beichushu - 1 == Integer.MAX_VALUE && sign == 1) {
    			beichushu --;
    		}
    		return (int)(beichushu * sign);
    	}
    	
    	int idx = 0;
    	long[] mark = new long[50];
    	long[] cnt_mark = new long[50];
    	
    	long div = chushu;
    	int cnt = 1;
    	
        while(beichushu > div) {
        	mark[idx] = div;
        	cnt_mark[idx] = cnt;
        	idx++;
        	div += div;
        	cnt += cnt;
        }
        int shang = 0;
        while(beichushu >= chushu) {
        	if(beichushu >= div) {
        		shang += cnt;
        		beichushu -= div;
        	}
        	else {
        		div -= mark[idx - 1];
        		cnt -= cnt_mark[idx - 1];
        		idx--;
        	}
        }
        return shang * sign;
    }
}

public class Algorithms_29 {
	public static void main(String[] args) {
		Solution solve = new Solution();
		System.out.println(solve.divide(-2147483648
				, -1));
	}
}
