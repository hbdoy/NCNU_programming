#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int GeShu(int a[],int size,int x){
    int i,num=0;  
    for (i=0;i<size;++i){  
        if (x==a[i]){  
            ++num;  
        }
    }  
    return num;  
}  

int Arr(int a[],int size){  
    int temp=0;  
    int i;  
    temp=a[0];  
    for (i=0;i<size;++i){  
        if (GeShu(a,size,a[i])<GeShu(a,size,a[i+1])){  
            temp = a[i+1]; 
        }  
    }  
    return temp;  
}  

int main(){
    int p,n,tmp,max=-1,min=1000,j,i;
    long long total=0;
    double ave=0,mid=0;
    printf("input number:");
    scanf("%d",&p);
    int a[p];
    srand(time(NULL));
    for(i=0;i<p;i++){
        n=rand()%100;
        printf("%2d  ",n);
        a[i]=n;
        n=0;
    }
    printf("\n\n");
    for(i=0;i<p;i++){
        if(a[i]>max){
            max=a[i];
        }
    }
    printf("max=%d\n\n",max);
    for(i=0;i<p;i++){
        if(a[i]<min){
            min=a[i];
        }
    }
    printf("min=%d\n\n",min);
    for(i=0;i<p;i++){
        total=total+a[i];
    }
    ave=(double)total/p;
    printf("ave=%lf\n\n",ave);
    for(i=0;i<p-1;i++){   
        for(j=0;j<(p-1)-i;j++){  
            if(a[j]>a[j+1]){  
                tmp=a[j+1];  
                a[j+1]=a[j];  
                a[j]=tmp;  
            }  
        } 
    }
    printf("after change:\n");
    for(i=0;i<p;i++){
        printf("%2d  ",a[i]);
    }
    printf("\n\n");
    if(p%2!=0){
        mid=a[p/2];
        printf("mid=%lf\n\n",mid);
    }else if(p%2==0){
        mid=(a[p/2]+a[p/2-1])/2;
        printf("mid=%lf\n\n",mid);
    }
    printf("most=%d\n\n",Arr(a,p));
}