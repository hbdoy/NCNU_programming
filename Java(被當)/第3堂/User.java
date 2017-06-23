public class User{
    public static void main(String[] argv){
        TV myTV=new TV();
        myTV.increaseChannel();
        myTV.decreaseChannel();
        myTV.setChannel(60);
        myTV=new LEDTV(); //its ok
        //父類別型態的reference可以指到子類別物件
        //所以這種reference可以指向多種子類別
        //這稱為polymorphism
        myTV.increaseChannel(); //which increaseChannel?
        //if in line ll,LEDTV.increaseChannel will be called
        //which means determined by actual object type
        //then we call it "virtual function"
        //if TV.increaseChannel() wll be called
        //which means determined by reference type
        //then we call it "non virtual function"
        myTV=new OLEDTV(); //OK
        LEDTV yuerlee=new TVO(); //errorr
    } 
}
