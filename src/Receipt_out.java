import java.io.Serializable;

public class Receipt_out implements Serializable {
    private String date;
    private Product product;
    private Employee employee;
    private int prime ;
    private int numberOfProduct;
    private int id ;

    public Receipt_out( Product product, Employee employee, int prime, int numberOfProduct, int id,String date) {
        this.date = date;
        this.product = product;
        this.employee = employee;
        this.prime = prime;
        this.numberOfProduct = numberOfProduct;
        this.id = id;
    }
    public Receipt_out(){

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

    public int getNumberOfProduct() {
        return numberOfProduct;
    }

    public void setNumberOfProduct(int numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "  "+
                "ngày suất = '" + date + '\'' +
                ", tên sản phẩm suất = " + product +
                ", người suất  = " + employee +
                ", giá  = " + prime +"$"+
                ", số  sản phẩm suất" + numberOfProduct +
                ",  mã phiếu =" + id +
                 "  ";
    }
}
