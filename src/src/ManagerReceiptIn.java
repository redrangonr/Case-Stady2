import java.io.*;
import java.util.*;

public class ManagerReceiptIn {
    List<Receipt_in> inList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    private String name;
    private static int id = 102;
    private String ten;
    private String date;
    private static int ma = 202;
    private int prime;
    private int num;
    private static int code = 302;
    private String ngay;


    public ManagerReceiptIn() {
        Employee employee1 = new Employee("Nguyễn Văn A", 100);
        Employee employee2 = new Employee("Nguyễn Văn B", 101);
        Employee employee3 = new Employee("Nguyễn Văn C", 102);

        Product product1 = new Product("dầu gội", "17/3/2021", 200);
        Product product2 = new Product("rượu", "8/9/2023", 201);
        Product product3 = new Product("sữa", "9/2/2022", 202);

        inList.add(new Receipt_in(product1, employee1, 3, 10, 300, "12/28/2020"));
        inList.add(new Receipt_in(product2, employee2, 60, 50, 301, "9/30/2020"));
        inList.add(new Receipt_in(product3, employee3, 15, 230, 302, "11/20/2020"));
    }

    public void showProduct() {
        for (Receipt_in receiptList : inList) {
            System.out.println(receiptList);

        }
        scanner.nextLine();
    }

    //sắp xếp theo tên
    public void sortName() {
        Collections.sort(inList, new Comparator<Receipt_in>() {
            @Override
            public int compare(Receipt_in o1, Receipt_in o2) {
                return -o2.getProduct().getName().compareTo(o1.getProduct().getName());
            }
        });
    }

    public void addEmployee() {
        System.out.println("nhập tên nhân viên");
        name = scanner.nextLine();

        id = ++id;
    }
// check sản phẩm trong kho
    public boolean checkProduct(String input) {
        boolean a = false;
        for (Receipt_in receiptIn : inList) {
            if (receiptIn.getProduct().getName().equals(input)) {
                a = true;
            }
        }
        return a;
    }

    public void addProduct() {
        System.out.println("nhập tên sản phẩm ");
        ten = scanner.nextLine();
        System.out.println("Nhập hạn sử dụng");
        date = scanner.nextLine();

        ma = ++ma;
    }

    // thêm sản phẩm
    public Receipt_in addReceipt_in() {
        code = ++code;
        addEmployee();
        addProduct();
        System.out.println(" Giá 1 sản phẩm ");
        prime = scanner.nextInt();
        System.out.println(" Số lượng sản phẩm ");
        num = scanner.nextInt();
        System.out.println("Ngày nhập hàng");
        scanner.nextLine();
        ngay = scanner.nextLine();
        Employee employee = new Employee(name, id);
        Product product = new Product(ten, date, ma);
        Receipt_in receipt_in = new Receipt_in(product, employee, prime, num, code, ngay);
        inList.add(receipt_in);
        return receipt_in;
    }

    // Sắp xếp theo giá
    public void sortPrimeByBubbleSort() {
        for (int i = 0; i < inList.size(); i++) {
            for (int j = inList.size() - 1; j > i; j--) {
                Receipt_in firstReceipt = inList.get(j);
                Receipt_in secondReceipt = inList.get(j - 1);
                if (firstReceipt.getPrime() > secondReceipt.getPrime()) {
                    Receipt_in temp = firstReceipt;
                    firstReceipt = secondReceipt;
                    secondReceipt = temp;
                    inList.set(j, firstReceipt);
                    inList.set(j - 1, secondReceipt);

                }

            }
        }
    }

    // Hiển thị sản phẩm có giá cao nhất
    public void showHightPrime() {
        sortPrimeByBubbleSort();
        System.out.println(inList.get(0));
    }

    public int findProductByName(int input) {
        int index = -1;
        for (int i = 0; i < inList.size(); i++) {
            if (inList.get(i).getId() == (input)) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("ko tìm thấy tên sản phẩm");
        }
        return index;

    }

    // xóa sản phẩm theo id
    public void removeProduct(int input) {
        int index = findProductByName(input);
        if (index != -1) {
            inList.remove(index);
            System.out.println("Danh sách sau khi xóa");
            showProduct();
        }
    }

    //Thay đổi thông tin sản phẩm theo id
    public void changeProduct(int input) {
        int index = findProductByName(input);
        if (index != -1) {
            inList.set(index, addReceipt_in());
            System.out.println("Danh sách sau khi sửa");
            showProduct();
        }
    }

    public void writeProductListToFile() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("in.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(inList);
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
            fis = new FileInputStream("in");
            ois = new ObjectInputStream(fis);
            inList = (List<Receipt_in>) ois.readObject();
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

