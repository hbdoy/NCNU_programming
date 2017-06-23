import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.*;
public class Stack{
    int top=0;
    BigDecimal[] data=new BigDecimal[100];
    public Stack(){
    }
    public void push(BigDecimal x){
        this.data[this.top++]=x;
    }
    public BigDecimal pop(){
        return this.data[--top];
    }
}
