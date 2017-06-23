/*
* 104213046
* 李禹叡
*/
import java.util.Scanner;
public class PrintFish{
    public static void main (String[] argv){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        //印出魚的上半部
        for(int i=1;i<=n;i++){
            //魚的身體
            star((n-i)*3,' ');
            star(i*3+3*(i-1),'*');
            //魚的尾巴
            star((n-i)*3+(n-i),' ');
            star(i-1,'*');
            System.out.println();
        }
        //印出魚的下半部
        for(int i=n-1;i>=1;i--){
            star((n-i)*3,' ');
            star(i*3+3*(i-1),'*');
            star((n-i)*3+(n-i),' ');
            star(i-1,'*');
            System.out.println();
        }
    }
    
    public static void star(int n,char c){
        //因出指定數量之字元
        for(int i=1;i<=n;i++){
            System.out.print(c);
        }
    }
}
