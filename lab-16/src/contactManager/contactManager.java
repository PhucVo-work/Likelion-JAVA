package contactManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class contactManager {
    private static Scanner scanner = new Scanner(System.in);
    private static List<contact> contacts = new ArrayList<>();
    
    public static void main(String[] args) {
        while (true) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    displayContacts();
                    break;
                case "2":
                    searchContactByPhone();
                    break;
                case "3":
                    addContact();
                    break;
                case "4":
                    editContact();
                    break;
                case "5":
                    deleteContact();
                    break;
                default:
                    System.out.println("Cam on ban da su dung chuong trinh!");
                    return;
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
            for (contact c : contacts) {
                c.display();
            }
        }
    }

    private static void searchContactByPhone() {
        System.out.print("Nhap so dien thoai lien lac can tim: ");
        String phoneNumber = scanner.nextLine();
        for (contact c : contacts) {
            if (c.getPhone().equalsIgnoreCase(phoneNumber)) {
                System.out.println("Thong tin lien lac:");
                c.display();
                return;
            }
        }
        System.out.println("\nKhong tim thay lien lac voi SDT da nhap.");
    }

    private static void addContact() {
        System.out.print("Nhap ID: ");
        String id = scanner.nextLine();
        System.out.print("Nhap ten: ");
        String name = scanner.nextLine();
        System.out.print("Nhap so dien thoai: ");
        String phone = scanner.nextLine();
        System.out.print("Nhap email: ");
        String email = scanner.nextLine();
        System.out.print("Nhap dia chi: ");
        String address = scanner.nextLine();

        contact newContact = new contact(id, name, phone, email, address);
        contacts.add(newContact);
        System.out.println("Da them lien lac moi.");
    }

    private static void editContact() {
        System.out.print("Nhap ID lien lac can sua: ");
        String id = scanner.nextLine();
        for (contact c : contacts) {
            if (c.getId().equalsIgnoreCase(id)) {
                System.out.println("thong tin lien lac muon sua: ");
                c.display();

                System.out.print("Ten moi (Enter de giu nguyen): ");
                String newName = scanner.nextLine();
                if (!newName.trim().isEmpty()) {
                    c.setName(newName);
                }

                System.out.print("So dien thoai moi (Enter de giu nguyen): ");
                String newPhone = scanner.nextLine();
                if (!newPhone.trim().isEmpty()) {
                    c.setPhone(newPhone);
                }

                System.out.print("Email moi (Enter de giu nguyen): ");
                String newEmail = scanner.nextLine();
                if (!newEmail.trim().isEmpty()) {
                    c.setEmail(newEmail);
                }

                System.out.print("Dia chi moi (Enter de giu nguyen): ");
                String newAddress = scanner.nextLine();
                if (!newAddress.trim().isEmpty()) {
                    c.setAddress(newAddress);
                }

                System.out.println("Da cap nhat lien lac.");
                return;
            }
        }
        System.out.println("Khong tim thay lien lac de sua.");
    }

    private static void deleteContact() {
        System.out.print("Nhap ID lien lac can xoa: ");
        String id = scanner.nextLine();
        for (contact c : contacts) {
            if (c.getId().equalsIgnoreCase(id)) {
                contacts.remove(c);
                System.out.println("Da xoa lien lac.");
                return;
            }
        }
        System.out.println("Khong tim thay lien lac de xoa.");
    }
}