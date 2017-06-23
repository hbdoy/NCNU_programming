public class BigInt{
    private int[] digits = new int[1000];
    public BigInt(){
    }
    public BigInt(String s){
        int i = 0;
        boolean negative = false;
        if(s.charAt(0) == '-'){
            negative = true;
            i++;
        }
        for(; i < s.length(); i++){
            digits[s.length()-i-1] = s.charAt(i) - '0';
        }
        if(negative){
            BigInt tmp = this.complement();
            for(i = 0; i < digits.length; i++){
                digits[i] = tmp.digits[i];
            }
        }
    }
    public String toString(){
        String result = "";
        boolean negative = false;
        BigInt tmp = this;
        if(digits[digits.length - 1] >= 5){
            negative = true;
            tmp = this.complement();
        }
        int i = digits.length - 1;
        while(i >= 0 && tmp.digits[i] == 0){
            i--;
        }
        while(i >= 0){
            result = result + (char)(tmp.digits[i--] + '0');
        }
        if(result.equals("")){
            return "0";
        }
        if(negative){
            return "-" + result;
        }
        return result;
    }
    public BigInt add(BigInt y){
        BigInt result = new BigInt();
        for(int i = 0; i < digits.length; i++){
            result.digits[i] = digits[i] + y.digits[i];
        }
        return result.normalize();
    }
    private BigInt normalize(){
        int carry = 0;
        for(int i = 0; i < digits.length; i++){
            int result = carry + digits[i];
            digits[i] = result % 10;
            carry = result / 10;
        }
        return this;
    }
    public BigInt mul(BigInt y){
        BigInt result = new BigInt();
        for(int i = 0; i < digits.length; i++){
            BigInt tmp = new BigInt();
            for(int j = 0; j < digits.length; j++){
                if(i+j < digits.length){
                    tmp.digits[i+j] = digits[i] * y.digits[j];
                }
            }
            result = result.add(tmp);
        }
        return result.normalize();
    }
    private BigInt complement(){
        normalize();
        BigInt result = new BigInt();
        for(int i = 0; i < digits.length; i++){
            result.digits[i] = 9 - digits[i];
        }
        result.digits[0]++;
        return result.normalize();
    }
    public BigInt sub(BigInt y){
        return this.add(y.complement());
    }
    public boolean isNegative(){
        return digits[digits.length - 1] >= 5;
    }
    public BigInt div(BigInt y){
        BigInt x = this;
        boolean negative = false;
        if(this.isNegative()){
            negative = !negative;
            x = this.complement();
        }
        if(y.isNegative()){
            negative = !negative;
            y = y.complement();
        }
        BigInt result = new BigInt();
        x = x.sub(y);
        while(!x.isNegative()){
            x = x.sub(y);
            result = result.add(new BigInt("1"));
        }
        if(negative){
            return result.complement();
        }
        return result;
    }
    public BigInt mod(BigInt y){
        BigInt x = this;
        boolean negative = false;
        if(this.isNegative()){
            negative = !negative;
            x = this.complement();
        }
        if(y.isNegative()){
            negative = !negative;
            y = y.complement();
        }
        x = x.sub(y);
        while(!x.isNegative()){
            x = x.sub(y);
        }
        x = x.add(y);
        if(negative){
            return x.complement();
        }
        return x;
    }
    private int compare(BigInt y){
        int i;
        for(i = digits.length-1; i >= 0 && digits[i] == y.digits[i]; i--){}
        if(i < 0){
            return 0;
        }
        return digits[i] - y.digits[i];
    }
    private BigInt bigDouble(){
        BigInt result = new BigInt();
        for(int i =0; i < digits.length; i++){
            result.digits[i] = 2 * digits[i];
        }
        return result.normalize();
    }
    public BigInt fastDiv(BigInt y){
        BigInt result = new BigInt();
        BigInt remain = this;
        BigInt div = y;
        BigInt[] ser = new BigInt[3000];
        int len = 0;
        ser[len] = new BigInt("1");
        while(remain.compare(div.mul(ser[len])) >= 0){
            ser[len+1] = ser[len].bigDouble();
            len++;
        }
        len--;
        while(remain.compare(div) >= 0){
            // BigInt ser = new BigInt("1");
            // BigInt pre = ser;
            // find biggest ser[len]
            while(remain.compare(div.mul(ser[len])) < 0){
                // pre = ser;
                // ser = ser.bigDouble();
                len--;
            }
            remain = remain.sub(div.mul(ser[len]));
            result = result.add(ser[len]);
        }
        return result;
    }

    public static void main(String[] argv){
        BigInt x = new BigInt("12345678901234567890");
        BigInt y = new BigInt("87");
        // System.out.println("x = " + x.toString() + " , " + "y = " + y.toString());
        // System.out.print("x + y = ");
        // System.out.println(x.add(y).toString());
        // System.out.print("x * y = ");
        // System.out.println(x.mul(y).toString());
        // System.out.print("x - y = ");
        // System.out.println(x.sub(y).toString());
        // System.out.print("x / y = ");
        // System.out.println(x.div(y).toString());
        // System.out.print("x % y = ");
        // System.out.println(x.mod(y).toString());
        // System.out.println(x.complement().toString());
        System.out.println(x.fastDiv(y).toString());
    }
}