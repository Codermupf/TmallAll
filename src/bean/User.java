package bean;

/**
 * Created by OovEver on 2017/9/19.
 * User类主要就是提供id, name ,password的getter和setter.
 其中getAnonymousName表示获取本用户的匿名名称，在评价的时候显示用户名使用。
 */
public class User {
    private String password;
    private String name;
    private int id;
    public void setId(int id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAnonymousName() {
        if (null == name) {
            return null;
        }
        if (name.length() <= 1) {
            return "*";
        }
        char[] cs = name.toCharArray();
        for (int i = 1; i < cs.length-1; i++) {
            cs[i]='*';
        }
        return new String(cs);
    }
}
