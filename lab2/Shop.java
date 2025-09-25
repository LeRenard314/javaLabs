import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Shop extends Bike {
    ArrayList<Bike> bikesInStock = new ArrayList<>(
        Arrays.asList(new Bike("NovaVelo", "Motodrishpel", 2, 24, 3679.99))
    );

    public static void main(String[] args) {
        Shop magazin = new Shop();
        magazin.shopConsole(magazin);
    }

    private void shopConsole(Shop retailer) {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("== Welcome to the Bike shop admin panel! ==");
        outputCommands();
        while (true) {
            System.out.format("Input the command here: ");
            String prompt = consoleScanner.nextLine();
            if (prompt.equals("0")) {
                break;
            }
            switch (prompt) {
                case "1" -> outputBikesInStock(); // Rule case
                case "2" -> repairBike(retailer);
                case "3" -> checkout(retailer);
                case "4" -> retailer.bikesInStock.add(craftBike("HuaVel", "MieSuperOnlineBike", 3, 24, 2320.69));
                // For the sake of this lab, only one bike model can be crafted, I am getting really sleepy
                default -> System.out.println("Invalid input, please try again");
            }
        }
        System.out.println("Exiting panel...");
        consoleScanner.close();
    }

    private void outputCommands() {
        System.out.println("""
        You have access to the following commands:
        0 - Exit
        1 - Output current stock
        2 - Repair a bike
        3 - Sell a bike
        4 - Craft a bike
        """);
    }

    private void outputBikesInStock() {
        if (!bikesInStock.isEmpty()) {
            System.out.println("Current bikes in stock: ");
            for (Bike avaibleBike : bikesInStock) {
                System.out.println(avaibleBike.toString());
            }
        } else {
            System.out.println("There are no bikes in the store! You need to craft more");
        }
    }

    public Bike craftBike(String brand, String model, int wheelQuantity, int wheelDiameter, double retailPrice) {
        Bike producedBike = new Bike(brand, model, wheelQuantity, wheelDiameter, retailPrice);
        return producedBike;
    }

    public void repairBike(Shop retailer) { // Almost fell asleep while writing this, I will leave it like so
        Bike brokenBike = retailer.bikesInStock.get(0);
        System.out.format("The bike %s has been repaired!\n", brokenBike.model);
    }

    public void checkout(Shop retailer) {
        Bike soldBike = retailer.bikesInStock.get(0);
        retailer.bikesInStock.remove(0);
        System.out.format("The bike %s has been sold for %f!\n", soldBike.model, soldBike.price);
    }

}