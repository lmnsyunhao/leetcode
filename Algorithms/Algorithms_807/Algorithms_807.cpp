#include <cstdio>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int maxIncreaseKeepingSkyline(vector<vector<int> >& grid) {
        vector<int> colMax, rowMax;
        for (int i = 0; i < grid.size(); i++){
            for (int j = 0; j < grid[i].size(); j++){
                if (i == 0)
                    colMax.push_back(grid[i][j]);
                colMax[j] = max(colMax[j], grid[i][j]);
                if (j == 0)
                    rowMax.push_back(grid[i][j]);
                rowMax[i] = max(rowMax[i], grid[i][j]);
            }
        }
        int sum = 0;
        for (int i = 0; i < grid.size(); i++){
            for (int j = 0; j < grid[i].size(); j++){
                sum += min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }
        return sum;
    }
};

int main(){
    Solution solve;
    return 0;
}
