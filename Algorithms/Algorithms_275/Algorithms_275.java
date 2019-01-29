package com.yunhao.Algorithms.Algorithms_275;

import java.util.Arrays;

//binary search
class Solution {
  public int hIndex(int[] citations) {
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

public class Algorithms_275 {

}
