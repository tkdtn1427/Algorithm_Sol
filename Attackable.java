public interface Attackable {
    public static final int test = 5;
    abstract void attack();

    default void testIs(){
        System.out.println("qweqwe");
    }
}
