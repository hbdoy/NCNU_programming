#include <stdio.h>
#define n 3 //A,B,C=A+B
struct equation{ //定義struct
    int item; //項數
    int power[20]; //方程式之次方
    int constant[20]; //方程式之常數
};
int main(){
    int i=0,k=0,p,q,m;
    struct equation A[n]; //宣告struct A[3](A,B,C)
    int tmp[40];
    for(i=0;i<20;i++){ //賦予初始值給A、B之次方與常數陣列
        A[0].power[i]=-1;
        A[0].constant[i]=0;
        A[1].power[i]=-1;
        A[1].constant[i]=0;
    }
    printf("please input equation A by the rule of 2m+1:\n");  //輸入方程式A
    scanf("%d",&k); //輸入項數
    for(i=0;i<2*k;i++){ //輸入剩下數字
        scanf("%d",&tmp[i]);
    }
    A[0].item=k; //A之項數
    for(i=0,p=0,q=0;i<2*k;i++){ //把輸入的值傳給A之次方、常數陣列
        if(i%2==0){
            A[0].power[p]=tmp[i];
            p++;
        }
        if(i%2!=0){
            A[0].constant[q]=tmp[i];
            q++;
        }
    }
    printf("\n");
    printf("please input equation B by the rule of 2m+1:\n"); 
    scanf("%d",&k); //輸入項數
    for(i=0;i<2*k;i++){ //輸入剩下數字
        scanf("%d",&tmp[i]);
    }
    A[1].item=k; //B之項數
    for(i=0,p=0,q=0;i<2*k;i++){ //把輸入的值傳給B之次方、常數陣列
        if(i%2==0){
            A[1].power[p]=tmp[i];
            p++;
        }
        if(i%2!=0){
            A[1].constant[q]=tmp[i];
            q++;
        }
    }
    printf("\n");
    for(i=0,p=0,q=0,m=0;i<(A[0].item+A[1].item);i++){ //A B相加之結果複製到C
        if(A[0].power[p]>A[1].power[q]){
            A[2].power[m]=A[0].power[p];
            A[2].constant[m]=A[0].constant[p];
            m++;
            p++;
        }else if(A[0].power[p]<A[1].power[q]){
            A[2].power[m]=A[1].power[q];
            A[2].constant[m]=A[1].constant[q];
            m++;
            q++;
        }else if(A[0].power[p]==A[1].power[q]){
            A[2].power[m]=A[0].power[p];
            A[2].constant[m]=(A[0].constant[p]+A[1].constant[q]);
            m++;
            p++;
            q++;
        }
    }
    printf("equation A = ");
    for(i=0;i<A[0].item;i++){ //印出A
        if(i!=0){
            printf(" + ");
        }
        if(A[0].power[i]==0){ //若為常數則不印出x^0
            printf("(%d)",A[0].constant[i]);
        }else if(A[0].power[i]!=0){
            printf("(%d)X^%d",A[0].constant[i],A[0].power[i]);
        }
    }
    printf("\n");
    printf("equation B = ");
    for(i=0;i<A[1].item;i++){ //印出B
        if(i!=0){
            printf(" + ");
        }
        if(A[1].power[i]==0){ //若為常數則不印出x^0
            printf("(%d)",A[1].constant[i]);
        }else if(A[1].power[i]!=0){
            printf("(%d)X^%d",A[1].constant[i],A[1].power[i]);
        }
    }
    printf("\n");
    printf("equation A + B = ");
    for(i=0;i<m;i++){ //印出A+B
        if(A[2].power[i]>-1){ //可能提早結束 不會執行到m次
            if(i!=0){
            printf(" + ");
        }
        if(A[2].power[i]==0){ //若為常數則不印出x^0
            printf("(%d)",A[2].constant[i]);
        }else if(A[2].power[i]!=0){
            printf("(%d)X^%d",A[2].constant[i],A[2].power[i]);
        }
        }
    }
}