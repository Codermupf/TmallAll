package util;

import com.sun.org.apache.regexp.internal.RE;

import javax.tools.JavaCompiler;

/**
 * Created by OovEver on 2017/9/19.
 * DateUtil这个日期工具类主要是用于java.util.Date类与java.sql.Timestamp 类的互相转换。
 */
public class DateUtil {
    public static java.sql.Timestamp d2t(java.util.Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Timestamp(date.getTime());
    }
    public static java.util.Date t2d(java.sql.Timestamp t) {
        if (t == null) {
            return null;
        }
        return new java.util.Date(t.getTime());
    }
}
