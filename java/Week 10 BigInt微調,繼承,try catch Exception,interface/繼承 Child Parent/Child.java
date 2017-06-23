// 1. 設定內定值(含所有父子類別)
// 2. call Constructor
//    2.1 call parent's constructor
//        2.2.1 excute init in parent's declaration
//        2.2.2 call grand parent's constructor
//            ..........
//        2.2.3 excute parent's constructor
//    2.2 excute init in declaration
//    2.3 excute constructor
class Parent{
    int pmoney = 10;
    public Parent(){
    }
    public Parent(int born){
        pmoney = born;
    }
}

// (1) money = 0, pmoney = 0  // set by jvm
// (2) money = 0, pmoney = 10 // parent's declaration
// (3) money = 0, pmoney = 200 // parent's constructor
// (4) money = 100, pmoney = 200 // child declaration init
// (5) money = 400, pmoney = 200 // child's constructor
public class Child extends Parent{
    int money = pmoney / 2;
    public Child(int m){
        // 預設會先call super(),空的constructor;
        super(2 * m);
        // excute declaration init
        // excute constructor body
        money = pmoney * 2;
    }
    public static void main(String[] argv){
        Child c = new Child(100);
        System.out.println(c.pmoney);
        System.out.println(c.money);
    }
}