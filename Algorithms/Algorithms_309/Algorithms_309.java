package com.yunhao.Algorithms.Algorithms_309;

class Solution {
	//dp
    public int maxProfit(int[] prices) {
    	if(prices.length == 0) 
    		return 0;
    	int ret = 0;
    	int[][] dp = new int[prices.length + 1][4];
    	dp[1][0] -= prices[0];
    	dp[1][1] = 0;
    	dp[1][2] -= (prices[0] + 1);
    	dp[1][3] = 0;
    	for(int i = 1; i < prices.length; i++) {
    		dp[i+1][0] = dp[i][3] - prices[i];
    		dp[i+1][1] = Math.max(dp[i][0], dp[i][2]) + prices[i];
    		dp[i+1][2] = Math.max(dp[i][0], dp[i][2]);
    		dp[i+1][3] = Math.max(dp[i][1], dp[i][3]);
    	}
    	ret = Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    	ret = Math.max(ret, dp[dp.length - 1][2]);
    	ret = Math.max(ret, dp[dp.length - 1][3]);
        return ret;
    }
}

public class Algorithms_309 {
	public static void main(String[] args) {
		
	}
}
