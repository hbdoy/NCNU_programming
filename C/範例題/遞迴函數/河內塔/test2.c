/*
在河內塔的問題中,有三根柱子,n個大小不一樣的碟子,一開始時所有n個碟子以大下小上排在某根柱子上。
在一次只能移動一個碟子,且不違反大下小上的原則下,如何把這n個碟子全部移到另一根柱子上。
再次回憶遞迴的要點
已知邊際條件(最簡單的情況)如何解
假設某函數已經能解大小為n的問題,也就是要決定此函數的參數和傳回值。
如何利用大小為n的解法,來解更大的問題。
解析:
當河內塔的碟子數為0時,問題已解(沒東西好搬了)。
假設三根柱子以int from,to,another來表示,碟子數為n時要這些碟子從from柱子搬到to柱子,
解此問題的函數為move(n,from,to,another)。
如何解n+1個碟子的問題呢?
我們可以把n個碟子由from搬到another,
把最底下的由from搬到to
把n個碟子由another搬到to
為甚麼上面的搬法沒問題?當我們搬上面n個碟子時,
留在from柱子上的是最大的一個碟子,因此不論我們如何搬動n個碟子,一定不會違反規則,
也就是說可以把最底下的當作不存在,好像地板一樣。
*/

#include <stdio.h>
void move(int n, int from, int to, int another) {
    if (n > 0) { // 記得遞迴程式要先寫邊際條件才能作遞迴呼叫
        move(n - 1, from, another, to);
        printf("move %d to %d\n", from, to); // 以印出訊息代表搬動的過程
        move(n - 1, another, to, from);
    }
}
int main() {
    int n=0;
    // 一直讀入數字並執行move,直到使用者輸入的數字小於等於0為止
    while (scanf("%d",&n) != EOF && n > 0) {
        move(n,1,2,3);
    }
}