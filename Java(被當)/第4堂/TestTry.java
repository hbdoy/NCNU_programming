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
        System.out.println("�}�C���޶W�L��ɿ��~");
        erl.printStackTrace();
        }catch(Exception err){
            System.out.println("�X���F");
        }
}