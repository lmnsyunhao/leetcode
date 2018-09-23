package com.yunhao.Algorithms.Algorithms_216;

import java.util.List;
import java.util.ArrayList;

class Solution {
	//带深度限制的dfs
	List<List<Integer>> ret;
	int[] path;
	
	public void dfs(int fa, int sum, int depth, int mxsum, int mxdepth) {
		for (int i = fa + 1; i < 10; i++) {
			if(sum + i > mxsum) 
				break;
			path[depth] = i;
			if(depth == mxdepth && sum + i == mxsum) {
				List<Integer> ele = new ArrayList<>();
				for (int j = 0; j <= mxdepth; j++) {
					ele.add(new Integer(path[j]));
				}
				ret.add(ele);
			}
			if(depth < mxdepth) {
				dfs(i, sum + i, depth + 1, mxsum, mxdepth);
			}
		}
	}
	
    public List<List<Integer>> combinationSum3(int k, int n) {
        ret = new ArrayList<>();
        path = new int[k];
        dfs(0, 0, 0, n, k - 1);
        return ret;
    }
}

public class Algorithms_216 {

}
