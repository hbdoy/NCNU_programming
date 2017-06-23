/*
* File Name: homework8.c
* ID: 104213046
* Author: 李禹叡
* Since 2015/11/18
* Toolkit: Notepad++
*/

#include <stdio.h>

void perlen(char data[],int n,int m,int got,int *sol){
    int i;
    char tmp;
    if(got==m){
        *sol=*sol+1;
        return;
    }
    for(i=got;i<n;i=i+1){
        tmp=data[i];
        data[i]=data[got];
        data[got]=tmp;
        perlen(data,n,m,got+1,sol);
        tmp=data[i];
        data[i]=data[got];
        data[got]=tmp;
    }
}
int main(){
    int n,sol=0,i;
    char data[]={'0','1','2','3','4','5','6','7','8','9'};
}

/*在str函數中，計算n階層*/
/*
int str(int n){
    if(n==0)
        return 1;
    return n*str(n-1);
}
*/
/*在lastarr函數中，排列出倒數第一組解*/
/*
char *lastarr(char c[],char *last,int n){
    int i,j;
    last[0]=c[9]; //倒數第一組解之開頭
    for(i=0,j=1;i<(n-1);i++){ //選取n-1個數排出倒數第一組解
        last[j]=c[i];
        j=j+1;
    }
    last[j]=0;
}
*/
/*main函數中顯示P 10取n之解數，並顯示倒數第一組解*/
/*
void main(){
    char m[10]={'0','1','2','3','4','5','6','7','8','9'};
    char last[10];
    int i,n,k;
    scanf("%d",&n);
    k=str(10)/str(10-n); //p 10取n之解數
    printf("%d\n",k);
    lastarr(m,last,n);
    for(i=0;i<n;i++){ //按照順序印出倒數第一組解
        printf("%c ",last[i]);
    }
}
*/
