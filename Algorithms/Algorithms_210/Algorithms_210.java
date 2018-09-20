package com.yunhao.Algorithms.Algorithms_210;

import java.util.ArrayList;

class Solution {
	ArrayList<Integer>[] graph;
	int cursor = 0;
	int[] degree;
	
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ret = new int[numCourses];
        degree = new int[numCourses];
        graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
        	graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
        	int stt = prerequisites[i][0], edd = prerequisites[i][1];
        	graph[edd].add(new Integer(stt));
        	degree[stt]++;
        }

        boolean flag = false;
        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < numCourses; j++) {
            	if(degree[j] == 0) {
            		flag = true;
            		ret[cursor++] = j;
            		degree[j] = -1;
            		for(int k = 0; k < graph[j].size(); k++) {
            			degree[graph[j].get(k)]--;
            		}
            	}
            }
            if(!flag) {
            	break;
            }
        }
        
        if(cursor != numCourses) {
        	return new int[] {};
        }
        
        return ret;
    }
}

public class Algorithms_210 {

}
