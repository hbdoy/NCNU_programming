public class People{
    //�����ݩ�
    String name;
    int id;
    int money = 0;
    /*static���ܼ�(���)�b��class���u�|���@��,
    �i�z�Ѭ������,���O�@�ӷ���,���ݭn�z�L����Ӿާ@*/
    static int allmoney;
    //�غc�l
    public People(int id, String name){
        this.id = id;
        this.name = name;
    }
    //���󪺤�k
    public void sayYourName(){
        System.out.println(this.name);
    }
    public void getMoney(int x){
        this.money = this.money + x;
    }

    public static void main(String[] argv){
        People ref = new People(26,"Ryan");
        allmoney = allmoney+100;
        ref.money = ref.money+100;

        ref = new People(11,"Amy");
        allmoney = allmoney+100;
        ref.money = ref.money+100;

        ref = new People(30,"John");
        allmoney = allmoney+100;
        ref.money = ref.money+100;

        ref.sayYourName();
        // ref.getMoney(999);
        //allmoney�O�@��static�ܼ�
        System.out.println(allmoney); //300
        System.out.println(ref.money); //100
    }
}