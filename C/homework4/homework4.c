/*
* File Name: homework4.c
* ID: 104213046
* Author: 李禹叡
* Since 2015/10/08
* Fianl 2015/10/12
* Toolkit: Notepad++
*/

#include <stdio.h>

double A(double x,int m){ //自訂函數A 並討論x^m次方所有情形 m>0 & m=0 & m<0
    double y; //變數宣告
    int i; //變數宣告
    y=x; //令y=x
    if(m>0){ //當m>0時
        for(i=2;i<=m;i=i+1){ //for迴圈重複執行m-1次
            y=y*x; //每執行一次*x
    }
    }
    else if(m==0){ //當m=0時
        y=1; //y值=1
    }
    else if(m<0){ //當m<0時
        y=1/y; //將y轉為倒數進行運算
        x=1/x; //將x轉為倒數進行運算
        for(i=2;i<=(-1*m);i=i+1){ //for迴圈重複執行m-1次
            y=y*x; //每執行一次*x
    }
    }
    return y; //回傳y值
}

double B(double x,int n){ //自訂函數B
    double right,mid,left; //變數宣告
    if(x>=1){ //if條件判斷
        left=1; //定義left值
        right=x; //定義right值
    }
    else if(x<1){ //if條件判斷
        left=x; //定義left值
        right=1; //定義right值
    }
    mid=(left+right)/2;  //定義mid值
    while (mid>left && mid<right){ //while迴圈判斷
        if (A(mid,n)>x){ //if條件判斷
            right=mid; //定義right值
    }
        else if (A(mid,n)<x){ //if條件判斷
            left=mid; //定義left值
    }
        else
        return mid; 
        mid=(left+right)/2; //回傳mid值
    }
    return mid; //回傳mid值
}

int main(){
    double x,y,z; //變數宣告
    int m,n; //變數宣告
    scanf("%lf%d%d",&x,&m,&n); //賦予x,m,n值
    y=A(x,m); //定義y值並呼叫函數A帶入(x,m)
    z=B(y,n); //定義z值並呼叫函數B帶入(y,n)
    printf("%lf",z); //顯示x^(m/n)
}