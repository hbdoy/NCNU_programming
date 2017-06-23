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

char *k(char c[],char d[]){
    char tmp[200];
    int i,j;
    for(i=0;i<str(c);i++){
        tmp[i]=c[i];
    }
    //tmp[i]=0;
    for(j=0;j<str(d);j++){
        tmp[j+i]=d[j];
    }
    tmp[j+i]=0;
    //return tmp;
    char *tmpp=tmp;
    return tmpp;
}

char *kk(char c[],char d[]){
    char tmp[200];
    int i,j;
    for(i=0;i<str(c);i++){
        tmp[i]=c[i];
    }
    //tmp[i]=0;
    for(j=0;j<str(d);j++){
        tmp[j+i]=d[j];
    }
    tmp[j+i]=0;
    d=tmp;
    return d;
}

void main(){
    char s[100];
    scanf("%99s",s);
    char t[100];
    scanf("%99s",t);
    printf("s=%s\n",s);
    printf("t=%s\n",t);
    printf("s+t=%s\n",k(s,t));
}