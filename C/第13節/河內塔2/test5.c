#include <stdio.h>

/*int move(int n,int a,int b,int c){
    int steps=0;
    if(n==0)
        return 0;
    steps=move(n-1,a,c,b);
    printf("%d %d\n",a,b);
    //steps++;
    //steps+=move(n-1,a,c,b);
    return steps+move(n-1,c,b,a)+1;
} */

int move(int n,int a,int b,int c){
    if(n==0)
        return 0;
    move(n-1,a,c,b);
    printf("%d %d\n",a,b);
    return 2*move(n-1,c,b,a)+1;
}
int main(){
    int n;
    scanf("%d",&n);
    printf("move %d times\n",move(n,1,2,3));
}
