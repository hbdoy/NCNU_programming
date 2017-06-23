// Exception Handling �ҥ~�B�z
// if an Exception is a kind of java.lang.RuntimeException
// then u were not forced to handle it
// otherwise u must handle it by "catch" and "throws"
// Exception�O�@�����O
// ��ΧO�H����� �sĶ���L

class MyException extends Exception { // �I�s�����O constructor
    // constructor ��l��
    public MyException(String msg) {
        super(msg);
    }
    public MyException() {
        // super() ; // this line will be added by compiler
    }
}
public class Test2 {
    public static double fun(double x) throws Exception { // function �ŧi���ɭԭn�� throws
        if (x < 0)
            throw new MyException("�d����");
        return Math.sqrt(x);
    }
    public static void main(String[] argv) {
        // only one Exception block will be matched
        // finally{} always excuted
        try {
            int[] data = {1, 2, 3, 4};
            data[100] = 100;
            System.out.println(fun(-1));
        } catch(MyException err) {
            System.out.println("block MyException");
            err.printStackTrace();
        } catch(RuntimeException err2) {
            System.out.println("block RuntimeException");
            err2.printStackTrace();
        } catch(Exception err3) {
            System.out.println("block Exception");
        } finally { // �@�w�|����
            System.out.println("This block always executed");
        }
    }
}
