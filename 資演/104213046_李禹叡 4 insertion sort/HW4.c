#include <stdio.h>
int main(){
     int length,i=0,j,k,min,tmp;
     FILE *fp_r=fopen("data.txt","r"); //fopen����}�ɮװʧ@ rŪ��
     FILE *fp_w=fopen("output.txt","w");
     if(fp_r==NULL){
         return -1;
     }
     if(fp_w==NULL){
         return -1;
     }
     fscanf(fp_r,"%d",&length);
     int arr[length];
     while(!feof(fp_r)){ //feof(fp_r)�Ω��ˬd�ɮ׫��ЬO�_��̫᭱ �Y�O�h�Ǧ^�D0�� �Ϥ��^��0
         fscanf(fp_r,"%d",&arr[i]);
         i++;
     }
     /*for(i=0;i<length;i++){
         printf("%d ",arr[i]);
     }*/
     for(k=0;k<length;k++){
             fprintf(fp_w,"%d ",arr[k]);
         }
         fprintf(fp_w,"\n");
     for(i=1;i<length;i++){
         tmp=arr[i];
         j=i-1;
         while(j>-1&&tmp<arr[j]){
             arr[j+1]=arr[j]; //�V�k��
             j--;
         }
         arr[j+1]=tmp; //���J�s��
         for(k=0;k<length;k++){
             fprintf(fp_w,"%d ",arr[k]);
         }
         fprintf(fp_w,"\n");
     }
     fclose(fp_r);
     fclose(fp_w);
 }