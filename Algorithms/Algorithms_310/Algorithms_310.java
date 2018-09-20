package com.yunhao.Algorithms.Algorithms_310;

import java.util.ArrayList;
import java.util.List;

class Solution {
	//树的直径上中间的两个点或者一个点
	int mx;
	int mxidx;
	int[] trace;
	boolean flag;
	List<Integer> ret;
	ArrayList<ArrayList> grid;
	
	public void dfs(int root, int fa, int stamp, int trace_edd) {
//		System.out.println(root + ":" + stamp);
		if(stamp > mx) {
			mx = stamp;
			mxidx = root;
		}
		if(trace_edd != -1) {
			if(!flag) {
				trace[stamp] = root;
			}
			if(root == trace_edd) {
				flag = true;
			}
		}
		ArrayList<Integer> cur = grid.get(root);
		for(int i = 0; i < cur.size(); i++) {
			if(cur.get(i).intValue() == fa)
				continue;
			dfs(cur.get(i).intValue(), root, stamp + 1, trace_edd);
		}
	}
	
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    	if(n == 0) {
    		return new ArrayList<Integer>();
    	}
    	else if(n == 1) {
    		ret = new ArrayList<>();
    		ret.add(new Integer(0));
    		return ret;
    	}
    	
    	grid = new ArrayList<>();
    	ret = new ArrayList<>();
    	trace = new int[n + 1];
    	for (int i = 0; i < n; i++) {
    		ArrayList<Integer> row = new ArrayList<>();
    		grid.add(row);
    	}
    	for(int i = 0; i < n-1; i++) {
    		grid.get(edges[i][0]).add(new Integer(edges[i][1]));
    		grid.get(edges[i][1]).add(new Integer(edges[i][0]));
    	}

    	mx = 0;
    	mxidx = 0;
    	dfs(0, 0, 1, -1);
    	int stt = mxidx;
    	
    	mx = 0;
    	dfs(mxidx, mxidx, 1, -1);
    	int edd = mxidx;

    	flag = false;
    	dfs(stt, stt, 1, edd);
    	
    	for(int i = 1; i <= n; i++) {
    		if(i == (1 + mx) / 2) {
    			ret.add(new Integer(trace[i]));
    		}
    		if((mx + 1) % 2 != 0 && i == (1 + mx) / 2 + 1) {
    			ret.add(new Integer(trace[i]));
    		}
    	}
    	return ret;
    }
}

public class Algorithms_310 {
	public static void main(String[] args) {
		Solution solve = new Solution();
		int number = 12;
//		int[][] edges = new int[][]{{1,0},{1,2},{1,3}};
		int[][] edges = new int[][]{{0,1},{0,2},{0,3},{3,4},{3,5},{1,6},{4,7},{2,8},{0,9},{0,10},{2,11}};
		System.out.println(solve.findMinHeightTrees(number, edges).size());
	}
}
