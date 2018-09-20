package com.yunhao.Algorithms.Algorithms_211;

import java.util.LinkedList;
import java.util.Queue;

class WordDictionary {
	class node{
		node[] nos;
		boolean edd_flag;
	}
	node root;
	
	class nodeTuple {
		node post;
		int postidx;
		nodeTuple (node post, int postidx){
			this.post = post;
			this.postidx = postidx;
		}
	}
	
    /** Initialize your data structure here. */
    public WordDictionary() {
    	root = new node();
    	root.nos = new node[27];
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
    	node curnode = root;
    	for (int i = 0; i < word.length(); i++) {
    		int idx = word.charAt(i) - 'a';
    		if(curnode.nos[idx] == null) {
    			curnode.nos[idx] = new node();
    			curnode.nos[idx].nos = new node[27];
    		}
    		if(i == word.length() - 1) {
    			curnode.nos[idx].edd_flag = true;
    		}
    		curnode = curnode.nos[idx];
    	}
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	Queue<nodeTuple> q = new LinkedList<>();
    	q.offer(new nodeTuple(root, -1));
    	while(!q.isEmpty()) {
    		nodeTuple cur = q.poll();
    		if(word.charAt(cur.postidx + 1) == '.') {
				for(int i = 0; i < 27; i++) {
					if(cur.post.nos[i] != null) {
						if(cur.postidx + 1 == word.length() - 1 && cur.post.nos[i].edd_flag) {
							return true;
						}
						if(cur.postidx + 1 < word.length() - 1) {
							q.offer(new nodeTuple(cur.post.nos[i], cur.postidx + 1));
						}
					}
				}
    		}
    		else {
    			int idx = word.charAt(cur.postidx + 1) - 'a';
    			if(cur.post.nos[idx] != null) {
    				if(cur.postidx + 1 == word.length() - 1 && cur.post.nos[idx].edd_flag) {
    					return true;
    				}
    				if(cur.postidx + 1 < word.length() - 1) {
    					q.offer(new nodeTuple(cur.post.nos[idx], cur.postidx + 1));
    				}
    			}
    		}
    	}
    	return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

public class Algorithms_211 {
	public static void main(String[] args) {
		WordDictionary wd = new WordDictionary();
		wd.addWord("bad");
		wd.addWord("dad");
		wd.addWord("mad");
		System.out.println(wd.search("bad"));
	}
}
