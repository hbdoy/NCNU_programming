import java.lang.*;
import java.util.Scanner;

public class �ìP{
    String name; //object var
    int test; //var
    static int total�ìP; //class var;static���ܼƦbclass���u�|���@��
    public �ìP(){ //constructor
        System.out.println("�s�ìP���ͤF");
        total�ìP++;
    }
    //method finalize() will be called by GC
    protected void finalize(){
        System.out.println(name+"�ìP�Q�^���F");
        total�ìP--;
    }
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        int i = 0; //local var
        �ìP ����Y;
        ����Y = new �ìP();
        ����Y.name = "��y";
        ����Y = new �ìP();
        ����Y.name = "���2";
        // ����Y = null;
        // System.out.println(����Y.name);

        /*�t�η|�ۦ�^�� ���]�i�H�j��^��*/
        System.gc();

        //����ǰ��D,�H�K��J��gc�^����,�n����ܵ��G���T
        input.next();

        System.out.println("�o�@�ɳѤU"+�ìP.total�ìP+"�ӽìP");

        /*
        //���_���ͷs�������t�Φۤv�^��(���ե�)
        for(;;){
            �ìP x = new �ìP();
            x.name = "�ìP"+i++;
        }
        */

    }
}