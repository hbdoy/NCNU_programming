/**
 * Star.java
 * Author:104213046������
 * �P�P�T����
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
        for(int i=1;i<=x;i++){ //�`�@����x��
            for(int j=1;j<=i;j++){ //�C���L�X��*���Hi�Ȼ��W
                System.out.print("*");
            }
            System.out.print("\n");
        }
        return 0;
    }
}
