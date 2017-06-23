/*
* File Name: homework11.c
* ID: 104213046
* Author: 李禹叡
* Since 2015/12/02
* Toolkit: Notepad++
*/
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//計算malloc大小(0~9)9*8*7*...
int str(int n){
    int j,i,k=1;
    for(i=0,j=9;i<n;i++,j--){
        k=k*j;
    }
    return k;
}
//產生一亂數並確認是否出現過
void non(int *tmp,int n,int *all,int *rr){
    int i,j,k,m,l=0,p;
    for(i=0;i<n;i++){ //23~29產生n個不重複的數字
        tmp[i]=rand()%10;
        for(j=0;j<i;j++){
            if(tmp[i]==tmp[j]){
                i--;
            }
        }
        if(i==(n-1)){ //30~44當i=n-1表示數字產生完畢，可檢驗是否與之前的重複
            for(k=0,p=0;k<(*rr/n);k++,p=p+n){ //檢驗的次數為當前已使用的組數
                m=0;
                for(l=0;l<n;l++){ //檢驗每組中的n位數
                    if(tmp[l]==all[l+p]){
                        m=m+1; //若相同則m計次加1
                    }
                }
                if(m==n){ //若計次m=n代表n位數字皆相同
                    i=0; //i=0重新產生一組亂數
                    break;
                }
            }
        }
    }
    for(i=0;i<n;i++){ //將新的且不重複的亂數寫進已使用的解
        all[i+*rr]=tmp[i];
    }
    *rr=*rr+n; //讓下組亂數寫進後n位數
    for(i=0;i<n;i++){ //顯示亂數
        printf("%d",tmp[i]);
    }
    printf("\n");
}
//電腦產生一n位亂數來猜玩家的數字，玩家回答幾A幾B，直到猜中
int main(){
    int n,r=0,a=19970128,b=19970128;
    srand(time(NULL));
    scanf("%d",&n);
    int *all=malloc(str(n)*sizeof(int)); //已使用過的所有組數
    int tmp[n]; //當前的新亂數
    do{
        if(a!=19970128&&(a+b)>n){ //a設19970128避免第一次執行便進入if，當a+b>n代表輸入錯誤
            printf("\nError,try Again\n\n");
        }
        if(a!=19970128&&(a+b)<=n){ ////a設19970128避免第一次執行便進入if，當a+b<=n代表尚未猜到
            printf("\nAgain!\n\n");
        }
        if(a==n&&b==0){
            printf("\nCorrect!");
            break;
        }
        printf("I guess:");
        non(tmp,n,all,&r);
        printf("Answer?");
        scanf("%d%d",&a,&b);
    }while(1);
}