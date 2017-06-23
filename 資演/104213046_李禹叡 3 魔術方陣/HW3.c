#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main(){
    int rnd,i,j,key=1,p=0,q=0,tmp=0;
    srand(time(NULL));
    do{
        rnd=(rand()%11)+20;
    }while(rnd%2==0); //取奇數
    int data[rnd][rnd];
    int row=0; //陣列索引由0開始
    int column=(rnd-1)/2; //從中間開始
    for(i=0;i<rnd;i++){ //給定初值0
        for(j=0;j<rnd;j++){
            data[i][j]=0;
        }
    }
    data[row][column]=key++; //初始值
    for(key=2;key<=rnd*rnd;key++){
        tmp=0; //紀錄是否轉換過
        p=row,q=column; //出界前的位置
        row=row-1; //向上移動
        column=column+1; //向右移動
        if((row<0)&&(column<=(rnd-1))){ //列出界 行未出界
            row=rnd-1;
        }else if((row<0)&&(column>(rnd-1))){ //列出界 行出界
            row=rnd-1;
            column=0;
        }else if((row>=0)&&(column>(rnd-1))){ //列未出界 行出界
            column=0;
        }
        if(data[row][column]!=0){ //欲移動位置有數字則下填一列
            p=p+1;
            if(p>(rnd-1)){ //檢查是否列出界
                p=0;
            }
            tmp=1;
        }
        if(tmp==1){
            data[p][q]=key; //新位置為原位置向下一列
            row=p;
            column=q;
        }else if(tmp==0){ //新位置不變
            data[row][column]=key;
        }
    }
    printf("This odd magic square is %dx%d\n",rnd,rnd);
    for(i=0;i<rnd;i++){
        for(j=0;j<rnd;j++){
            printf("%2d ",data[i][j]);
        }
        printf("\n");
    }
    int midrowsum=0,midcolumnsum=0,diagonalsum=0;
    int mid=rnd/2;
    for(i=0;i<rnd;i++){
        midrowsum+=data[mid][i]; //中間列之和
        midcolumnsum+=data[i][mid]; //中間行之和
        diagonalsum+=data[i][i]; //對角線之和
    }
    printf("The sum of the middle row is %d\n",midrowsum);
    printf("The sum of the middle column is %d\n",midcolumnsum);
    printf("The sum of the diagonal is %d\n",diagonalsum);
 }