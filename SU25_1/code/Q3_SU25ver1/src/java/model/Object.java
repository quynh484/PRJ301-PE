package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Object {
    private String comment;
    private String account;
    private Date date;
    
    public Object(String comment, String account, Date date) {
        this.comment = comment;
        this.account = account;
        this.date = date;
    }

    

//    public String getDob() {
//        return new SimpleDateFormat("yyyy-MM-dd").format(date);
//    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
