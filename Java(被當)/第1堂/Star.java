/**
 * Star.java
 * Author:104213046李禹叡
 * 星星三角形
 */
import java.util.Scanner;
public class Star{
    public static void main(String[] argv){
        System.out.print("input a number:");
        Scanner k=new Scanner(System.in);
        int n=k.nextInt();
        star(n);
    }

    public static int star(int x){
        for(int i=1;i<=x;i++){ //總共執行x次
            for(int j=1;j<=i;j++){ //每次印出的*號隨i值遞增
                System.out.print("*");
            }
            System.out.print("\n");
        }
        return 0;
    }
}
