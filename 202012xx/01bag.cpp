#include <iostream>
using namespace std;
void Knapsack(int,int,float *,float *);
int n = 3;
float v[3] = {60,100,120};
float w[3] = {10,20,40};
float c = 50;
int main() {
    Knapsack(c,n,v,w);
    return 0;
}
void Knapsack(int c,int n,float *v,float *w) {
    // Sort(n,v,w);//将原来的数组按v/w的大小进行排序
    int i;
    float x[n];
    for(i=1;i<=n;i++)
        x[i] = 0;//0代表未装入，1代表装入
    
    //装填
    for(i=1;i<=n;i++) {
        if(w[i]>c) break; //已经装满了
        x[i] = 1;//装入标记
        c-=w[i];//容量减少
    }
    if(i<=n) x[i]=c/w[i]; //如果没有装完，那么最后分割没有装满的
    
    for(int i=0;i<sizeof(x)/sizeof(int);i++)
        cout<<x[i]<<endl;
}