package com.yunhao.Algorithms.Algorithms_241;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

//±©Á¦
class Solution {
	public List<Integer> [][] ary;
    public List<Integer> diffWaysToCompute(String input) {
    	int numsnum = 0;
    	int operatorsnum = 0;
    	int[] input_nums = new int[input.length()];
    	char[] input_operators = new char[input.length()];
    	
    	int begin = 0;
    	for (int i = 0; i < input.length(); i++) {
    		if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
    			input_nums[numsnum++] = Integer.parseInt(input.substring(begin, i));
    			input_operators[operatorsnum++] = input.charAt(i);
    			begin = i+1;
    		}
    	}
		input_nums[numsnum++] = Integer.parseInt(input.substring(begin));
    	
    	ary = new List[numsnum][numsnum];
    	for(int i = 0; i < numsnum; i++) {
    		ary[i][i] = new ArrayList<>();
    		ary[i][i].add(new Integer(input_nums[i]));
    	}
    	
    	for(int len = 2; len <= numsnum; len++) {
    		for(int stt = 0; stt <= numsnum-len; stt++) {
    			int edd = stt + len - 1;
    			ary[stt][edd] = new ArrayList<Integer>();
    			for(int split = stt; split <= edd-1; split++) {
    				int first_stt = stt, first_edd = split;
    				int second_stt = split+1, second_edd = edd;
					int operatorIdx = (first_edd + second_stt) / 2;
    				Iterator<Integer> first_it = ary[first_stt][first_edd].iterator();
    				while(first_it.hasNext()) {
    					Iterator<Integer> second_it = ary[second_stt][second_edd].iterator();
    					int first_it_val = first_it.next().intValue();
    					while(second_it.hasNext()) {
    						int second_it_val = second_it.next().intValue();
        					Integer res;
        					if(input_operators[operatorIdx] == '+') {
        						res = new Integer(first_it_val + second_it_val);
        					}
        					else if(input_operators[operatorIdx] == '-') {
        						res = new Integer(first_it_val - second_it_val);
        					}
        					else {
        						res = new Integer(first_it_val * second_it_val);
        					}
    						ary[stt][edd].add(res);
    					}
    				}
    			}
    		}
    	}
    	Iterator<Integer> it = ary[0][numsnum-1].iterator();
    	List<Integer> list = new ArrayList<Integer>();
    	while(it.hasNext()){
    		list.add(it.next());
    	}
    	list.sort(null);
    	return list;
    }
}

public class Algorithms_241 {
	public static void main(String[] args) {
		String s = "2*3-4*5";
		Solution solve = new Solution();
		List<Integer> list = solve.diffWaysToCompute(s);
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
