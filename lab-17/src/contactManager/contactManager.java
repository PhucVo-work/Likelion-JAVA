package contactManager;

import java.util.*;

public class contactManager {
    private static Scanner scanner = new Scanner(System.in);
    private static List<contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> displayContacts(); 
                case "2" -> searchContactByPhone();
                case "3" -> addContact();
                case "4" -> editContact();
                case "5" -> deleteContact();
                default -> {
                    System.out.println("Cam on ban da su dung chuong trinh!");
                    return;
                }
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n===== QUAN LY DANH BA =====");
        System.out.println("1. Hien thi danh sach lien lac");
        System.out.println("2. Tim kiem lien lac theo SDT");
        System.out.println("3. Them moi lien lac");
        System.out.println("4. Sua thong tin lien lac");
        System.out.println("5. Xoa thong tin lien lac");
        System.out.print("=> Moi ban chon chuc nang [1->5] hoac nhan phim khac de thoat: ");
    }

    private static void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Danh sach lien lac trong.");
        } else {
            System.out.println("Danh sach lien lac:");
            contacts.forEach(contact::display); 
        }
    }

    private static void searchContactByPhone() {
        System.out.print("Nhap SDT: ");
        String phone = scanner.nextLine();

      
        Optional<contact> found = contacts.stream()
                .filter(c -> contact.hasPhone(c, phone))
                .findFirst();

        found.ifPresentOrElse(
                contact::display,
                () -> System.out.println("Khong tim thay lien lac."));
    }

    private static void addContact() {
        System.out.print("Nhap ID: ");
        String id = scanner.nextLine();
        System.out.print("Nhap ten: ");
        String name = scanner.nextLine();
        System.out.print("Nhap SDT: ");
        String phone = scanner.nextLine();
        System.out.print("Nhap email: ");
        String email = scanner.nextLine();
        System.out.print("Nhap dia chi: ");
        String address = scanner.nextLine();

        contacts.add(new contact(id, name, phone, email, address));
        System.out.println("Da them lien lac moi.");
    }

    private static void editContact() {
        System.out.print("Nhap ID lien lac can sua: ");
        String id = scanner.nextLine();

        Optional<contact> contactOpt = contacts.stream()
                .filter(c -> c.getId().equalsIgnoreCase(id))
                .findFirst();

        contactOpt.ifPresentOrElse(c -> {
            System.out.println("Thong tin lien lac muon sua:");
            c.display();

            System.out.print("Ten moi (Enter de giu nguyen): ");
            String newName = scanner.nextLine();
            if (!newName.trim().isEmpty())
                c.setName(newName);

            System.out.print("SDT moi (Enter de giu nguyen): ");
            String newPhone = scanner.nextLine();
            if (!newPhone.trim().isEmpty())
                c.setPhone(newPhone);

            System.out.print("Email moi (Enter de giu nguyen): ");
            String newEmail = scanner.nextLine();
            if (!newEmail.trim().isEmpty())
                c.setEmail(newEmail);

            System.out.print("Dia chi moi (Enter de giu nguyen): ");
            String newAddress = scanner.nextLine();
            if (!newAddress.trim().isEmpty())
                c.setAddress(newAddress);

            System.out.println("Da cap nhat lien lac.");
        }, () -> System.out.println("Khong tim thay lien lac."));
    }

    private static void deleteContact() {
        System.out.print("Nhap ID lien lac can xoa: ");
        String id = scanner.nextLine();

        boolean removed = contacts.removeIf(c -> c.getId().equalsIgnoreCase(id));

        if (removed)
            System.out.println("Da xoa lien lac.");
        else
            System.out.println("Khong tim thay lien lac.");
    }
}
