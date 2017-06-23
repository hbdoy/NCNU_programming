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

void perlen(char data[],int n,int m,int got,int *sol){
    int i;
    char tmp;
    if(got==m){
            *sol++;
            return;
        }
        for(i=got;i<n;i++){
            tmp=data[i];
            data[i]=data[got];
            data[got]=tmp;
            perlen(data,n,m,got+1,sol);
            tmp=data[i];
            data[i]=data[got];
            data[got]=tmp;
        }
    }


int main(){
    int n,sol=0;
    char data[]={'0','1','2','3','4','5','6','7','8','9'};
    scanf("%d",&n);
    //allocate an array of char
    //with size 10*9*8...(10-n+1)*n
    int size;
    size=n;
    for(i=10;i>10-n;i=i-1)
        size=size*i;
    char *result=(char *) malloc(size);
    perlen(data,10,n,0,&sol);
    printf("%d",sol);
    //print out all permulation
}
