package model;


public class BikeModel {

    private String code;
    private int speed;
    private String brand;
    private String brake;
    private String design;
    private String size;
    private String type;
    
    public BikeModel() {
    
    }

    public String getCode() {
        return code;
    }

    public int getSpeed() {
        return speed;
    }

    public String getBrand() {
        return brand;
    }

    public String getBrake() {
        return brake;
    }

    public String getDesign() {
        return design;
    }

    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSpeed(String speed) {
        this.speed = Integer.parseInt(speed);
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setBrake(String brake) {
        this.brake = brake;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
