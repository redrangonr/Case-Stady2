
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ManagerReceiptIn managerReceiptIn = new ManagerReceiptIn();
    static ManagerReceiptOut managerReceiptOut = new ManagerReceiptOut(managerReceiptIn);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int chon;
        if(showLogin()){
            do{
                showDisplay();
                chon = sc.nextInt();
                sc.nextLine();
                switch (chon) {
                    case 1: {
                        choiceReceiptIn();
                    }
                    case 2: {
                        choiceReceiptOut();
                    }
                    case 3: {
                        tinhLai();
                    } case 0:{
                        System.exit(0);
                    }
                }
            }while (chon!=0);

        }

    }
    public static void tinhLai(){

    }
public static void showDisplay(){
    System.out.println("Chọn đối tượng bạn muốn làm việc");
    System.out.println("_________________");
    System.out.println("|1 . Phiếu nhập |");
    System.out.println("|2 . Phiếu xuất |");
    System.out.println("|3 . Tính lãi   |");
    System.out.println("-----------------");
}

    public static void showReceiptOutInfo() {
        System.out.println("******************ReceiptOut*******************");
        System.out.println(" ----------------------------------------------");
        System.out.println("|1 .        Xuất 1 sản phẩm                   |");
        System.out.println("|2 .        Hiển thị danh sách sản phẩm       |");
        System.out.println("|3 .        Xóa 1 phiếu sản phẩm              |");
        System.out.println("|4 .        Thay đổi thông tin sản phẩm       |");
        System.out.println("|5 .        Sắp sếp theo giá trị sản phẩm     |");
        System.out.println("|6 .        Hiển thị sản phẩm có giá cao nhất |");
        System.out.println("|7.          Sắp xếp tên sản phẩm             |");
        System.out.println("|8 .        Lưu thông tin sản phẩm            |");
        System.out.println("|9 .        Đọc thông tin sản phẩm            |");
        System.out.println("|0 .        Thoát chương trình                |");
        System.out.println("L_____________________________________________/");

    }

    public static void showReceiptInInfo() {
        System.out.println("******************ReceiptIn*******************");
        System.out.println(" ----------------------------------------------");
        System.out.println("|1 .        Thêm sản phẩm mới                 |");
        System.out.println("|2 .        Hiển thị danh sách sản phẩm       |");
        System.out.println("|3 .        Xóa 1 phiếu sản phẩm              |");
        System.out.println("|4 .        Thay đổi thông tin sản phẩm       |");
        System.out.println("|5 .        Sắp sếp theo giá trị sản phẩm     |");
        System.out.println("|6 .        Hiển thị sản phẩm có giá cao nhất |");
        System.out.println("|7 .        Sắp xếp tên sản phẩm              |");
        System.out.println("|8 .        Lưu thông tin sản phẩm            |");
        System.out.println("|9 .        Đọc thông tin sản phẩm            |");
        System.out.println("|0 .        Thoát chương trình                |");
        System.out.println("L_____________________________________________/");
    }

    public static boolean showLogin() {
        boolean a = false;
        do {

            System.out.println("Nhập mât khẩu");
            String s1 = sc.nextLine();
            String s2 = new String("quocanh123");
            if (s1.equals(s2)) {
                System.out.println("Đăng nhập thành công");
                a = true;

            } else {
                System.err.println("Mật khẩu sai");

            }
        } while (a == false);
        return a;
    }
public static void choiceReceiptIn(){
    int choice;
    do{
        showReceiptInInfo();
        choice= sc.nextInt();

        switch (choice) {
            case 1: {
                managerReceiptIn.addReceipt_in();
                break;
            }
            case 2: {
                managerReceiptIn.showProduct();
                break;
            }
            case 3: {
                System.out.println("Nhập mã phiếu  sản phẩm cần xóa");
                sc.nextLine();
                int remove = sc.nextInt();
                managerReceiptIn.removeProduct(remove);
                break;
            }
            case 4: {
                System.out.println("Nhập mã phiếu sản phẩm cần sửa");
                sc.nextLine();
                int change = sc.nextInt();
                managerReceiptIn.changeProduct(change);
                break;
            }
            case 5: {
                managerReceiptIn.sortPrimeByBubbleSort();
                managerReceiptIn.showProduct();
                break;
            }
            case 6: {
                managerReceiptIn.showHightPrime();

                break;
            }
            case 7:{
                managerReceiptIn.sortName();
                managerReceiptIn.showProduct();
                break;
            }
            case 8: {

                managerReceiptIn.writeProductListToFile();
                break;

            }
            case 9: {

                managerReceiptIn.readProductListFromFile();
                break;
            }
            case 0: {
                System.out.println("Tạm biệt");
                System.exit(0);
            }

        }
    }while (choice !=0);
}
public static void choiceReceiptOut(){
    int choices;
    do{
        showReceiptOutInfo();
        choices= sc.nextInt();

        switch (choices) {
            case 1: {
                managerReceiptOut.addReceipt_out();
                break;
            }
            case 2: {
                managerReceiptOut.showProduct();
                break;
            }
            case 3: {
                System.out.println("Nhập mã phiếu sản phẩm cần xóa");
                sc.nextLine();
                int remove = sc.nextInt();
                managerReceiptOut.removeProduct(remove);
                break;
            }
            case 4: {
                System.out.println("Nhập phiếu sản phẩm cần sửa");
                sc.nextLine();
                int changes = sc.nextInt();
                managerReceiptOut.changeProduct(changes);
                break;
            }
            case 5: {
                managerReceiptOut.sortPrimeByBubbleSort();
                managerReceiptOut.showProduct();
                break;
            }
            case 6: {
                managerReceiptOut.showHightPrime();

                break;
            }
            case 7:{
                managerReceiptOut.sortName();
                managerReceiptOut.showProduct();
                break;
            }
            case 8: {

                managerReceiptOut.writeProductListToFile();
                break;

            }
            case 9: {

                managerReceiptOut.readProductListFromFile();
                break;
            }
            case 0: {
                System.out.println("Tạm biệt");
                System.exit(0);
            }

        }
    }while (choices !=0);
}
}

