import java.io.Serializable;

public class Receipt_in implements Serializable {
    private String date;
    private Product product;
    private Employee employee;
    private int prime;
    private int numOfProduct;
    private int id;

    public Receipt_in(Product product, Employee employee, int prime, int numOfProduct, int id,String date) {
        this.product = product;
        this.employee = employee;
        this.prime = prime;
        this.numOfProduct = numOfProduct;
        this.id = id;
        this. date =date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getPrime() {
        return prime;
    }

    public void setPrime(int prime) {
        this.prime = prime;
    }

    public int getNumOfProduct() {
        return numOfProduct;
    }

    public void setNumOfProduct(int numOfProduct) {
        this.numOfProduct = numOfProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "  " +
                " ngày nhập = " + date  + product
                 + employee +
                ", giá nhập = " + prime +"$"+
                ", số lượng nhập = " + numOfProduct +
                ", mã phiếu nhập = " + id +
                "  ";
    }
}

