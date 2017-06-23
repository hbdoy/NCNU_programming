/*
* ID: 104213046
* Author: 李禹叡
*/
import java.lang.*;
import java.util.Scanner;

public class Math{
    //計算x的(m/n)次方
    public static double 分數次方(double x, int m, int n){
        return power(root(x, n), m);
    }

    //power函數計算x之m次方
    public static double power(double x, int m){
        double result = 1;
        //重複乘x m次
        for(int i = 0; i < m; i++){
            result *= x;
        }
        return result;
    }

    //root函數計算x之(1/n)次方
    public static double root(double x, int n){
        //依據傳入之x設定左右邊界
        double l,r;
        if(x >= 1){
            l = 1;
            r = x;
        }else{
            l = x;
            r = 1;
        }
        double mid = (l+r) / 2;
        //取兩邊界之中間值不斷乘以n次方，並調整左右邊界，好取得近似值
        while(mid > l && mid < r){
            if(power(mid, n) > x){
                //root(x)應在mid~l之間
                r = mid;
            }else{
                //root(x)應在mid~r之間
                l = mid;
            }
            mid = (l + r) / 2;
        }
        return mid;
    }

    public static void main(String[] argv){
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("請輸入x,m,n:");
        double x = input.nextDouble();
        int m = input.nextInt();
        int n = input.nextInt();
        //傳入x, m, n後得到x的(m/n)次方
        System.out.println(分數次方(x, m, n));
    }
}