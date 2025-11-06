/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class BMI {
    private int height;
    private int weight;
    private String bmi;
    private String conclude;

    public BMI() {
    }

    public BMI(int height, int weight, String bmi, String conclude) {
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.conclude = conclude;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getConclude() {
        return conclude;
    }

    public void setConclude(String conclude) {
        this.conclude = conclude;
    }

    @Override
    public String toString() {
        return "BMI{" + "height=" + height + ", weight=" + weight + ", bmi=" + bmi + ", conclude=" + conclude + '}';
    }
    
   
}
