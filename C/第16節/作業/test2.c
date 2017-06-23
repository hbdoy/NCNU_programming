#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
    char[10] x;
    char[10] answer;
    char *all=perm(....);
    char *available=malloc(sizeof(char));
    int a,b;
    int gota,gotb;
    srand=(time(NULL));
    //set available to 1
    for(;;){
        x=guess(all,available);
        //printf out x
        //read in gota,gotb
        if(gota==4&&gotb==0)
            break;
        eliminate(all,available,x,gota,gotb);
    }
}