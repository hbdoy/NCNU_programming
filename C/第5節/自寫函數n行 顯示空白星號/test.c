#include <stdio.h>
#include <math.h>
//try to print out len個c字元
void print(char c,int len){
	int i; //此處i只會在{}間生效 所以不會在main函數中生效
	for (i=1;i<=len;i=i+1){
		printf("%c",c);
	}
}


int main()
{
    int n;
	int i;
    scanf("%d",&n);
	for (i=1;i<=n;i=i+1)
	{
	print(' ',n-i);
	print('*',i);
	printf("\n");
	}
}
