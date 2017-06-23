#include <stdio.h>

int strlen(char *s){
    int l=0;
    while(*s!=0){
        s=s+1;
        l=l+1;
    }
    return l;
}

void mystrcpy(char *source,char *dest){
    while((*dest++=*source++)!=0);
}

char *reverse(char *s){
    char tmp;
    int l=0,r=0;
    r=strlen(s)-1;
    while(l<r){
        tmp=s[l];
        s[l]=s[r];
        s[r]=tmp;
        l=l+1;
        r=r-1;
    }
    return s;
   
}

int main(){
    char *c="123456";
    char d[100];
    mystrcpy(c,d);
    reverse(d);
    printf("%s",d);
}
