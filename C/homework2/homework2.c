/*
* File Name: homework2.c
* ID: 104213046
* Author: 李禹叡#
* Since 2015/10/01
* Toolkit: Notepad++
*/
#include <stdio.h>
#include <math.h>
int main()
{
    double a,b,c;//變數宣告
    printf("input:ax^2+bx+c\n");//印出提示
    scanf("%lf%lf%lf",&a,&b,&c);//賦予a,b,c值
    if (a==0&&b==0&&c==0){//用if判斷條件
        printf("x=Infinitely many solutions\n");//符合條件 顯示無窮多解
    }else if (a==0&&b==0&&c!=0){//用if判斷條件
        printf("x=No solution");//符合條件 顯示無解
    }else if (a==0&&b!=0){//用if判斷條件
        printf("x=%lf",(-1*c)/b);//符合條件 顯示x之解為(-1*c)/b
    }else if (a!=0&&b*b-4*a*c==0){//用if判斷條件
        printf("x=%lf or x=%lf",((-1*b)/(2*a)),((-1*b)/(2*a)));//符合條件 顯示x之解為((-1*b)/(2*a))or((-1*b)/(2*a))
    }else if (a!=0&&b*b-4*a*c>0){//用if判斷條件
        printf("x=%lf or x=%lf",(-1*b+sqrt(b*b-4*a*c))/(2*a),(-1*b-sqrt(b*b-4*a*c))/(2*a));//符合條件 顯示x之解為 -1*b+sqrt(b*b-4*a*c))/(2*a) or (-1*b-sqrt(b*b-4*a*c))/(2*a)
    }else if (a!=0&&b==0&&b*b-4*a*c<0){//用if判斷條件
        printf("x=%lf+%lfi or x=%lf-%lfi",(b/(2*a)),((sqrt(4*a*c-b*b))/(2*a)),(b/(2*a)),((sqrt(4*a*c-b*b))/(2*a)));//符合條件 顯示x之解為(b/(2*a))+((sqrt(4*a*c-b*b))/(2*a))i or (b/(2*a))-((sqrt(4*a*c-b*b))/(2*a))i
    }else{//除上述判斷條件外 則執行
        printf("x=%lf+%lfi or x=%lf-%lfi",((-1*b)/(2*a)),((sqrt(4*a*c-b*b))/(2*a)),((-1*b)/(2*a)),((sqrt(4*a*c-b*b))/(2*a)));//顯示x之解為 ((-1*b)/(2*a))+((sqrt(4*a*c-b*b))/(2*a))i or ((-1*b)/(2*a))-((sqrt(4*a*c-b*b))/(2*a))i
	}
}
