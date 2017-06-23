#include <stdio.h>

int str(char c[]){
    int l=0;
    int i=0;
    while(c[i]!=0){
        i=i+1;
        l=l+1;
    }
    return l;
}

char *reverse(char *c){
    char tmp;
    int i=0,j=0;
    j=str(c)-1;
    while(i<j){
        tmp=c[i];
        c[i]=c[j];
        c[j]=tmp;
        i=i+1;
        j=j-1;
    }
}

void main(){
    char s[100];
    scanf("%99s",s);
    printf("s=%s\n",s);
    reverse(s);
    printf("change s=%s\n",s);
}