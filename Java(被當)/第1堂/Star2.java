/**
 * Star2.java
 * Author:Ryan
 * 星號三角形
 */
import java.util.Scanner;
public class Star2{
    public static void main(String[] argv){
        System.out.print("input a number:");
        Scanner k=new Scanner(System.in);
        int n=k.nextInt();
        for (int j=1;j<=n;j=j+1){
            A(' ',n-j);
            A('*',2*j-1);
            System.out.print("\n");
        }
        for (int o=n-1;o>=1;o=o-1){
            A(' ',n-o);
            A('*',2*o-1);
            System.out.print("\n");
        }
    }

    public static int A(char m,int x){
        for(int i=1;i<=x;i++){
            System.out.print(m);
        }
        return 0;
    }
}
