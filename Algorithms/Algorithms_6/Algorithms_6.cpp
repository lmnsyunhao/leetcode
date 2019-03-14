#include <iostream>
#include <cstdio>

using namespace std;

class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows == 1)
            return s;

        int percycle = (numRows-1)<<1;
        int cycle = (s.length()/percycle)+(s.length()%percycle!=0);
        int tot = percycle * cycle;

        int cnt = 0, row = 0, cursor = (-1)*percycle;
        string res = "";

        while(cnt < s.length()){
            row += (cursor + percycle) / tot;
            cursor = (cursor + percycle) % tot;

            if(cursor+row >= s.length()) continue;
            cnt++;
            res.push_back(s[cursor+row]);

            if((cursor+percycle-row)%percycle == 0) continue;
            if((cursor+percycle-row) == cursor+row) continue;
            if((cursor+percycle-row) >= s.length()) continue;
            cnt++;
            res.push_back(s[cursor+percycle-row]);
        }
        return res;
    }
};

int main(){
    string s = "PAYPALISHIRING";
    Solution solve;
    printf("%s\n", &(solve.convert(s, 4))[0]);
    return 0;
}
