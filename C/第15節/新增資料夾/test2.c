#include <stdio.h>

int fun(int n){
    int y=0,l;
    while(n!=0){
        l=n%10;
        y=y*10+l;
        n=n/10;
    }
    return y;
}
char *toString(int x,int b,char *result){
    int len=0;
    int l,r;
    char tmp;
    while(x!=0){
        if(x%b>=10)
            *(result+len)=x%b-10+'A';
        else
            *(result+len)=x%b+'0';
        len=len+1;
        x/=b;
    }
    *(result+len)=0;
    for(l=0,r=len-1;l<r;l++,r--){
        tmp=result[l];
        result[l]=result[r];
        result[r]=tmp;
    }
    return result;
}
//請比較兩字串，若是值和位置相同，則a+1
//若有此值，但位置不同，則b+1
void compare(char *x,char *y,int len,int *a,int *b){
    
}
int main(){
    char *x="1234";
    char *y="0924";
    int a,b;
    //執行下列函數後，a應為1,b應為1
    compare(x,y,4,&a,&b);
    printf("%s 和 %s比較結果為%da%db",x,y,a,b);
}