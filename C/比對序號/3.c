#include<stdio.h>

int main(){
    int i,j=0;
    char out[4]={'p','a','s','s'};
    char in[99];
    printf("pls input 4 password:");
    scanf("%4s",in);
    for(i=0;i<4;i++){
        if(in[i]==out[i])
            j=j+1;
    }
    if(j==4){
        printf("thanks for support!\n");
    }else{
        printf("Error Try Again!\n");
    }
    getch();
}