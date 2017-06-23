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
        // 40 - 30糶Θ 40 + 70 - 100,碞琌40干计搭100
        // 干计―猭 99 - 30 + 1 = 70,99–常琌程计,ぃ惠璶矪瞶拜肈
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
        // 猭琌ノ猭ㄓ: 5 * 3 : 5 + 5 + 5
        // 埃猭琌ノ搭猭ㄓ: 10 / 3 : 10 - 3 - 3 - 3
        // 10 / 3 : 10搭3 搭跑Θ璽计玡磅︽Ω计
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

    public static void main(String[] argv){
        BigInt x = new BigInt("145");
        BigInt y = new BigInt("12");
        System.out.println("x = " + x.toString() + " , " + "y = " + y.toString());
        System.out.print("x + y = ");
        System.out.println(x.add(y).toString());
        System.out.print("x * y = ");
        System.out.println(x.mul(y).toString());
        System.out.print("x - y = ");
        System.out.println(x.sub(y).toString());
        System.out.print("x / y = ");
        System.out.println(x.div(y).toString());
        System.out.print("x % y = ");
        System.out.println(x.mod(y).toString());
        System.out.println(x.complement().toString());
    }
}