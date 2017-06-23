/*
* File Name: homework6.c
* ID: 104213046
* Author: 李禹叡
* Since 2015/10/19
* Fianl 2015/10/19
* Toolkit: Notepad++
*/
#include <stdio.h>

int k(int x){ //自訂函數k，計算數字x之反轉數
    int y=0,l;
    while(x!=0){
        l=x%10; //取原數取其最後一數
        y=y*10+l; //y為x最後一數相加，並每次*10進位
        x=x/10; //扣除x之最後一位數
    }
    return y; //回傳x之反轉數
}

int main(){ //計算數字x是否與其反轉數相同，若不符則和其反轉數相加，直到與其反轉數相等為止，並計算週期次數
    int x,n,i,j;
    scanf("%d",&j); //執行之組數
    for(i=1;i<=j;i=i+1){
        scanf("%d",&x);
        n=0; //週期從0開始計算
        while(x!=k(x)){ //當x與其反轉數不相等則
            x=x+k(x); //與其反轉數相加
            n=n+1; //週期計算
        }
        printf("%d %d\n",n,k(x));
    }
}