/*
* File Name: homework9.c
* ID: 104213046
* Author: 李禹叡
* Since 2015/11/18
* Toolkit: Notepad++
*/

#include <stdio.h>

/*在str函數中，判斷字串長度*/
int str(char c[]){
    int l=0;
    int i=0;
    while(c[i]!=0){
        i=i+1;
        l=l+1;
    }
    return l;
}

/*在AB函數中，比較兩組數*/
void AB(char c[],char d[],int *a,int *b){
    int i,j;
    for(i=0;i<str(c);i++){ //25~29行判斷A，即位置與數值皆相同
        if(c[i]==d[i]){
            *a=*a+1;
        }
    }
    for(i=0;i<str(c);i++){ //30~37行判斷B，即位置不同，但數值相同
        if(c[i]==d[i]) //跳過位置與數值相同
            continue;
        for(j=0;j<str(c);j++){ //拿第二組中每一個數值依序與第一組做比較
            if(d[j]==c[i])
                *b=*b+1;
        }
    }
}

/*main函數中輸入兩組不同數字，並顯示比較出來之AB*/
void main(){
    char m[100];
    char n[100];
    int a=0,b=0;
    scanf("%99s%99s",m,n);
    AB(m,n,&a,&b);
    printf("%d A %d B",a,b);
}