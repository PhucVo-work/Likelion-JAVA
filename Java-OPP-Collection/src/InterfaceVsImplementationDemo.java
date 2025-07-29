import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InterfaceVsImplementationDemo {

    public static void main(String[] args) {
        // Cách tốt: Dùng interface List
        System.out.println("== Demo với List (tốt) ==");
        List<String> goodList = new ArrayList<>();
        goodList.add("Alice");
        goodList.add("Bob");
        printList(goodList); // dùng được với mọi loại List

        // Đổi sang LinkedList mà không phải sửa hàm printList
        goodList = new LinkedList<>();
        goodList.add("Charlie");
        goodList.add("David");
        printList(goodList);

        // Cách không tốt: Dùng cụ thể ArrayList
        System.out.println("\n== Demo với ArrayList (xấu) ==");
        ArrayList<String> badList = new ArrayList<>();
        badList.add("Eve");
        badList.add("Frank");
        printArrayList(badList); // chỉ dùng được với ArrayList

        // ❌ Nếu bạn đổi sang LinkedList, đoạn sau sẽ báo lỗi biên dịch
        // LinkedList<String> badList2 = new LinkedList<>();
        // badList2.add("Grace");
        // badList2.add("Heidi");
        // printArrayList(badList2); // ❌ LỖI: không truyền LinkedList vào hàm này được
    }

    // ✅ Cách tốt: truyền vào interface
    public static void printList(List<String> list) {
        System.out.println("Danh sách (List):");
        for (String item : list) {
            System.out.println("- " + item);
        }
    }

    // ❌ Cách không tốt: truyền vào cụ thể ArrayList
    public static void printArrayList(ArrayList<String> list) {
        System.out.println("Danh sách (ArrayList):");
        for (String item : list) {
            System.out.println("- " + item);
        }
    }
}
