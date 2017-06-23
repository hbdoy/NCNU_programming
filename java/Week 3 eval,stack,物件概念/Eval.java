public class Eval{
    private static String[] operators = new String[]{"+","-","*","/","%","^","fun","("};
    private static int[] isp = new int[]{1,1,2,2,2,3,6,0};
    private static int[] icp = new int[]{1,1,2,2,2,4,6,100};
    //��XString�����쪺���ަ�m
    public static int opid(String x){
        if(x.charAt(0) >= '0' && x.charAt(0) <='9'){
            return -1;
        }
        if(x.length()>1 && (x.charAt(0) == '+' || x.charAt(0) =='-')){
            return -1;
        }
        if((x.charAt(0)>='A' && x.charAt(0) <= 'Z') || (x.charAt(0)>='a' && x.charAt(0) <= 'z')){
            return 6; //function
        }
        for(int i=0; i<operators.length; i++){
            if(x.equals(operators[i])){
                return i;
            }
        }
        return -1;
    }
    public static void cal(String op, Stack number){
        if(op.equals("+")){
            number.push(Integer.toString(Integer.valueOf(number.pop())+Integer.valueOf(number.pop())));
            // Integer.valueOf("123"); //�r������
            // Integer.toString(123); //�����r��
            // Float, Double.valueOf("123.456")
        }else if(op.equals("-")){
            //�`�N���� �]���|��pop�X�᭱���Ʀr
            int b = Integer.valueOf(number.pop());
            int a = Integer.valueOf(number.pop());
            number.push(Integer.toString(a-b));
        }else if(op.equals("*")){
            number.push(Integer.toString(Integer.valueOf(number.pop())*Integer.valueOf(number.pop())));
        }else if(op.equals("/")){
            int b = Integer.valueOf(number.pop());
            int a = Integer.valueOf(number.pop());
            number.push(Integer.toString(a/b));
        }else if(op.equals("%")){
            int b = Integer.valueOf(number.pop());
            int a = Integer.valueOf(number.pop());
            number.push(Integer.toString(a%b));
        }else if(op.equals("^")){
            int b = Integer.valueOf(number.pop());
            int a = Integer.valueOf(number.pop());
            number.push(Integer.toString(power(a,b)));
        }
    }
    public static int power(int x, int m){
        int result = 1;
        //���ƭ�x m��
        for(int i = 0; i < m; i++){
            result *= x;
        }
        return result;
    }
    public static void eval(String[] data){
        //�u�n���B��lpop�X,�N�n���Ʀr�X�Ӱ��B��
        Stack number = new Stack();
        Stack op = new Stack();
        String y;
        String x;
        for(int i=0; i<data.length; i++){
            //read in next data x
            x = data[i];
            if(x.equals(")")){
                //�B��lstack������,�B�U�@��pop�X�Ӫ��Ÿ�������"("��,���_����pop
                while(!op.isEmpty() && !(y=op.pop()).equals("(")){
                    // System.out.print(y+" ");
                    cal(y,number);
                }
                //number push�istack���B��l�ন��m,�A���B��
            }else if(opid(x)==-1){
                //x is a number
                number.push(x);
                // System.out.print(x+" ");
            }else{
                //x is a operator
                //�B��lstack�����ťBicp�p��e�@��isp��,���_����pop
                while(!op.isEmpty() && isp[opid(op.peek())] >= icp[opid(x)]){
                    y = op.pop();
                    // ���A�Ӱ�����
                    // System.out.print(y+" ");
                    cal(y,number);
                }
                op.push(x);
            }
        }
        //pop�Xstack���Ѿl�B��l
        while(!op.isEmpty()){
            y = op.pop();
            // System.out.print(y+" ");
            cal(y,number);
        }
        System.out.println(number.pop());
    }

    public static void main(String[] argv){
        // String[] data = {"4","*","(","2","+","3",")","+","3","^","2"};
        String[] data = {"3","+","-1"};
        eval(data);
    }
}