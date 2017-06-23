#include <stdio.h>

int main()
{
    int age;
	char sex;
	printf("input UR age and sex ex:30g or 30b:");
	scanf("%d%c",&age,&sex);
	/*printf("input UR sex boy or girl:");
	scanf("%c",&sex);*/
	if (age>=18&&age<=24&&sex=='g')
	{
	    printf("please be my GF!\n");
	}else if (age>=50&&sex=='b')
	{
	    printf("Go to hell old fish\n");
	}else if (age>=18&&age<=20&&(sex=='b'||sex=='g'))
	{
	    printf("Be my friend\n");
	}else
	{
	    printf("Hello\n");
	}
	
}