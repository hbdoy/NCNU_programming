/*
* ID: 104213046
* Author: ������
*/
public class Eval{
    private static String[] operators = new String[]{"+","-","*","/","%","^","fun",",","("};
    private static int[] isp = new int[]{1,1,2,2,2,3,6,0,0};
    private static int[] icp = new int[]{1,1,2,2,2,4,6,1,100};
    // ��XString�����쪺���ަ�m
    public static int opid(String x){
        // �Ʀrreturn -1
        if(x.charAt(0) >= '0' && x.charAt(0) <='9'){
            return -1;
        }
        if(x.length()>1 && (x.charAt(0) == '+' || x.charAt(0) =='-')){
            return -1;
        }
        // �r��}�Y�O�^��r�������
        if((x.charAt(0)>='A' && x.charAt(0) <= 'Z') || (x.charAt(0)>='a' && x.charAt(0) <= 'z')){
            return 6; //function
        }
        // ��X�Ѿl�B��l�����ޭ�
        for(int i=0; i<operators.length; i++){
            if(x.equals(operators[i])){
                return i;
            }
        }
        return -1;
    }
    // ����pop�X���B��l���B��,�ܼƫ��A�ҳ]��double
    public static void cal(String op, Stack number){
        if(op.equals("+")){
            number.push(Double.toString(Double.valueOf(number.pop())+Double.valueOf(number.pop())));
            // Integer.valueOf("123"); //�r������
            // Integer.toString(123); //�����r��
            // Float, Double.valueOf("123.456")
        }else if(op.equals("-")){
            // �`�N���� �]���|��pop�X�᭱���Ʀr
            double b = Double.valueOf(number.pop());
            double a = Double.valueOf(number.pop());
            number.push(Double.toString(a-b));
        }else if(op.equals("*")){
            number.push(Double.toString(Double.valueOf(number.pop())*Double.valueOf(number.pop())));
        }else if(op.equals("/")){
            double b = Double.valueOf(number.pop());
            double a = Double.valueOf(number.pop());
            number.push(Double.toString(a/b));
        }else if(op.equals("%")){
            double b = Double.valueOf(number.pop());
            double a = Double.valueOf(number.pop());
            number.push(Double.toString(a%b));
        }else if(op.equals("^")){
            double tmpb = Double.valueOf(number.pop());
            int b = (int)tmpb;
            double a = Double.valueOf(number.pop());
            number.push(Double.toString(powerXM(a,b)));
        }
        else if(op.equals("power")){
            double tmpn = Double.valueOf(number.pop());
            double tmpm = Double.valueOf(number.pop());
            int n = (int)tmpn;
            int m = (int)tmpm;
            double x = Double.valueOf(number.pop());
            number.push(Double.toString(power(x,m,n)));
        }else if(op.equals("fac")){
            double tmpx = Double.valueOf(number.pop());
            int x = (int)tmpx;
            number.push(Integer.toString(fac(x)));
        }else if(op.equals("rev")){
            double tmpx = Double.valueOf(number.pop());
            int x = (int)tmpx;
            number.push(Integer.toString(rev(x)));
        }
    }

    // �p��x��(m/n)����
    public static double power(double x, int m, int n){
        return powerXM(root(x, n), m);
    }
    // powerXM��ƭp��x��m����
    public static double powerXM(double x, int m){
        double result = 1;
        // ���ƭ�x m��
        for(int i = 0; i < m; i++){
            result *= x;
        }
        return result;
    }
    // root��ƭp��x��(1/n)����
    public static double root(double x, int n){
        // �̾ڶǤJ��x�]�w���k���
        double l,r;
        if(x >= 1){
            l = 1;
            r = x;
        }else{
            l = x;
            r = 1;
        }
        double mid = (l+r) / 2;
        // ������ɤ������Ȥ��_���Hn����A�ýվ㥪�k��ɡA�n���o�����
        while(mid > l && mid < r){
            if(powerXM(mid, n) > x){
                // root(x)���bmid~l����
                r = mid;
            }else{
                // root(x)���bmid~r����
                l = mid;
            }
            mid = (l + r) / 2;
        }
        return mid;
    }
    // fac��ƭp��x!����
    public static int fac(int x){
        int result = 1, numOfTimes = x;
        // 0! = 1
        if(x==0){
            return 1;
        }else{
            // x�|�H�B����ܤ�,�ҥH�B��e����ȵ� numOfTimes
            for(int i=0; i<numOfTimes; i++,x--){
                result *= x;
            }
            return result;
        }
    }
    // ������
    public static int rev(int x){
        int tmp = 0;
        // ��x%10�Ө��ox���̫�@���,����Nx/10,�ǳƨ��U�@���
        while(x != 0){
            // tmp�ΨӰO���C�����X���̫�@���
            tmp = tmp * 10 + x % 10;
            x = x / 10;
        }
        return tmp;
    }

    public static void eval(String[] data){
        // �u�n���B��lpop�X,�N�n���Ʀr�X�Ӱ��B��
        Stack number = new Stack();
        Stack op = new Stack();
        String y;
        String x;
        for(int i=0; i<data.length; i++){
            // read in next data x
            x = data[i];
            if(x.equals(")")){
                // �B��lstack������,�B�U�@��pop�X�Ӫ��Ÿ�������"("��,���_����pop
                while(!op.isEmpty() && !(y=op.pop()).equals("(")){
                    // System.out.print(y+" ");
                    cal(y,number);
                }
            // number push�istack���B��lpop�X,�A���B��
            }else if(opid(x)==-1){
                // x is a number
                number.push(x);
                // System.out.print(x+" ");
            }else{
                // x is a operator
                // �B��lstack�����ťBicp�p��e�@��isp��,���_����pop
                while(!op.isEmpty() && isp[opid(op.peek())] >= icp[opid(x)]){
                    y = op.pop();
                    // ���A�Ӱ�����
                    // System.out.print(y+" ");
                    cal(y,number);
                }
                op.push(x);
            }
        }
        // pop�Xstack���Ѿl�B��l
        while(!op.isEmpty()){
            y = op.pop();
            // System.out.print(y+" ");
            cal(y,number);
        }
        System.out.println(number.pop());
    }

    public static void main(String[] argv){
        String[] data1 = {"4","*","(","2","+","3",")","+","3","^","2"};
        String[] data2 = {"199","%","10","-","(","-1",")","+","power","(","5",",","3",",","2",")"};
        String[] data3 = {"rev","(","200",")","*","fac","(","5",")","/","(","10","%","6",")","-","8"};
        String[] data4 = {"4","-","rev","(","123",")","/","6","+","37","%","3","+","45","+","fac","(","0",")"};
        String[] data5 = {"power","(","fac","(","rev","(","21",")",")",",","2",",","2","+","3",")"};
        eval(data1);
        eval(data2);
        eval(data3);
        eval(data4);
        eval(data5);
    }
}