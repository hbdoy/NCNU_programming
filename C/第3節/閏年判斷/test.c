#include <stdio.h>

int main()
{
    int year;
	printf("input year:");
	scanf("%d",&year);
	if (year%4==0)
	{
		if (year%100==0)
		{
			if(year%400==0)
			{
				printf("leap year!\n");
			}else
			{
				printf("not leap year!\n");
			}
		}else{
			printf("leap year!\n");
		}
	}else
	{
		printf("leap year!\n");
	}
	
	
}