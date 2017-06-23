#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

struct LSNode{
    char name[20];
    int age;
    struct LSNode *next;
};

struct LSNode *ptr,*head,*current,*prev,*tail,*forward;
char NamePool[25][20]={"James","David","Christopher","George","Ronald","John","Richard","Daniel","Kenneth","Anthony","Robert","Charles","Paul","Steven","Kevin","Michael","Joseph","Mark","Edward","Jason","William","Thomas","Donald","Brian","Jeff"};
char CNamePool[25][20]={"��Q��","���h��","�J�Q�S","���a��","�i�Τ�","������","�c�Ŵf","�x�Q��","���c�@","�����W","�h�l��","������","���y�","���~��","���l�[","���~��","���ֲ[","�i�䧱","�]�~��","���f��"};
struct LSNode *Head01,*Tail01,*Head02,*Tail02;
int Length01=0,Length02=0;

void LS_Add(struct LSNode *node,struct LSNode *Head,struct LSNode *Tail,int *Length)
{
    if((Head==NULL)&&(Tail==NULL))
    {
        Head=node;
        Tail=node;
    }
    else
    {
        Tail->next=node;
        Tail=node;
    }
    Length++;
}

int main()
{
    int i;
    srand(time(NULL));
    for(i=1;i<=20;i++)
    {
        struct LSNode node;
        strcpy(node.name,NamePool[rand()%25]);
        node.age=rand()%41+20;
        LS_Add(node,Head01,Tail01,&Length01);
    }
}