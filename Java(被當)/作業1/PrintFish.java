/*
* 104213046
* ������
*/
import java.util.Scanner;
public class PrintFish{
    public static void main (String[] argv){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        //�L�X�����W�b��
        for(int i=1;i<=n;i++){
            //��������
            star((n-i)*3,' ');
            star(i*3+3*(i-1),'*');
            //��������
            star((n-i)*3+(n-i),' ');
            star(i-1,'*');
            System.out.println();
        }
        //�L�X�����U�b��
        for(int i=n-1;i>=1;i--){
            star((n-i)*3,' ');
            star(i*3+3*(i-1),'*');
            star((n-i)*3+(n-i),' ');
            star(i-1,'*');
            System.out.println();
        }
    }
    
    public static void star(int n,char c){
        //�]�X���w�ƶq���r��
        for(int i=1;i<=n;i++){
            System.out.print(c);
        }
    }
}
