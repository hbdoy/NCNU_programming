#include <stdio.h>

int main()
{
    int age;
	printf("input UR age:");
	scanf("%d",&age);
	if (age>=18&&age<=24)
	{
	    printf("U could be college students.\n");
	}else if (age>=12&&age<=17)
	{
	    printf("UR a teenager\n");
	}else if (age<12)
	{
	    printf("UR a child\n");
	}else
	{
	    printf("UR old!\n");
	}
	
}