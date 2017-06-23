public class Eval{
    private static String[] operators = new String[]{"+","-","*","/","%","^","fun","("};
    private static int[] isp = new int[]{1,1,2,2,2,3,6,0};
    private static int[] icp = new int[]{1,1,2,2,2,4,6,100};
    //找出String對應到的索引位置
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
            // Integer.valueOf("123"); //字串轉整數
            // Integer.toString(123); //整數轉字串
            // Float, Double.valueOf("123.456")
        }else if(op.equals("-")){
            //注意順序 因為會先pop出後面的數字
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
        //重複乘x m次
        for(int i = 0; i < m; i++){
            result *= x;
        }
        return result;
    }
    public static void eval(String[] data){
        //只要有運算子pop出,就要拿數字出來做運算
        Stack number = new Stack();
        Stack op = new Stack();
        String y;
        String x;
        for(int i=0; i<data.length; i++){
            //read in next data x
            x = data[i];
            if(x.equals(")")){
                //運算子stack不為空,且下一個pop出來的符號不等於"("時,不斷執行pop
                while(!op.isEmpty() && !(y=op.pop()).equals("(")){
                    // System.out.print(y+" ");
                    cal(y,number);
                }
                //number push進stack等運算子轉成後置,再做運算
            }else if(opid(x)==-1){
                //x is a number
                number.push(x);
                // System.out.print(x+" ");
            }else{
                //x is a operator
                //運算子stack不為空且icp小於前一個isp時,不斷執行pop
                while(!op.isEmpty() && isp[opid(op.peek())] >= icp[opid(x)]){
                    y = op.pop();
                    // 做你該做的事
                    // System.out.print(y+" ");
                    cal(y,number);
                }
                op.push(x);
            }
        }
        //pop出stack中剩餘運算子
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