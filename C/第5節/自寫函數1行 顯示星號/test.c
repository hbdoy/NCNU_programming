#include <stdio.h>
#include <math.h>
//try to print out len個c字元
void A(char c,int k){
	int i; //此處i只會在{}間生效 所以不會在main函數中生效
	for (i=1;i<=k;i=i+1){
		printf("%c",c);
	}
}


int main()
{
    int n;
    printf("input:");
    scanf("%d",&n);
    A('*',n);
}
