#include <stdio.h>

void perm(char *data,int n,int from){
    int i,j;
    char tmp;
    if(from==n){
        for(i=0;i<n;i++){
            printf("%c",data[i]);
        }
        printf("\n");
        return;
    }
    for(i=from;i<n;i++){
            tmp=data[i];
            for(j=i;j>from;j--){
                data[j]=data[j-1];
            }
            data[from]=tmp;
            perm(data,n,from+1);
            tmp=data[from];
            for(j=from;j<i;j++){
                data[j]=data[j+1];
            }
            data[i]=tmp;
        }
}

int main(){
    int n;
    char data[]={'a','b','c','d'};
    perm(data,4,0);
}
