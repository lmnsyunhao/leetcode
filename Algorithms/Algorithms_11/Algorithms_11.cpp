#include <cstdio>
#include <iostream>
#include <cstring>
#include <malloc.h>
#include <vector>
#include <algorithm>

using namespace std;

struct node{
    int val, idx;
    bool operator < (node no2){
        if(val == no2.val)
            return idx > no2.idx;
        return val < no2.val;
    }
};

class Solution {
public:
    node *nums;
    int *order, *sum, len;

    int lowbit(int i){
        return -i&i;
    }

    void addval(int idx, int v){
        while(idx <= len){
            sum[idx] += v;
            idx += lowbit(idx);
        }
    }

    int getsum(int idx){
        int ret = 0;
        while(idx > 0){
            ret += sum[idx];
            idx -= lowbit(idx);
        }
        return ret;
    }

    int once(){
        sort(nums, nums+len);
        order = (int*)calloc(len, sizeof(int));
        for(int i = 0; i < len; i++)
            order[nums[i].idx] = i;

        sum = (int*)calloc(len+10, sizeof(int));
        int lft = 1;
        for(int i = 0; i < len; i++){
            if(order[i]+2 <= lft) continue;
            addval(order[i]+2, -1*(i+1));
            addval(lft, i+1);
            lft = order[i]+2;
        }

        int mx = 0;
        for(int i = 0; i < len; i++){
            int earlyidx = getsum(order[i]+1) - 1;
            mx = max(mx, (i-earlyidx)*nums[order[i]].val);
        }

        free(sum);
        free(order);

        return mx;
    }

    int maxArea(vector<int>& height) {
        len = height.size();
        nums = (node*)calloc(len, sizeof(node));
        for(int i = 0; i < len; i++){
            nums[i].val = height[i];
            nums[i].idx = i;
        }
        int ret1 = once();
        free(nums);

        nums = (node*)calloc(len, sizeof(node));
        for(int i = 0; i < len; i++){
            nums[i].val = height[i];
            nums[i].idx = len - 1 - i;
        }
        int ret2 = once();
        free(nums);

        return max(ret1, ret2);
    }
};

int main(){
    Solution solve;
    vector<int> test;
    test.push_back(1);
    test.push_back(6);
    test.push_back(1);
//    test.push_back(6);
//    test.push_back(2);
//    test.push_back(5);
//    test.push_back(4);
//    test.push_back(8);
//    test.push_back(3);
//    test.push_back(7);

    printf("%d\n", solve.maxArea(test));

    return 0;
}
