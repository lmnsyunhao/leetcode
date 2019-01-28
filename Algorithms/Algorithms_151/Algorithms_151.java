package com.yunhao.Algorithms.Algorithms_151;

class Solution {
	//ÓÃÕ»
	public boolean isValid(char c) {
		if(c >= 33 && c <= 127) return true;
		if(c >= 'a' && c <= 'z') return true;
		if(c >= 'A' && c <= 'Z') return true;
		if(c >= '0' && c <= '9') return true;
		return false;
	}
	
    public String reverseWords(String s) {
    	int[] stk = new int[s.length()];
    	int cur = 0;
    	char[] res = new char[s.length()+1];
    	int idx = 0;
    	
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == ' ') continue;
        	stk[cur++] = i;
        	while(i < s.length() && isValid(s.charAt(i)))
        		i++;
        }
        while(cur > 0) {
        	for(int i = stk[cur-1]; i < s.length() && isValid(s.charAt(i)); i++) {
        		res[idx++] = s.charAt(i);
        	}
        	res[idx++] = ' '; 
        	cur--;
        }
        if(idx == 0) {
        	return "";
        }
        String ret = new String(res);
        ret = ret.trim();
        return ret;
    }
}

public class Algorithms_151 {
	public static void main(String[] args) {
		String s = " 1";
		Solution solve = new Solution();
		System.out.println(solve.reverseWords(s));
	}
}
