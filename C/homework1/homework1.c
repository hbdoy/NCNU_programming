/*
* File Name:homework1.c
* ID:104213046
* Author:李禹叡
* Since 2015/09/23
* Toolkit:Notepad++
*/
#include <stdio.h>

void main()
{
    int d,x,y,z; //變數宣告
    printf("input:"); //印出
    scanf("%d",&d); //輸入d值
    x=d/365; //年
    y=d%365/30; //月
    z=d%365%30; //日
    printf("ouput:%d years %d months %d days",x,y,z); //依照輸入的天數顯示出年月日
    getch();//直接執行生成exe時可以停留 比較方便測試
    
}
