#include<stdio.h>
int che(int p,int *n,int *f){
    int tmp,tmpp=p,k=0;//tmp=尾數,tmpp變數,f=幾個5,k=驗證是否顯示,n=總個數
    while(tmpp!=0){
        tmp=tmpp%10;
        if(tmp==5){
            *f=*f+1;
            k=k+1;
        }
        tmpp=tmpp/10;
    }
    if(k!=0){
        printf("%d ",p);
        *n=*n+1;
    }
}
int main(){
    int i,p,n=0,f=0;//n=總個數 f=幾個5
    printf("input:");
    scanf("%d",&p);
    for(i=1;i<=p;i++){
        che(i,&n,&f);
    }
    printf("\n");
    printf("include %d numbers and %d 5",n,f);
}