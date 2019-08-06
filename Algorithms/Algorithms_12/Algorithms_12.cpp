#include <cstdio>
#include <iostream>

using namespace std;

class Solution {
public:
    string intToRoman(int num) {
        int baseint[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        string basestr[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int cursor = 0;
        string res = "";
        while(num != 0){
            while(num - baseint[cursor] >= 0){
                res += basestr[cursor];
                num -= baseint[cursor];
            }
            cursor++;
        }
        return res;
    }
};

int main(){
    Solution solve;
    int num;
    while(~scanf("%d", &num)){
        printf("%s\n", &(solve.intToRoman(num))[0]);
    }
    return 0;
}
