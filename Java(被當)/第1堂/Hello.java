/**
 * Hello.java
 * Author:Ryan
 */
import java.util.Scanner;
public class Hello{
    public static void main (String[] argv){
        Scanner k=new Scanner(System.in);
        int n=k.nextInt();
        System.out.println("Your input is "+n);
        System.out.print("Hello World\n"); //println差別在自動換行
        System.out.println("power(3,5)="+power(3,5)+"\n");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        star(n);
    }
    
    public static int power(int x,int n){
        int result=1;
        for(int i=1;i<=n;i++)
            result=result*x;
        return result;
    }
    public static int star(int x){
        for(int i=1;i<=x;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
        return 0;
    }
}
