#include <cstdio>
#include <iostream>
#include <cstring>

using namespace std;

#define maxlen 1010

class Solution {
public:
    string longestPalindrome(string s) {
        int p[maxlen << 1], mx = 0, id = 0;
        char snew[maxlen << 1];

        memset(p, 0, sizeof p);

        int cursor = 0;
        snew[cursor++] = '$';
        for(int i = 0; i < s.length(); i++){
            snew[cursor++] = '#';
            snew[cursor++] = s[i];
        }
        snew[cursor++] = '#';

        int res = 0, mxradius = 1;
        for(int i = 0; i < cursor; i++){
            int j = 2 * id - i;
            if(i <= mx) p[i] = min(mx-i+1, p[j]);
            else p[i] = 1;
            if(i > mx || mx-i+1 >= p[j]){
                while(i-p[i]>=0 && i+p[i] < cursor && snew[i+p[i]] == snew[i-p[i]])
                    p[i]++;
                if(i+p[i]-1 > mx){
                    mx = i+p[i]-1;
                    id = i;
                }
                if(p[i] > mxradius){
                    mxradius = p[i];
                    res = (i-mxradius)/2;
                }
            }
        }
        return s.substr(res, mxradius-1);
    }
};

int main(){
    Solution solve;
    string s = "babad";
    printf("%s\n", &(solve.longestPalindrome(s))[0]);
    return 0;
}
