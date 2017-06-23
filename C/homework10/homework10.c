/*
* File Name: homework10.c
* ID: 104213046
* Author: 李禹叡
* Since 2015/11/29
* Toolkit: Notepad++
*/
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//printcard中顯示出每一組牌的花色和數字
void printcard(char *c,int n){
    //color=card/13
    //number=card%13
    int i,j=0;
    char color[]={'S','H','D','C'};
    char number[]={'A','K','Q','J','T','9','8','7','6','5','4','3','2'};
    for(i=0;i<n;i++){
         //while迴圈判斷花色是否改變，若改變則換行
         while(c[i]/13>j){
            printf("\n");
            j++;
        }
        printf("%c%c ",color[c[i]/13],number[c[i]%13]);
    }
    printf("\n");
}

//理牌(順序排好)
void sort(char *data,int len){
    int i; //i is the element to insert
    int tmp; //tmp是要insert的元素的值
    int j; //j是要比較的元素
    //依序把第i個元素，insert到前面(0....i-1)已經排好的資料內
    for(i=1;i<len;i++){
        tmp=data[i];
        j=i-1;
        while(j>=0&&data[j]>tmp){
            data[j+1]=data[j];
            j=j-1;
        }
        //要插入的位置在j的後面
        data[j+1]=tmp;
    }
}

int main() {
    int i,c1,c2,tmp;
    srand(time(NULL));
    char card[52];
    //設定有52張牌
    for(i=0;i<52;i++){
        card[i]=i;
    }
    //shuffle,洗牌
    for(i=0;i<1000;i++){
        c1=rand()%52;
        c2=rand()%52;
        tmp=card[c1];
        card[c1]=card[c2];
        card[c2]=tmp;
    }
    //依序顯示出每位玩家的牌，並按花色大小排列好
    for(i=0;i<4;i++){
    printf("player %d:\n",i+1);
    sort(card+i*13,13);
    printcard(card+i*13,13);
    }
}