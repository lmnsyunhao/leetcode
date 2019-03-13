package com.yunhao.Algorithms.Algorithms_3;

import java.util.HashMap;
import java.util.Map;

//
class Solution {
    public int lengthOfLongestSubstring(String s) {
    	if(s.length() == 0)
    		return 0;
    	
        int[] lastIdx = new int[s.length()];
        Map<String, Integer> m1 = new HashMap();
        for(int i = 0; i < s.length(); i++) {
        	lastIdx[i] = -1;
        	if(m1.containsKey(s.substring(i, i+1))) {
        		lastIdx[i] = m1.get(s.substring(i, i+1)).intValue();
        	}
    		m1.put(s.substring(i, i+1), new Integer(i));
        }
        m1.clear();
        
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int res = 1;
        for(int i = 1; i < s.length(); i++) {
        	if(lastIdx[i] != -1) {
        		dp[i] = Math.min(dp[i-1]+1, i-lastIdx[i]);
        	}
        	else {
        		dp[i] = dp[i-1]+1;
        	}
        	res = Math.max(res, dp[i]);
        }
        return res;
    }
}

public class Algorithms_3 {
	public static void main(String[] args) {
		Solution solve = new Solution();
		System.out.println(solve.lengthOfLongestSubstring("tmmzuxt"));
	}
}
