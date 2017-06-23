public class TestTry{
    public static void myFun(){
        int[] data=new int[100];
        for(int i=1;i<=data.length;i++){
            data[i]=i;
        }
    }
    public static void main(String[] argv){
        try{
            myFun();
        }
        }catch(ArrayIndexOutOfBoundsException erl){
        System.out.println("陣列索引超過邊界錯誤");
        erl.printStackTrace();
        }catch(Exception err){
            System.out.println("出錯了");
        }
}