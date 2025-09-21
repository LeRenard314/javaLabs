import java.util.Scanner;
import java.util.HashMap;

public class Lab1 {
    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        HashMap<String, Double> system1 = buildHashMap(consoleScanner, 1), system2 = buildHashMap(consoleScanner, 2);
        systemComparison(system1.get("intersectionPoints"), system2.get("intersectionPoints"));
        consoleScanner.close();
    }

    private static HashMap<String, Double> buildHashMap(Scanner scan, int systemNumber) {
        String[] coefficients = {"A", "B", "C", "xZero", "yZero", "R"};
        HashMap<String, Double> mapData = new HashMap<>();
        System.out.format("== Enter the coefficents for system %d ==\n", systemNumber);
        for (String coefficient: coefficients) {
            System.out.format("Enter %s: ", coefficient);
            mapData.put(coefficient, scan.nextDouble());
        }
        mapData.put("intersectionPoints", calculateIntersectionPoints(mapData));
        return mapData;
    }

    private static boolean durakProtocol(String target, int value) {
        return false;
    }

    private static double calculateIntersectionPoints(HashMap<String, Double> map) {
        double a = map.get("A"), b = map.get("B"), c = map.get("C"), xZero = map.get("xZero"), yZero = map.get("yZero"), r = map.get("R");
        double points = 0, distance = Math.abs(a * xZero + b * yZero + c) / (int)Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        if (distance == r) {
            points = 1;
        } else if (distance < r) {
            points = 2;
        }
        return points;
    }

    private static void systemComparison(double points1, double points2) {
        System.out.println("== Results ==");
        if (points1 > points2) {
            System.out.println("The first system has more intersection points than the second system");
        } else if (points1 < points2) {
            System.out.println("The first system has less intersection points than the second system");
        } else {
            System.out.println("The first system has the same amount of intersection points as the second system");
        }
        System.out.format("Intersection points:\nSystem 1: %d\t System2: %d\n", (int)points1, (int)points2);
    }
}