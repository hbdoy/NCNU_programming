interface Y{
    int age = 100;
    public int live();
}
interface Z extends X, Y{
    int age = 0;
}
public class TestInterface implements X, Y{
    public int live(){
        return 2356;
    }
    public static void main(String[] argv){
        TestInterface x = new TestInterface();
        System.out.println(x.live());
        System.out.println(X.age);
        System.out.println(Y.age);
    }
}