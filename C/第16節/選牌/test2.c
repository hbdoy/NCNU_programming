#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void printcard(char *c,int n){
    //color=card/13
    //number=card%13
    int i;
    char color[]={'S','H','D','C'};
    char number[]={'A','K','Q','J','T','9','8','7','6','5','4','3','2'};
    for(i=0;i<n;i++){
        printf("%c%c ",color[c[i]/13],number[c[i]%13]);
    }
    printf("\n");
}

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
    //how to present color and number
    int i,c1,c2,tmp;
    srand(time(NULL));
    //rand用法:a=(rand()%52);
    char card[52];
    for(i=0;i<52;i++){
        card[i]=i;
    }
    //以上牌看起來長怎樣
    //color=card/13
    //number=card%13
    //0-->SA
    //1-->SK
    //25-->H2
    //shuffle,洗牌
    for(i=0;i<1000;i++){
        c1=rand()%52;
        c2=rand()%52;
        tmp=card[c1];
        card[c1]=card[c2];
        card[c2]=tmp;
    }
    //print out the result
    for(i=0;i<4;i++){
        printcard(card+i*13,13);
    }
    printf("\n\n");
    //理牌(順序)
    for(i=0;i<4;i++){
        sort(card+i*13,13);
    }
    for(i=0;i<4;i++){
        printcard(card+i*13,13);
    }
}