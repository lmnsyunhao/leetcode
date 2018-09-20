package com.yunhao.Algorithms.Algorithms_313;

class Solution {
	int[] ugly;
    public int nthSuperUglyNumber(int n, int[] primes) {
    	int[] cursor = new int[primes.length];
    	ugly = new int[n];
    	
    	int cur = 0;
    	ugly[cur++] = 1;
    	
    	for(int i = 1; i < n; i++) {
        	int mn = -1;
        	int mnidx = -1;
    		for(int j = 0; j < primes.length; j++) {
    			while(ugly[cursor[j]] * primes[j] <= ugly[cur - 1]) {
    				cursor[j]++;
    			}
    			if(mn == -1) {
    				mn = ugly[cursor[j]] * primes[j];
    				mnidx = j;
    			}
    			else if(mn > ugly[cursor[j]] * primes[j]) {
    				mn = ugly[cursor[j]] * primes[j];
    				mnidx = j;
    			}
    		}
    		cursor[mnidx]++;
    		ugly[cur++] = mn;
    	}
//    	for (int i = 0; i < n; i++) {
//    		System.out.print(ugly[i] + " ");
//    	}
    	return ugly[n-1];
    }
}

public class Algorithms_313 {
	public static void main(String[] args) {
		Solution solve = new Solution();
		int[] primes = new int[] {2,3,7,13,17,23,31,41,43,47};
		solve.nthSuperUglyNumber(45, primes);
	}
}
