public class TestAnimal{
    public static void pushAllAnimal(Animal[] list){
        for(int i=0; i<list.length; i++){
            list[i].move();
        }
    }
    public static void main(String[] argv){
        // Animal a = new Animal();
        // reference of parent's type can point to sub class object
        // polymorphism(¦h«¬)
        // Animal b = new Dog();
        // if the method actually called is determined by
        // (1) reference type: non - virtual function
        // (2) object type: virtual function; by java
        // a.move();
        // b.move();
        // b = new FlyDog();
        // b.move();
        Animal[] l = new Animal[]{new FlyDog(),new Dog(),new Animal(),new OldFish(),new OldFish()};
        pushAllAnimal(l);
    }
}