import java.io.*;
import java.util.*;

public class ManagerReceiptOut {
    List<Receipt_out> outList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    ManagerReceiptIn managerReceiptIn = new ManagerReceiptIn();
    private String name;
    private static int id = 233;
    private String ten;
    private String date;
    private static int ma = 503;
    private int prime;
    private int num;
    private static int code = 403;
    private String ngay;

    public ManagerReceiptOut() {
        Employee employee1 = new Employee("Nguyễn Văn A", 230);
        Employee employee2 = new Employee("Nguyễn Văn B", 231);
        Employee employee3 = new Employee("Nguyễn Văn C", 232);

        Product product1 = new Product("dầu gội", "17/3/2021", 500);
        Product product2 = new Product("rượu", "8/9/2023", 501);
        Product product3 = new Product("sữa", "9/2/2022", 502);

        outList.add(new Receipt_out(product1, employee1, 5, 7, 400, "27/6/2021"));
        outList.add(new Receipt_out(product2, employee2, 63, 22, 401, "30/5/2021"));
        outList.add(new Receipt_out(product3, employee3, 18, 72, 402, "4/6/2021"));
    }

    public void showProduct() {
        for (Receipt_out receiptList : outList) {
            System.out.println(receiptList);
        }
        scanner.nextLine();
    }

    public void sortName() {
        Collections.sort(outList, new Comparator<Receipt_out>() {
            @Override
            public int compare(Receipt_out o1, Receipt_out o2) {
                return -o2.getProduct().getName().compareTo(o1.getProduct().getName());
            }
        });
    }

    public void addEmployee() {
        System.out.println("Tên nhân viên");
        name = scanner.nextLine();
        System.out.println("Nhập id");
        id = scanner.nextInt();
    }

    public void addProduct() {
        System.out.println("Tên sản phẩm ");
        ten = scanner.nextLine();
        System.out.println(" Hạn sử dụng");
        date = scanner.nextLine();
        ma=++ma;
    }

    public void getInfoReceipt_out() {
        code = ++code;
        addEmployee();
        scanner.nextLine();
        addProduct();
        System.out.println("Nhập giá 1 sản phẩm ");
        prime = scanner.nextInt();
        System.out.println(" Số lượng sản phẩm ");
        num = scanner.nextInt();
        System.out.println("Ngày suất hàng");
        scanner.nextLine();
        ngay = scanner.nextLine();

    }

    public Receipt_out addReceipt_out() {

        getInfoReceipt_out();
        Receipt_out receipt_out= null;
        if (managerReceiptIn.checkProduct(name)){
            Employee employee = new Employee(name, id);
            Product product = new Product(ten, date, ma);
            receipt_out = new Receipt_out(product, employee, prime, num, code, ngay);
            outList.add(receipt_out);
        }else {
            System.out.println("Ko có sản phẩm trong kho");
        }

      return receipt_out;
    }
    public void changeProduct(int input) {
        int index = findProductByName(input);
        if (index != -1) {
            outList.set(index, addReceipt_out());
            System.out.println("Danh sách sau khi sửa");
            showProduct();
        }
    }

    public void sortPrimeByBubbleSort() {
        for (int i = 0; i < outList.size(); i++) {
            for (int j = outList.size() - 1; j < i; i++) {
                Receipt_out firstReceipt = outList.get(j);
                Receipt_out secondReceipt = outList.get(j - 1);
                if (firstReceipt.getPrime() < secondReceipt.getPrime()) {
                    Receipt_out temp = firstReceipt;
                    firstReceipt = secondReceipt;
                    secondReceipt = temp;
                    this.outList.set(j, firstReceipt);
                    this.outList.set(j - 1, secondReceipt);

                }

            }
        }
    }

    public void showHightPrime() {
        sortPrimeByBubbleSort();
        outList.get(0);
        System.out.println(outList.get(0));
    }

    public int findProductByName(int input) {
        int index = -1;
        for (int i = 0; i < outList.size(); i++) {
            if (outList.get(i).getId()==(input)) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("ko tìm thấy tên sản phẩm");
        }
        return index;

    }


    public void removeProduct(int input) {
        int index = findProductByName(input);
        if (index != -1) {
            outList.removeIf(receipt -> receipt.getId()==(input));
        }
    }



    public void writeProductListToFile() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("out.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(outList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void readProductListFromFile() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("out");
            ois = new ObjectInputStream(fis);
            outList = (List<Receipt_out>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

