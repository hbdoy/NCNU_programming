/*
* ID: 104213046
* Author: 李禹叡
*/
public class Eval{
    private static String[] operators = new String[]{"+","-","*","/","%","^","fun",",","("};
    private static int[] isp = new int[]{1,1,2,2,2,3,6,0,0};
    private static int[] icp = new int[]{1,1,2,2,2,4,6,1,100};
    // 找出String對應到的索引位置
    public static int opid(String x){
        // 數字return -1
        if(x.charAt(0) >= '0' && x.charAt(0) <='9'){
            return -1;
        }
        if(x.length()>1 && (x.charAt(0) == '+' || x.charAt(0) =='-')){
            return -1;
        }
        // 字串開頭是英文字母為函數
        if((x.charAt(0)>='A' && x.charAt(0) <= 'Z') || (x.charAt(0)>='a' && x.charAt(0) <= 'z')){
            return 6; //function
        }
        // 找出剩餘運算子之索引值
        for(int i=0; i<operators.length; i++){
            if(x.equals(operators[i])){
                return i;
            }
        }
        return -1;
    }
    // 對應pop出的運算子做運算,變數型態皆設為double
    public static void cal(String op, Stack number){
        if(op.equals("+")){
            number.push(Double.toString(Double.valueOf(number.pop())+Double.valueOf(number.pop())));
            // Integer.valueOf("123"); //字串轉整數
            // Integer.toString(123); //整數轉字串
            // Float, Double.valueOf("123.456")
        }else if(op.equals("-")){
            // 注意順序 因為會先pop出後面的數字
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

    // 計算x的(m/n)次方
    public static double power(double x, int m, int n){
        return powerXM(root(x, n), m);
    }
    // powerXM函數計算x之m次方
    public static double powerXM(double x, int m){
        double result = 1;
        // 重複乘x m次
        for(int i = 0; i < m; i++){
            result *= x;
        }
        return result;
    }
    // root函數計算x之(1/n)次方
    public static double root(double x, int n){
        // 依據傳入之x設定左右邊界
        double l,r;
        if(x >= 1){
            l = 1;
            r = x;
        }else{
            l = x;
            r = 1;
        }
        double mid = (l+r) / 2;
        // 取兩邊界之中間值不斷乘以n次方，並調整左右邊界，好取得近似值
        while(mid > l && mid < r){
            if(powerXM(mid, n) > x){
                // root(x)應在mid~l之間
                r = mid;
            }else{
                // root(x)應在mid~r之間
                l = mid;
            }
            mid = (l + r) / 2;
        }
        return mid;
    }
    // fac函數計算x!之值
    public static int fac(int x){
        int result = 1, numOfTimes = x;
        // 0! = 1
        if(x==0){
            return 1;
        }else{
            // x會隨運算而變化,所以運算前先賦值給 numOfTimes
            for(int i=0; i<numOfTimes; i++,x--){
                result *= x;
            }
            return result;
        }
    }
    // 反轉函數
    public static int rev(int x){
        int tmp = 0;
        // 用x%10來取得x的最後一位數,取後將x/10,準備取下一位數
        while(x != 0){
            // tmp用來記錄每次取出的最後一位數
            tmp = tmp * 10 + x % 10;
            x = x / 10;
        }
        return tmp;
    }

    public static void eval(String[] data){
        // 只要有運算子pop出,就要拿數字出來做運算
        Stack number = new Stack();
        Stack op = new Stack();
        String y;
        String x;
        for(int i=0; i<data.length; i++){
            // read in next data x
            x = data[i];
            if(x.equals(")")){
                // 運算子stack不為空,且下一個pop出來的符號不等於"("時,不斷執行pop
                while(!op.isEmpty() && !(y=op.pop()).equals("(")){
                    // System.out.print(y+" ");
                    cal(y,number);
                }
            // number push進stack等運算子pop出,再做運算
            }else if(opid(x)==-1){
                // x is a number
                number.push(x);
                // System.out.print(x+" ");
            }else{
                // x is a operator
                // 運算子stack不為空且icp小於前一個isp時,不斷執行pop
                while(!op.isEmpty() && isp[opid(op.peek())] >= icp[opid(x)]){
                    y = op.pop();
                    // 做你該做的事
                    // System.out.print(y+" ");
                    cal(y,number);
                }
                op.push(x);
            }
        }
        // pop出stack中剩餘運算子
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