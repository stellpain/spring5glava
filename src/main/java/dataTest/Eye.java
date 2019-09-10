package dataTest;

public class Eye {
    public static void main(String[] args) {
        try {
            System.out.println("Driver loading success! " + Class.forName("org.postgresql.Driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
