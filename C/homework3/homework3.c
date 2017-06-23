/*
* File Name: homework3.c
* ID: 104213046
* Author: 李禹叡
* Since 2015/10/03
* Toolkit: Notepad++
*/

#include <stdio.h>
#include <math.h>

void A(char c,int m){ //自訂函數A
    int i; //變數宣告
    for(i=1;i<=m;i=i+1) //for迴圈 重複執行m次
    {
        printf("%c",c); //印出回傳的符號
    }
}

int main(){
    int i,j,k,n,p; //變數宣告
    printf("input:"); //提示輸入
    scanf("%d",&n); //賦予n值
    p=2*n-3; //定義p值
    for (i=1;i<=n;i=i+1) //for迴圈 重複執行n次
    {
        A(' ',n-i); //調用函數A 回傳(' '-i)
        A('*',2*i-1); //調用函數A 回傳('*',2*i-1)
        printf("\n"); //換行
    }
    printf("\n"); //換行
    for (j=1;j<=n;j=j+1) //for迴圈 重複執行n次
    {
        A(' ',n-j); //調用函數A 回傳(' ',n-j)
        A('*',2*j-1); //調用函數A 回傳('*',2*j-1)
        printf("\n"); //換行
    }
    for (k=n-1;k>=1;k=k-1) //for迴圈 重複執行n次
    {
        A(' ',n-k); //調用函數A 回傳(' ',n-j)
        A('*',2*k-1); //調用函數A 回傳('*',2*j-1)
        printf("\n"); //換行
    }
    
    /*for (k=1;k<=n-1;k=k+1) //for迴圈 重複執行n-1次
    {
        A(' ',k); //調用函數A 回傳(' ',k)
        A('*',p); //調用函數A 回傳('*',p)
        printf("\n"); //換行
        p=p-2; //每執行一次p值減2
    }*/
}
