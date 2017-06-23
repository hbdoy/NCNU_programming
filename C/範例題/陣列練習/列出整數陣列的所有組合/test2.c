#include <stdio.h>
/**
 * n: data array的長度
 * m: 希望選m個數字 
 * after: 只能選after.. n-1位置的數字
 * got: 目前已選的數字個數 
 */
void com(int data[], int n, int m, int after, int got) {
    int i;
    if (m == got) { // 已選滿m個數字
        for (i = 0; i < m; i++) {
            printf("%d ", data[i]);
        }
        printf("\n");
        return;
    }
    for (i = after; i < n; i++) {
        // 選第i個
        int tmp = data[got];
        data[got] = data[i];
        data[i] = tmp;
        com(data, n, m, i + 1, got+1);
        tmp = data[got];
        data[got] = data[i];
        data[i] = tmp;
    }
}
void combination(int data[], int n, int m) {
    com(data, n, m, 0, 0);
}
int main() {
    int data[10] = {1,2,3,4,5,6,7,8,9,10};
    combination(data, 10, 3);
}