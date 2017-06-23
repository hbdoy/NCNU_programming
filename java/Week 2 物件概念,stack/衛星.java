import java.lang.*;
import java.util.Scanner;

public class 衛星{
    String name; //object var
    int test; //var
    static int total衛星; //class var;static表此變數在class中只會有一個
    public 衛星(){ //constructor
        System.out.println("新衛星產生了");
        total衛星++;
    }
    //method finalize() will be called by GC
    protected void finalize(){
        System.out.println(name+"衛星被回收了");
        total衛星--;
    }
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        int i = 0; //local var
        衛星 手指頭;
        手指頭 = new 衛星();
        手指頭.name = "月球";
        手指頭 = new 衛星();
        手指頭.name = "木衛2";
        // 手指頭 = null;
        // System.out.println(手指頭.name);

        /*系統會自行回收 但也可以強制回收*/
        System.gc();

        //執行序問題,隨便輸入等gc回收完,好讓顯示結果正確
        input.next();

        System.out.println("這世界剩下"+衛星.total衛星+"個衛星");

        /*
        //不斷產生新物件讓系統自己回收(測試用)
        for(;;){
            衛星 x = new 衛星();
            x.name = "衛星"+i++;
        }
        */

    }
}