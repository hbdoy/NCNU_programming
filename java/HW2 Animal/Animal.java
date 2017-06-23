/*
* ID: 104213046
* Author: ������
*/
public class Animal{
    String name;
    String sex;
    int level;
    // �غc�l
    public Animal(String name, String sex, int level){
        // ���ئW�١B�ʧO�B�}���{��
        this.name = name;
        this.sex = sex;
        this.level = level;
    }
    // call���ئW�١B�ʧO�B�}���{�סB�O�|�ŧOmethod
    public void showDetail(){
        showName();
        showSex();
        showLevel();
        needHelp();
    }
    // �L�X���ئW��
    public void showName(){
        System.out.print(this.name+" ");
    }
    // �L�X���ةʧO
    public void showSex(){
        System.out.print(this.sex+" ");
    }
    // �L�X���ص}���{��
    public void showLevel(){
        System.out.print(this.level+" ");
    }
    // �L�X���ثO�|�ŧO
    public void needHelp(){
        //�̷ӵ}�����ƦL�X�������p
        if(this.level>100){
            System.out.println("�x�{����QQ");
        }else if(100>=this.level && this.level>=10){
            System.out.println("�O�|��");
        }else if(10>this.level){
            System.out.println("�٦��ܦh");
        }
    }

    public static void main(String[] argv){
        // new�T��Animal����,�ýᤩ���
        Animal Nancy = new Animal("Nancy","female",5);
        Animal Grorge = new Animal("Grorge","male",50);
        Animal Sam = new Animal("Sam","male",101);
        Nancy.showDetail();
        Grorge.showDetail();
        Sam.showDetail();
    }
}