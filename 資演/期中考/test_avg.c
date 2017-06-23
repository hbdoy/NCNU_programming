#include <stdio.h>
#include <string.h>
struct Personal{
    char name[10];
    int math,prog,avg;
};

int main(){
    int length,i,j,k,tmp,m;
    char tmpp[10];
    FILE *fp_r=fopen("input.txt","r"); //fopen執行開檔案動作 r讀取
    FILE *fp_w=fopen("104213046_李禹叡.txt","w");
    
    fscanf(fp_r,"%d",&length);
    struct Personal A[length];
    
    for(i=0;i<length;i++){
        fscanf(fp_r,"%s",A[i].name);
    }
    for(i=0;i<length;i++){
        fscanf(fp_r,"%d",&A[i].math);
    }
    for(i=0;i<length;i++){
        fscanf(fp_r,"%d",&A[i].prog);
    }
    for(i=0;i<length;i++){
        A[i].avg=(A[i].math+A[i].prog)/2;
    }
    
    printf("原始資料:.................\n");
    fprintf(fp_w,"原始資料:.................\n");
    for(i=0;i<length;i++){
        printf("%s(數學:%d 程設:%d 平均:%d)\n",A[i].name,A[i].math,A[i].prog,A[i].avg);
        fprintf(fp_w,"%s(數學:%d 程設:%d 平均:%d)\n",A[i].name,A[i].math,A[i].prog,A[i].avg);
    }
    printf("\n\n");
    fprintf(fp_w,"\n");
    
    //strcpy(A[0].name,A[1].name);A[0]變A[1]
    
    for(i=length-1,m=1;i>0;i--,m++){ //氣泡排序
        for(j=1;j<=i;j++){
            if(A[j-1].avg>A[j].avg){
                strcpy(tmpp,A[j-1].name);
                strcpy(A[j-1].name,A[j].name);
                strcpy(A[j].name,tmpp);
                tmp=A[j-1].avg;
                A[j-1].avg=A[j].avg;
                A[j].avg=tmp;
            }
        }
        printf("第%d回合:\n",m);
        fprintf(fp_w,"第%d回合:",m);
        for(k=0;k<length;k++){
            printf("%s(%d) ",A[k].name,A[k].avg);
            fprintf(fp_w," %s(%d)",A[k].name,A[k].avg);
        }
        printf("\n\n");
        fprintf(fp_w,"\n");
    }
    fclose(fp_r);
    fclose(fp_w);
    getch();
}