package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Object {
    private String id;
    private String str;
    private String opt;
    private String re;

    public Object() {
    }

    public Object(String id, String str, String opt, String re) {
        this.id = id;
        this.str = str;
        this.opt = opt;
        this.re = re;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public String getRe() {
        return re;
    }

    public void setRe(String re) {
        this.re = re;
    }
    
    
    
}
