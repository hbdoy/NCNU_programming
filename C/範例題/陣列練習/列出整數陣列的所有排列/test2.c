#include <stdio.h>
/* 列出由at左邊所有的排列 */
void permutation(int data[], int at, int arraySize) {
    int i, tmp;
    // 如果已經排到最後了,印出結果
    if (at == arraySize) {
        for (i = 0; i < arraySize; i++) {
            printf("%d ", data[i]);
        }
        printf("\n");
        return;
    }
    for (i = at; i < arraySize; i++) { // choose ith element
        // exchange at with i
        tmp = data[i];
        data[i] = data[at];
        data[at] = tmp;
        permutation(data, at + 1, arraySize);
        // exchange back, so that we undo previous exchange
        tmp = data[i];
        data[i] = data[at];
        data[at] = tmp;
    }
}
int main() {
    int data[] = {1,2,3};
    permutation(data, 0, 3);
}