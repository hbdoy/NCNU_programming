/*
* ID: 104213046
* Author: 李禹叡
*/
public class Animal{
    String name;
    String sex;
    int level;
    // 建構子
    public Animal(String name, String sex, int level){
        // 物種名稱、性別、稀有程度
        this.name = name;
        this.sex = sex;
        this.level = level;
    }
    // call物種名稱、性別、稀有程度、保育級別method
    public void showDetail(){
        showName();
        showSex();
        showLevel();
        needHelp();
    }
    // 印出物種名稱
    public void showName(){
        System.out.print(this.name+" ");
    }
    // 印出物種性別
    public void showSex(){
        System.out.print(this.sex+" ");
    }
    // 印出物種稀有程度
    public void showLevel(){
        System.out.print(this.level+" ");
    }
    // 印出物種保育級別
    public void needHelp(){
        //依照稀有指數印出種類情況
        if(this.level>100){
            System.out.println("瀕臨絕種QQ");
        }else if(100>=this.level && this.level>=10){
            System.out.println("保育類");
        }else if(10>this.level){
            System.out.println("還有很多");
        }
    }

    public static void main(String[] argv){
        // new三個Animal物件,並賦予初值
        Animal Nancy = new Animal("Nancy","female",5);
        Animal Grorge = new Animal("Grorge","male",50);
        Animal Sam = new Animal("Sam","male",101);
        Nancy.showDetail();
        Grorge.showDetail();
        Sam.showDetail();
    }
}