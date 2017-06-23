/*
* File Name: homework7.c
* ID: 104213046
* Author: 李禹叡
* Since 2015/11/12
* Toolkit: Notepad++
*/
#include<stdio.h>

/*
在move函數中，完成各堆數量的移動，使每一堆的數量都相等，並計算次數
*/
int move(int n,int ave,int x[]){
    int len=0; //移動次數
    A:
    while(x[n-1]>ave){ //在while迴圈中，將大於平均數量的堆數，移動多出的量，直到與平均值相等
        x[n-1]--;
        len++;
    }
    n--; //20~22行，由最後一堆開始往回檢測，直到第一堆為止
    if(n>=1)
        goto A;
    else 
        return len;

}
/*
在main函數中，完成堆數與各堆數量的輸入，並顯示出平分時移動的最少次數
*/
void main(){
    int i,l,n,sum=0,average,rmd; //若是無法均分，rmd為多出來的個數，也就是老俞要吃掉的
    scanf("%d",&n); //總共幾堆
    int x[n];
    for(i=0;i<n;i++){ //依次輸入每堆的數量並求總數量
        scanf("%d",&x[i]);
        sum=sum+x[i];
    }
    rmd=sum%n; //總數量對n取餘數，即是平分時多出來的
    average=sum/n; //求出平分時每一堆要疊多高
    l=move(n,average,x)-rmd; //總共移動的次數，必須扣掉應該吃掉的數量，因為在移動時，這些多出的量也算進去了
    printf("%d",l);
}