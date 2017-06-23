#include <stdio.h>
#define SIZE 6
int main() {
    int i, j, min, at, tmp;
    int data[] = {5,7,1,4,3, 2};
    for (i = 0; i < SIZE - 1; i++) {
        min = data[i];
        at = i;
        for (j = i+1; j < SIZE; j++) {
            if (data[j] < min) {
                min = data[j];
                at = j;
            }
        }
        tmp = data[i];
        data[i] = min;
        data[at] = tmp;
    }
    for (i = 0; i < SIZE; i++) printf("%d\n", data[i]);
}