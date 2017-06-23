#include <stdio.h>
int main() {
    int year;
    printf("Please input an the year:"); // 提示使用者輸入資料
    scanf("%d", &year); // 輸入年份year
    if (year%4 == 0) {
        if (year%100 == 0) {
            if (year%400 == 0) {
                printf("%d是閏年\n", year);
            } else {
                printf("%d不是閏年\n", year);
            }
        } else {
            printf("%d是閏年\n", year);
        }
    } else {
        printf("%d不是閏年\n", year);
    }
}

/*
#include <stdio.h>
int main() {
    int year;
    printf("Please input the year:"); // 提示使用者輸入資料
    scanf("%d", &year); // 輸入年份year
    if (year%400 == 0 || year%4 == 0 && year%100 != 0) {
        printf("%d是閏年\n", year);
    } else {
        printf("%d不是閏年\n", year);
    }
}
*/