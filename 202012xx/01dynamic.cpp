#include <iostream>
#include <vector>
using namespace std;
int coinChange(vector<int> &, int);
int main() {
    //思路：
    /**
     * base case 基本问题，当目标金额为0时，返回0
     * 确定状态，原问题和子问题中会变化的量
     * 确定选择，导致状态发生变化的原因
     * 明确dp函数/数组的定义
     */

    int n,kinds;//金额种类
    cin>>n>>kinds;
    vector<int> conins;//每一种金额的面值
    for (int i=0;i<kinds;i++) {
        int iter;
        cin>>iter;
        conins.push_back(iter);
    }
    cout<<coinChange(conins,n);
}

int coinChange(vector<int>& coins, int n) {
    vector<int> dp(n+1,n+1);
    dp[0] = 0;

    for (int i=0;i<dp.size();i++) {
        for(int coin:coins) {
            if(i-coin<0) continue;
            dp[i] = min(dp[i], 1+dp[i-coin]);
        }
    }
    return (dp[n]==n+1)? -1:dp[n];
}