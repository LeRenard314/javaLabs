// I didn't write the majority of this code, it was given. Ik it's shit
public class Bike implements Cloneable {
    Wheel w;
    
    Bike (int wCount, int wDiameter) {
        w = new Wheel(wDiameter, wCount);
    }

    @Override
    public String toString() {
        return "The amount of wheels: " + w.wheelCount + "\nThe diameter of wheels: " + w.d;
    }

    public static void main (String[] arg) throws CloneNotSupportedException {
        Bike bike1 = new Bike(2, 26);
        Bike bike2 = (Bike) bike1.clone();
        System.out.format("=Bike1=\n%s\nHash: %d\n", bike1.toString(), bike1.hashCode());
        System.out.format("=Bike2=\n%s\nHash: %d\n", bike2.toString(), bike2.hashCode());
        System.out.println(bike1.equals(bike2));
    }
}

class Wheel {
    int d;
    int wheelCount;

    Wheel (int di, int wheelCount){
        this.d = di;
        this.wheelCount = wheelCount;
    }
}