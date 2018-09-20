package com.yunhao.Algorithms.Algorithms_307;

class NumArray {
	
	int[] src;
	int[] tree;
			
	public int lowbit(int i) {
		return i & -i;
	}
	
	public void pointChange(int i, int v) {
		while(i < tree.length) {
			tree[i] += v;
			i += lowbit(i);
		}
	}
	
	public int queryRange(int i) {
		int sum = 0;
		while(i > 0) {
			sum += tree[i];
			i -= lowbit(i);
		}
		return sum;
	}
	
    public NumArray(int[] nums) {
        src = nums.clone();
        tree = new int[nums.length + 1];
        for (int i = 0; i < src.length; i++) {
        	pointChange(i+1, src[i]);
        }
    }
    
    public void update(int i, int val) {
        pointChange(i+1, val-src[i]);
        src[i] = val;
    }
    
    public int sumRange(int i, int j) {
    	return queryRange(j + 1) - queryRange(i);
    }
    
    public void printTree() {
    	for (int i = 0; i < tree.length; i++) {
    		System.out.print(tree[i] + " ");
    	}
    	System.out.println("");
    }
    
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

public class Algorithms_307 {

    public static void main(String[] args) {
    	int nums[] = {7,2,7,2,0};
    	NumArray obj = new NumArray(nums);
    	obj.printTree();
    	obj.update(4, 6);
    	obj.printTree();
    	obj.update(0, 2);
    	obj.printTree();
    	obj.update(0, 9);
    	obj.printTree();
    }
}