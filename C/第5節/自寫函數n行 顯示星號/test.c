#include <stdio.h>
#include <math.h>
//try to print out len個c字元
void A(char c,int k){
	int m; //此處i只會在{}間生效 所以不會在main函數中生效
	for (m=1;m<=k;m=m+1){
		printf("%c",c);
	}
}


int main()
{
    int n,i;
    scanf("%d",&n);
	for (i=1;i<=n;i=i+1)
	{
	    A('*',i);
	 printf("\n");
	}
}
