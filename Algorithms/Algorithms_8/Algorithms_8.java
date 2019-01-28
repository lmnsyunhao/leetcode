package com.yunhao.Algorithms.Algorithms_8;

class Solution {
	//边界值判断非常多
	public boolean isNum(char c) {
		return c >= '0' && c <='9'; 
	}
	
    public int myAtoi(String str) {
    	int[] s = new int[str.length()];
    	int[] max = new int[] {2,1,4,7,4,8,3,6,4,8};
    	int idx = 0;
    	boolean stt = false;
    	boolean trim_first_zero = false;
    	int sign = 1;
        for(int i = 0; i < str.length(); i++) {
        	if(!stt && str.charAt(i) == ' ')
        		continue;
        	if(!stt && str.charAt(i) != '-' && str.charAt(i) != '+' && !isNum(str.charAt(i)))
        		return 0;
        	if(!stt && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
        		stt = true;
        		sign = str.charAt(i) == '-' ? -1 : 1;
        		continue;
        	}
    		stt = true;
    		if(!isNum(str.charAt(i))) break;
    		if(!trim_first_zero && str.charAt(i) == '0') continue;
    		trim_first_zero = true;
    		s[idx++] = str.charAt(i) - '0';
        }
        if(idx > 10) 
        	return sign * Integer.MIN_VALUE - (sign+1)/2;
        boolean hasResult = true;
        if(idx == 10){
        	if(sign == -1)
        		max[9] = 8;
        	else
        		max[9] = 7;
        	for (int i = 0; i < idx; i++) {
        		if(s[i] == max[i])
        			continue;
        		else if(s[i] > max[i]) {
        			hasResult = false;
        			break;
        		}
        		else {
        			break;
        		}
        	}
        }
        if(!hasResult)
        	return sign * Integer.MIN_VALUE - (sign+1)/2;
        int sum = 0;
        for (int i = 0; i < idx; i++) {
        	sum *= 10;
        	sum += s[i];
        }
        return sum * sign;
    }
}

public class Algorithms_8 {
	public static void main(String[] args) {
		Solution sss = new Solution();
		String str = "2147483648";
		sss.myAtoi(str);
	}
}
