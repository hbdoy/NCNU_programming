import java.lang.*;
import java.util.Scanner;

public class Test{
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

    public static void test3(int x){
        if(x<=0){
            return;
        }
        System.out.println(x);
        test3(x-1);
    }

    public static void main(String[] argv){

    }
}