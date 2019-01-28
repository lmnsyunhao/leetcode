package com.yunhao.Algorithms.Algorithms_274;

import java.util.Arrays;

//binary search
class Solution {
    public int hIndex(int[] citations) {
    	Arrays.sort(citations);
    	int left = 0, right = citations.length - 1;
    	while(left < right) {
    		int mid = (left + right) / 2;
    		if(citations[mid] < citations.length - mid)
    			left = mid + 1;
    		else if (mid - 1 >= 0 && citations[mid-1] > citations.length - mid)
    			right = mid - 1;
    		else {
    			left = mid;
    			break;
    		}
    	}
    	int ret = citations.length - left;
    	if(left == citations.length - 1) {
    		ret = Math.min(ret, citations[left]);
    	}
        return ret;
    }
}

public class Algorithms_274 {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] citations = new int[] {1,2,2,2};
		System.out.println(s.hIndex(citations));
	}
}
