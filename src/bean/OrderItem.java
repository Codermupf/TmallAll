package bean;

/**
 * Created by OovEver on 2017/9/19.
 * 1. 基本属性的getter、setter
 2. 与Product的多对于关系
 3. 与User的多对一关系
 4. 与Order的多对一关系
 */
public class OrderItem {
    public int getNumber() {
        return number;
    }
    private int     number;
    private Product product;
    private Order   order;
    private User    user;
    private int     id;
    public void setNumber(int number) {
        this.number = number;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
