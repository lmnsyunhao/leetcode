package com.yunhao.Algorithms.Algorithms_279;

//IDDFS
class Solution {
	public boolean isSquareNum(int num) {
		for (int i = 1; i*i <= num; i++) {
			if (i*i == num)
				return true;
		}
		return false;
	}
	
	public boolean iddfs(int mx, int depth, int num) {
		if(depth > mx) return false;
		if(depth == mx && isSquareNum(num)) return true;
		for(int i = 1; i*i <= num / (mx-depth+1); i++) {
			if(iddfs(mx, depth+1, num - i*i)) {
				return true;
			}
		}
		return false;
	}
	
    public int numSquares(int n) {
    	for (int i = 1; i <= n; i++) {
    		if(iddfs(i, 1, n))
    			return i;
    	}
    	return n;
    }
}

public class Algorithms_279 {
	public static void main(String[] args) {
		Solution solve = new Solution();
		System.out.println(solve.numSquares(17));
	}
}