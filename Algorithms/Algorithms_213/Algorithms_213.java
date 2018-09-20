package com.yunhao.Algorithms.Algorithms_213;

class Solution {
	//dp
	int[][] dp1;
	int[][] dp2;
    public int rob(int[] nums) {
    	//×¢ÒâÌØÅĞ¶Ëµã¡£
    	int ret = 0;
    	if (nums.length == 0) {
    		return ret;
    	}
    	else if(nums.length == 1) {
    		ret = nums[0];
    		return ret;
    	}
    	else if(nums.length == 2) {
    		ret = Math.max(nums[0], nums[1]);
    		return ret;
    	}
    	
    	dp1 = new int[nums.length][2];//rob the first one
    	dp2 = new int[nums.length][2];//not rob the first one
    	
    	dp1[2][0] = nums[2];
    	for (int i = 3; i < nums.length - 1; i++) {
    		dp1[i][0] = dp1[i-1][1] + nums[i];
    		dp1[i][1] = Math.max(dp1[i-1][0], dp1[i-1][1]);
    	}
    	int res1 = Math.max(dp1[nums.length-2][0], dp1[nums.length-2][1]) + nums[0];
    	
    	dp2[1][0] = nums[1];
    	for (int i = 2; i < nums.length; i++) {
    		dp2[i][0] = dp2[i-1][1] + nums[i];
    		dp2[i][1] = Math.max(dp2[i-1][0], dp2[i-1][1]);
    	}
    	int res2 = Math.max(dp2[nums.length-1][0], dp2[nums.length-1][1]);
    	ret = Math.max(res1, res2);
    	
        return ret;
    }
}

public class Algorithms_213 {

}
