#include <stdio.h>
#include <stdlib.h>
void printk(int *board,int n){
    int i,j;
    for(i=0;i<n;i++){
        for(j=0;j<n;j++){
            if(board[(i+1)*(n+2)+j+1]=='Q'){
                printf("Q ");
            }else{
                printf(". ");
            }
        }
        printf("\n");
    }
}

void queen(int *board,int n,int row,int *sol){
    int i,j,k,puton;
    int dir[]={n+1,n+2,n+3};
    if(row==n){
        printk(board,n);
        (*sol)++;
        return;
    }
    for(i=0;i<n;i++){
        //test if ith column can put a Queen
        puton=(row+1)*(n+2)+i+1;
        if(board[puton]==0){
            //這個位置不會被上面的皇后吃到
            //放上皇后
            board[puton]='Q';
            //set up control field
            for(j=0;j<3;j++){
                for(k=puton+dir[j];board[k]>=0;k+=dir[j]){
                    board[k]++;
                }
            }
            //recusive to put row+1 Queen
            queen(board,n,row+1,sol);
            //remove queen and control field
            board[puton]=0;
            for(j=0;j<3;j++){
                for(k=puton+dir[j];board[k]>=0;k+=dir[j]){
                    board[k]--;
                }
            }
        }
    }
}



void init(int *board,int n){
    int i;
    for(i=0;i<(n+2)*(n+2);i++){
        board[i]=0;
    }
    //將邊框設為1
    for(i=0;i<n+2;i++){
        //上邊
        board[i]=-1;
        //下邊
        board[(n+1)*(n+2)+i]=-1;
        //左邊
        board[i*(n+2)]=-1;
        //右邊
        board[i*(n+2)+n+1]=-1;
    }
}

int main(){
    int n,sol;
    int *board;
    scanf("%d",&n);
    board=(int *) malloc((n+2)*(n+2)*sizeof(int));
    init(board,n);
    sol=0;
    queen(board,n,0,&sol);
    printf("%d sols\n",sol);
}