import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import java.time.LocalDate;
import java.util.Scanner;

public class TestMainMaterial {
    static Scanner sc = new Scanner(System.in);
    static ManagerMaterial managerMaterial = new ManagerMaterial();
    static final String REGEX = "^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}$";

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. nhập nguyên liệu");
            System.out.println("2. hiện thị danh sách nguyên liệu");
            System.out.println("3. sắp sếp theo giá nguyên liệu tăng dần");
            System.out.println("4. hiện thị nguyên liệu có giá lớn nhất và nhỏ nhất");
            System.out.println("5. xóa nguyên liệu đã hết hạn khỏi danh sách");
            System.out.println("6. ghi file");
            System.out.println("7. đọc file");
            System.out.println("0. thoát chương trình");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập số lượng vật liệu muốn thêm");
                    int number = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < number; i++) {
                        addNew();
                    }
                    break;
                case 2:
                    managerMaterial.displayAll();
                    break;
                case 3:
                    managerMaterial.sortByPriceOfMaterial();
                    break;
                case 4:
                    managerMaterial.testPriceMaxAndMinOfMaterial();
                    break;
                case 5:
                    managerMaterial.removeExpiredMaterial();
                    break;
                case 6:
                    managerMaterial.writeFile();
                    break;
                case 7:
                    managerMaterial.readFile();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }

        } while (choice != 0);

    }

    public static void addNew() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Nhập id nguyên liệu");
        String id = sc1.nextLine();
        System.out.println("Nhập tên");
        String name = sc.nextLine();
        String dateManufacture;
        LocalDate dateOfManufacture = null;
        do {
            System.out.println("Nhập ngày sản xuất kiểu dd/mm/yyyy");
            dateManufacture = sc.nextLine();
            try {
                dateOfManufacture = LocalDate.parse(dateManufacture);
            }catch (Exception e){}
        }while (!dateManufacture.matches(REGEX));
        System.out.println("nhập giá nguyên liệu");
        int price = Integer.parseInt(sc.nextLine());
        System.out.println("nhập kiểu nguyên liệu cần in ra");
        String material = sc1.nextLine();
        if (material.equalsIgnoreCase("C1")) {
            System.out.println("nhập khối lượng bột bì");
            double quantity = Double.parseDouble(sc1.nextLine());
            CrispyFlour crispyFlour = new CrispyFlour(id, name, dateOfManufacture, price, quantity);
            managerMaterial.inputMaterial(crispyFlour);
        } else if (material.equalsIgnoreCase("M1")) {
            System.out.println("nhập khối lượng thịt");
            double weight = Double.parseDouble(sc.nextLine());
            Meat meat = new Meat(id, name, dateOfManufacture, price, weight);
            managerMaterial.inputMaterial(meat);
        }
        System.out.println("________________________________________________");

    }
}