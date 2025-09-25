public class Bike implements Cloneable {
    String brand, model;
    Wheel wheel; 
    double price;
    
    Bike() {
        this.wheel = new Wheel(0, 0);
        this.brand = "";
        this.model = "";
        this.price = 0;
    }

    // Variable naming shitty here, I just have no ideas
    Bike (String bBrand, String bModel, int wCount, int wDiameter, double bPrice) {
        this.brand = bBrand;
        this.model = bModel;
        this.wheel = new Wheel(wDiameter, wCount);
        this.price = bPrice;
    }
    
    @Override
    public String toString() {
        return "Brand: " + this.brand + " Model: " + this.model + " Wheels: " + wheel.wheelCount + " Wheel diameter: " + wheel.diameter + " Price: " + this.price;
    }

}

class Wheel {
    int diameter;
    int wheelCount;

    Wheel (int diameter, int wheelCount){
        this.diameter = diameter;
        this.wheelCount = wheelCount;
    }

}