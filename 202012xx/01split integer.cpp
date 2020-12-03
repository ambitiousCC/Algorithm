#include <iostream>

using namespace std;

int q(int n, int m) {
    // 小于零时不符合要求
    if ((n<1) || (m<1))
        return 0;
    // 都等于零时只有一种情况
    if ((n==1) || (m==1))
        return 1;
    // 当最大加数都大于本身，那么就是本身的划分
    if (n<m)
        return q(n,n);
    // 也就是求自身的划分=加数小于自身的划分+1
    // q(n,n) = q(n,n-1) + 1 （多一个数字就只是多了一种情况）
    if (n==m)
        return q(n,n-1) + 1;
    //剩下的情况就是n>m>1的情况= q(n,m)+q(n,>=m-1)
    //n1=m的划分就是该划分中必然包含数m，就是与n-m的m划分一致
    return q(n,m-1) + q(n-m,m);
}

int main() {
    int n;
    cin>>n;
    cout<<n<<"整数拆分有"<<q(n,n)<<"种"<<endl;
    return 0;
}
