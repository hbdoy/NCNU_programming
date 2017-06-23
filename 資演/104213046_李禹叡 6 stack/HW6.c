#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#define Max 10
char stack_name[Max][20];
int  stack_score[10];
int top=-1;

struct Personal{
    char name[20];
    int score;
};

int IsFull(){ //push時判斷是否滿了
    if(top>=Max-1){
        return 1;
    }else{
        return 0;
    }
}

int IsEmpty(){ //pop時判斷是否沒有值了
    if(top<0){
        return 1;
    }else{
        return 0;
    }
}

void push(char *A,int score){
    if(IsFull()){
        printf("The stack is Full!!\n");
    }else{
        top++;
        printf("%s  %d  push in stack!!\n",A,score);
        strcpy(stack_name[top],A);
        stack_score[top]=score;
    }
}

void pop(){
    if(IsEmpty()){
        printf("The stack is Empty!!\n");
    }else{
        printf("%s  %d  pop out from stack!!\n",stack_name[top],stack_score[top]);
        top--;
    }
}

void list(){
    int i,count=top+1;
    if(IsEmpty()){
        printf("Total item : 0\n");
        printf("The stack is Empty!!\n");
    }else{
        printf("Total item : %d\n",count);
        for(i=top;i>=0;i--,count--){
            printf("%d    %s  %d\n",count,stack_name[i],stack_score[i]);
        }
    }
}

int main(){
    int i,rnd;
    srand(time(NULL));
    struct Personal A[10]={
        {"Ryan",((rand()%100)+1)},
        {"Ken",((rand()%100)+1)},
        {"Andy",((rand()%100)+1)},
        {"Bob",((rand()%100)+1)},
        {"Jim",((rand()%100)+1)},
        {"Rose",((rand()%100)+1)},
        {"Anna",((rand()%100)+1)},
        {"Jane",((rand()%100)+1)},
        {"Lily",((rand()%100)+1)},
        {"Mary",((rand()%100)+1)}
    };
    for(i=0;i<30;i++){
        rnd=rand()%10;
        printf("\n****************** The %d test ******************\n",i+1);
        if(rnd%2==0){
            printf("rnd=%d , is even , do 'push'\n",rnd);
            push(A[rnd].name,A[rnd].score);
        }else{
            printf("rnd=%d , is odd , do 'pop'\n",rnd);
            pop();
        }
        printf("\n----------- The current stack is : -----------\n");
        list();
    }
    getch();
}