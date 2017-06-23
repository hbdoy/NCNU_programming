#include <stdio.h>
#include <math.h>
int main()
{
    int n;
	long long sum,i;
    scanf("%d",&n);
	sum=0;
	for (i=1;i<=n;i=i+1){
		sum=sum+i*i*i;	
	}printf("%lld",sum);
}
