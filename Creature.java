public abstract class Creature {
    private String name;
    private int age;

    public Creature(String name, int age){
        this.name = name;
        this.age = age;
    }

    public abstract void shout();
}
