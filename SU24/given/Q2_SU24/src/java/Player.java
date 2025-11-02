/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class Player {
    private String code;
    private String name;
    private String pos;
    private String shirt_num;

    public Player() {
    }

    public Player(String code, String name, String pos, String shirt_num) {
        this.code = code;
        this.name = name;
        this.pos = pos;
        this.shirt_num = shirt_num;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getShirt_num() {
        return shirt_num;
    }

    public void setShirt_num(String shirt_num) {
        this.shirt_num = shirt_num;
    }
    
    
}
