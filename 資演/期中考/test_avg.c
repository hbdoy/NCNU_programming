#include <stdio.h>
#include <string.h>
struct Personal{
    char name[10];
    int math,prog,avg;
};

int main(){
    int length,i,j,k,tmp,m;
    char tmpp[10];
    FILE *fp_r=fopen("input.txt","r"); //fopen����}�ɮװʧ@ rŪ��
    FILE *fp_w=fopen("104213046_������.txt","w");
    
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
    
    printf("��l���:.................\n");
    fprintf(fp_w,"��l���:.................\n");
    for(i=0;i<length;i++){
        printf("%s(�ƾ�:%d �{�]:%d ����:%d)\n",A[i].name,A[i].math,A[i].prog,A[i].avg);
        fprintf(fp_w,"%s(�ƾ�:%d �{�]:%d ����:%d)\n",A[i].name,A[i].math,A[i].prog,A[i].avg);
    }
    printf("\n\n");
    fprintf(fp_w,"\n");
    
    //strcpy(A[0].name,A[1].name);A[0]��A[1]
    
    for(i=length-1,m=1;i>0;i--,m++){ //��w�Ƨ�
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
        printf("��%d�^�X:\n",m);
        fprintf(fp_w,"��%d�^�X:",m);
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