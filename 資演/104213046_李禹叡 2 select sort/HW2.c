#include <stdio.h>
int main(){
     int length,i=0,j,k,min,tmp;
     FILE *fp_r=fopen("data.txt","r"); //fopen����}�ɮװʧ@ rŪ��
     FILE *fp_w=fopen("output.txt","w");
     if(fp_r==NULL){
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
     for(i=0;i<length-1;i++){
         min=i;
         for(j=i+1;j<length;j++){
             if(arr[j]<arr[min]){
                 min=j;
             }
         }
         tmp=arr[min];
         arr[min]=arr[i];
         arr[i]=tmp;
         for(k=0;k<length;k++){
             fprintf(fp_w,"%d ",arr[k]);
         }
         fprintf(fp_w,"\n");
     }
     fclose(fp_r);
     fclose(fp_w);
 }