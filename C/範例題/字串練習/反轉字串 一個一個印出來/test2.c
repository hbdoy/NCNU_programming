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

char reverse(char c[]){
    char tmp;
    int i,j=0;
    j=str(c)-1;
    for(i=0;i<str(c),j>=0;i++){
        printf("%c",c[j]);
        j=j-1;
    }

}

void main(){
    char s[100];
    scanf("%99s",s);
    printf("s=%s\n",s);
    printf("change s=");
    reverse(s);
}