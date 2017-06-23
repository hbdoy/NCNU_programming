#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main(){
    int rnd,i,j,key=1,p=0,q=0,tmp=0;
    srand(time(NULL));
    do{
        rnd=(rand()%11)+20;
    }while(rnd%2==0); //���_��
    int data[rnd][rnd];
    int row=0; //�}�C���ޥ�0�}�l
    int column=(rnd-1)/2; //�q�����}�l
    for(i=0;i<rnd;i++){ //���w���0
        for(j=0;j<rnd;j++){
            data[i][j]=0;
        }
    }
    data[row][column]=key++; //��l��
    for(key=2;key<=rnd*rnd;key++){
        tmp=0; //�����O�_�ഫ�L
        p=row,q=column; //�X�ɫe����m
        row=row-1; //�V�W����
        column=column+1; //�V�k����
        if((row<0)&&(column<=(rnd-1))){ //�C�X�� �楼�X��
            row=rnd-1;
        }else if((row<0)&&(column>(rnd-1))){ //�C�X�� ��X��
            row=rnd-1;
            column=0;
        }else if((row>=0)&&(column>(rnd-1))){ //�C���X�� ��X��
            column=0;
        }
        if(data[row][column]!=0){ //�����ʦ�m���Ʀr�h�U��@�C
            p=p+1;
            if(p>(rnd-1)){ //�ˬd�O�_�C�X��
                p=0;
            }
            tmp=1;
        }
        if(tmp==1){
            data[p][q]=key; //�s��m�����m�V�U�@�C
            row=p;
            column=q;
        }else if(tmp==0){ //�s��m����
            data[row][column]=key;
        }
    }
    printf("This odd magic square is %dx%d\n",rnd,rnd);
    for(i=0;i<rnd;i++){
        for(j=0;j<rnd;j++){
            printf("%2d ",data[i][j]);
        }
        printf("\n");
    }
    int midrowsum=0,midcolumnsum=0,diagonalsum=0;
    int mid=rnd/2;
    for(i=0;i<rnd;i++){
        midrowsum+=data[mid][i]; //�����C���M
        midcolumnsum+=data[i][mid]; //�����椧�M
        diagonalsum+=data[i][i]; //�﨤�u���M
    }
    printf("The sum of the middle row is %d\n",midrowsum);
    printf("The sum of the middle column is %d\n",midcolumnsum);
    printf("The sum of the diagonal is %d\n",diagonalsum);
 }