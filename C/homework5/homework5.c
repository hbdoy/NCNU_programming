/*
* File Name: homework5.c
* ID: 104213046
* Author: 李禹叡
* Since 2015/10/19
* Fianl 2015/10/19
* Toolkit: Notepad++
*/
#include <stdio.h>

int s(int x){ //自訂函數s，輸入一數字後偶數/2，奇數*3+1，直到數字等於1時停止，並計算週期次數
    int l=1;
    long long n=x;
    while(n!=1){
        if(n%2==0){ //偶數/2
            n=n/2;
            l=l+1; //計算週期次數
        }
        else if(n%2!=0){ //奇數*3+1
            n=3*n+1;
            l=l+1; //計算週期次數
        }
    }
    return l; //回傳週期次數
}
int main(){ //判斷兩數範圍內，其中最大的週期，並印出來
    int start,end,i,max,l;
    while(scanf("%d %d",&start,&end)==2){
        max=-1;
        for(i=start;i<=end;i=i+1){ //在兩數間比較最大的週期次數
            l=s(i);
            if(max<l) //若新週期次數大於原先max，則新數值代原先值
                max=l;
        }
        printf("%d %d %d\n",start,end,max);
    }
}