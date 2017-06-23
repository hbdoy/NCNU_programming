import java.lang.*;
import java.util.Scanner;

public class Hello{
    public static double ���Ʀ���(double x, int m, int n){
        return power(root(x, n), m);
    }

    public static double power(double x, int m){
        double result = 1;
        for(int i = 0; i < m; i++){
            result *= x;
        }
        return result;
    }

    public static double root(double x, int n){
        double l,r;
        if(x >= 1){
            l = 1;
            r = x;
        }else{
            l = x;
            r = 1;
        }
        double mid = (l+r) / 2;
        while(mid > l && mid < r){
            if(power(mid, n) > x){
                //sqrt(x)���bmid~l����
                r = mid;
            }else{
                l = mid;
            }
            mid = (l + r) / 2;
        }
        return mid;
    }

    public static void test(int x){
        switch(x){
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("not 1 or 2");
        }
    }

    public static void test2(int x){
        for(int i=0; i<x; i++){
            if(i%2==0){
                continue;
            }
            System.out.println(i);
        }
    }

    public static void main(String[] argv){
        // Scanner input;
        // input = new Scanner(System.in);
        // System.out.println("�п�Jx,m,n:");
        // double x = input.nextDouble();
        // int m = input.nextInt();
        // int n = input.nextInt();
        // System.out.println(���Ʀ���(x, m, n));
        test2(100);
    }
}