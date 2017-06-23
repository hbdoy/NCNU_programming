#include <stdio.h>
#include <math.h>

int main()
{
    int n,i,j;
    printf("input:");
    scanf("%d",&n);
	for (i=1;i<=n;i=i+1)
	{
        for (j=1;j<=i;j=j+1){
            printf("*");
        }
	printf("\n");
	}
}
