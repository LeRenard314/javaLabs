import java.util.Scanner;

public class Lab1 {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        
        System.out.println("Enter A:");
        int a = myScan.nextInt();

        System.out.println("Enter B:");
        int b = myScan.nextInt();

        System.out.println("Enter C:");
        int c = myScan.nextInt();

        System.out.println("Enter x0:");
        int xZero = myScan.nextInt();

        System.out.println("Enter y0:");
        int yZero = myScan.nextInt();

        System.out.println("Enter R:");
        int r = myScan.nextInt();

        int distance = Math.abs(a * xZero + b * yZero + c) / (int)Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

        if (distance > r) {
            System.out.println("There are no points of connection");
        } else if (distance == r) {
            System.out.println("There is 1 point of connection");
        } else {
            System.out.println("There are 2 connection points");
        }
    }

}