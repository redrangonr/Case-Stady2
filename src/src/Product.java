import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private String expiryDate;
    private int id;

    public Product(String name, String expiryDate, int id) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.id = id;
    }
    public Product(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
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
                "tên sản phẩm ='" + name + '\'' +
                ", Hạn sử dụng =" + expiryDate + '\'' +
                ", Ma san pham = " + id +
                "  ";
    }
}
