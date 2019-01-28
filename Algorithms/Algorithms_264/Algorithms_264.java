package com.yunhao.Algorithms.Algorithms_264;

//dp
class Solution {
    public int nthUglyNumber(int n) {
    	int[] ugly = new int[2000];
    	ugly[0] = 1;
    	int two = 0, three = 0, five = 0;
    	int cur = 1;
    	for (int i = 0; i < n-1; i++) {
    		int restwo = 2*ugly[two];
    		int resthree = 3*ugly[three];
    		int resfive = 5*ugly[five];
    		if(restwo < resthree) {
    			if(restwo < resfive) {
    				ugly[cur++] = restwo;
    				two++;
    			}
    			else {
    				ugly[cur++] = resfive;
    				five++;
    			}
    		}
    		else{
    			if(resthree < resfive) {
    				ugly[cur++] = resthree;
    				three++;
    			}
    			else {
    				ugly[cur++] = resfive;
    				five++;
    			}
    		}
    		if(ugly[cur-1] == ugly[cur-2]) {
    			i--;
    			cur--;
    		}
    	}
    	return ugly[n-1];
    }
}

public class Algorithms_264 {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.nthUglyNumber(10));
	}
}
