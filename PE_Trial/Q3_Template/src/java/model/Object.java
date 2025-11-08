package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Object {
    private String code;
    private String name;
    private Date dob;
    private String gender;
    private String address;

    public Object(String code, String name, Date dob, String gender, String address) {
        this.code = code;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getAddress() { return address; }
    public Date getDob() { return dob; }

//    public String getDob() {
//        return new SimpleDateFormat("yyyy-MM-dd").format(dob);
//    }
}
