#include<stdio.h>
int MIN(int array[],int size){
    int temp; 
    if(size==1)
        return array[0]; 
    if((temp=MIN(array,size-1))>array[size-1])
        return array[size-1]; 
    else 
        return temp;
}

int main(int argc,char *argv[]){ 
    int array[5]={1234,100,1,2,-100}; 
    printf("%d",MIN(array,5));
    getch(); 
    return 0; 
}