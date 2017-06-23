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
/**
 * @data data to combination
 * @n length of data
 * @m length of combination
 * @got length of already determinated data
 * @from choose elements from this positon to n-1
 */

void com(char data[],int n,int m,int got,int from){
    int i;
    char tmp;
    if(got==m){
        for(i=0;i<m;i++){
            printf("%c",data[i]);
            printf("\n");
            return;
        }
        for(i=from;i<n;i++){
            tmp=data[i];
            data[i]=data[got];
            data[got]=tmp;
            com(data,n,m,got+1,i+1);
            tmp=data[i];
            data[i]=data[got];
            data[got]=tmp;
        }
    }
}

int main(){
    int n;
    char data[]={'a','b','c','d','e'};
    com(data,5,3,3,0);
}
