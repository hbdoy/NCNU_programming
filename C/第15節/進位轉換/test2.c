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
int main(){
    int x;
    char rel[100];
    printf("%s",toString(100,2,rel));
}