#include <stdio.h>
#define n 3 //A,B,C=A+B
struct equation{ //���xstruct
    int item; //헔�
    int power[20]; //����ʽ֮�η�
    int constant[20]; //����ʽ֮����
};
int main(){
    int i=0,k=0,p,q,m;
    struct equation A[n]; //����struct A[3](A,B,C)
    int tmp[40];
    for(i=0;i<20;i++){ //�x���ʼֵ�oA��B֮�η��c�������
        A[0].power[i]=-1;
        A[0].constant[i]=0;
        A[1].power[i]=-1;
        A[1].constant[i]=0;
    }
    printf("please input equation A by the rule of 2m+1:\n");  //ݔ�뷽��ʽA
    scanf("%d",&k); //ݔ��헔�
    for(i=0;i<2*k;i++){ //ݔ��ʣ����
        scanf("%d",&tmp[i]);
    }
    A[0].item=k; //A֮헔�
    for(i=0,p=0,q=0;i<2*k;i++){ //��ݔ���ֵ���oA֮�η����������
        if(i%2==0){
            A[0].power[p]=tmp[i];
            p++;
        }
        if(i%2!=0){
            A[0].constant[q]=tmp[i];
            q++;
        }
    }
    printf("\n");
    printf("please input equation B by the rule of 2m+1:\n"); 
    scanf("%d",&k); //ݔ��헔�
    for(i=0;i<2*k;i++){ //ݔ��ʣ����
        scanf("%d",&tmp[i]);
    }
    A[1].item=k; //B֮헔�
    for(i=0,p=0,q=0;i<2*k;i++){ //��ݔ���ֵ���oB֮�η����������
        if(i%2==0){
            A[1].power[p]=tmp[i];
            p++;
        }
        if(i%2!=0){
            A[1].constant[q]=tmp[i];
            q++;
        }
    }
    printf("\n");
    for(i=0,p=0,q=0,m=0;i<(A[0].item+A[1].item);i++){ //A B���֮�Y���}�u��C
        if(A[0].power[p]>A[1].power[q]){
            A[2].power[m]=A[0].power[p];
            A[2].constant[m]=A[0].constant[p];
            m++;
            p++;
        }else if(A[0].power[p]<A[1].power[q]){
            A[2].power[m]=A[1].power[q];
            A[2].constant[m]=A[1].constant[q];
            m++;
            q++;
        }else if(A[0].power[p]==A[1].power[q]){
            A[2].power[m]=A[0].power[p];
            A[2].constant[m]=(A[0].constant[p]+A[1].constant[q]);
            m++;
            p++;
            q++;
        }
    }
    printf("equation A = ");
    for(i=0;i<A[0].item;i++){ //ӡ��A
        if(i!=0){
            printf(" + ");
        }
        if(A[0].power[i]==0){ //���鳣���t��ӡ��x^0
            printf("(%d)",A[0].constant[i]);
        }else if(A[0].power[i]!=0){
            printf("(%d)X^%d",A[0].constant[i],A[0].power[i]);
        }
    }
    printf("\n");
    printf("equation B = ");
    for(i=0;i<A[1].item;i++){ //ӡ��B
        if(i!=0){
            printf(" + ");
        }
        if(A[1].power[i]==0){ //���鳣���t��ӡ��x^0
            printf("(%d)",A[1].constant[i]);
        }else if(A[1].power[i]!=0){
            printf("(%d)X^%d",A[1].constant[i],A[1].power[i]);
        }
    }
    printf("\n");
    printf("equation A + B = ");
    for(i=0;i<m;i++){ //ӡ��A+B
        if(A[2].power[i]>-1){ //��������Y�� �������е�m��
            if(i!=0){
            printf(" + ");
        }
        if(A[2].power[i]==0){ //���鳣���t��ӡ��x^0
            printf("(%d)",A[2].constant[i]);
        }else if(A[2].power[i]!=0){
            printf("(%d)X^%d",A[2].constant[i],A[2].power[i]);
        }
        }
    }
}