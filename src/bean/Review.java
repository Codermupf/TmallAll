package bean;

import java.util.Date;

/**
 * Created by OovEver on 2017/9/19.
 * 1. 基本属性的getter、setter
 2. 与User的多对一关系
 3. 与Product 的多对一关系
 */
public class Review {
    private String  content;
    private Date    createDate;
    private User    user;
    private Product product;
    private int     id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}
