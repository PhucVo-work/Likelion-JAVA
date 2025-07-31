package contactManager;

public interface Displayable {
    default void display() {
        System.out.println("Hien thi thong tin lien lac.");
    }
}
