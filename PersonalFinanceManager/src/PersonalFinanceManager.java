import java.util.Scanner;

public class PersonalFinanceManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double electricityCost = 0;
        double taxiCost = 0;
        double salary = 0;

        while (true) {
            System.out.println("\n===== Quan Ly chi tieu ca nhan =====");
            System.out.println("1. Tinh tien dien cuoi thang");
            System.out.println("2. Tinh tien taxi cuoi thang (di 1 lan moi thang):");
            System.out.println("3. Tinh tien luong cuoi thang (thue 15%)");
            System.out.println("4. Tinh tong thu nhap khi chi tieu cuoi thang");
            System.out.print("Moi ban chon chuc nang [1->4] hoac nhan phim khac de thoat: ");

            int choice;
            if (!scanner.hasNextInt()) {
                System.out.println("Phai nhap chu. Thoat chuong trinh.");
                break;
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhap so KwH dien da su dung trong thang: ");
                    double kwh = scanner.nextDouble();
                    electricityCost = kwh * 3000; 
                    System.out.println("Tien dien cuoi thang: " + electricityCost + " VNĐ");
                    break;

                case 2:
                    System.out.print("Nhap gia tien cho 1 lan di taxi: ");
                    double km = scanner.nextDouble();
                    taxiCost = km * 2000;
                    System.out.println("Tien taxi cuoi thang: " + taxiCost + " VNĐ");
                    break;

                case 3:
                    System.out.print("Nhap luong truoc thue: ");
                    double grossSalary = scanner.nextDouble();
                    salary = grossSalary * 0.85; 
                    System.out.println("Luong thuc nhan sau thue: " + salary + " VNĐ");
                    break;

                case 4:
                    double totalExpenses = electricityCost + taxiCost;
                    double netIncome = salary - totalExpenses;
                    System.out.println("Tong thu nhap sau khi chi tieu: " + netIncome + " VNĐ");
                    break;

                default:
                    System.out.println("Cam on ban da su duang chuong trinh!");
                    scanner.close();
                    return;
            }
        }

        System.out.println("Cam on ban da su dueng chuong trinh!");
        scanner.close();
    }
}
