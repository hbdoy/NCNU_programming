/*
* File Name:homework1.c
* ID:104213046
* Author:李禹叡
* Since 2015/09/23
* Toolkit:Notepad++
*/
#include <stdio.h>

int d=x/365,y=x%365/30,z=x%365%30;
void main()
{
    int d,x,y,z; //變數宣告
	printf("input days:\n"); //印出
	scanf("%d",&x); //輸入x值
	printf("year=%d\nmonth=%d\ndays=%d",d,y,z); //依照輸入的天數顯示出年月日
	getch();
	
}
