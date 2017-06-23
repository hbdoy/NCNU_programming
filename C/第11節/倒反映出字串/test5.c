#include <stdio.h>
#include <math.h>
#include <stdlib.h>
int strlen(char *s){
    int l=0;
    while(*s!=0){
        s=s+1;
        l=l+1;
    }
    return l;
}
void reverse(char *s){
    char *tmp=s;
    int i;
    s=s+strlen(s)-1;
    for(i=1;i<=strlen(tmp);i++){
        printf("%c",*s);
        s=s-1;
    }
}
int main(){
    char *x="apple";
    printf("%c\n",*x);
    printf("%s\n",x);
    printf(x);
    printf("\n");
    reverse(x);

}