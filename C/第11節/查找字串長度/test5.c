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
int main(){
    char *s="hello world.\n";
    printf(s);
    printf("%d",strlen(s));
    
}