public class Human extends Creature implements Attackable{
    private int key;

    public Human(String name, int age, int key){
        super(name,age);
        this.key = key;
    }


    @Override
    public void shout() {
        System.out.println("이것이 키다");
    }

    @Override
    public void attack() {
        System.out.println("공격이당");
    }

    @Override
    public void testIs(){
        System.out.println("이것은 바뀐것이다");
    }
}
