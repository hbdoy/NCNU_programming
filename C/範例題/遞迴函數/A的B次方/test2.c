#include <stdio.h>
power(int a, int b);
void main(void) {
    int x, y;
    printf("Please input two number:");
    scanf("%d %d", &x, &y);
    printf("\n%d^%d = %d", x, y, power(x, y));
}
int power(int a, int b) {
    switch(b) {
    case 0: return 1;
    case 1: return a;
    default: return (a * power(a, b - 1));
    }
}