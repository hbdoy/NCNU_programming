/*
* ID: 104213046
* Author: ������
*/
import java.lang.*;
import java.util.Scanner;

public class Math{
    //�p��x��(m/n)����
    public static double ���Ʀ���(double x, int m, int n){
        return power(root(x, n), m);
    }

    //power��ƭp��x��m����
    public static double power(double x, int m){
        double result = 1;
        //���ƭ�x m��
        for(int i = 0; i < m; i++){
            result *= x;
        }
        return result;
    }

    //root��ƭp��x��(1/n)����
    public static double root(double x, int n){
        //�̾ڶǤJ��x�]�w���k���
        double l,r;
        if(x >= 1){
            l = 1;
            r = x;
        }else{
            l = x;
            r = 1;
        }
        double mid = (l+r) / 2;
        //������ɤ������Ȥ��_���Hn����A�ýվ㥪�k��ɡA�n���o�����
        while(mid > l && mid < r){
            if(power(mid, n) > x){
                //root(x)���bmid~l����
                r = mid;
            }else{
                //root(x)���bmid~r����
                l = mid;
            }
            mid = (l + r) / 2;
        }
        return mid;
    }

    public static void main(String[] argv){
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("�п�Jx,m,n:");
        double x = input.nextDouble();
        int m = input.nextInt();
        int n = input.nextInt();
        //�ǤJx, m, n��o��x��(m/n)����
        System.out.println(���Ʀ���(x, m, n));
    }
}