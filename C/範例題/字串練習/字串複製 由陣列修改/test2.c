#include <stdio.h>

char *k(char c[],char copy[]){
    int i;
    for(i=0;c[i]!=0;i++){
        copy[i]=c[i];
    }
    copy[i]=0;
    return copy;
}

void main(){
    char s[100];
    scanf("%99s",s);
    char copy[100];
    printf("before=%s\n",s);
    printf("copy=%s\n",k(s,copy));
}