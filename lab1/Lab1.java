import java.util.Scanner;
import java.util.HashMap;

public class Lab1 {
    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);

        HashMap<String, Integer> system1 = buildHashMap(consoleScanner), system2 = buildHashMap(consoleScanner);

        systemComaprison(system1.get("intersectionPoints"), system2.get("intersectionPoints"));

        consoleScanner.close();
    }

    private static HashMap<String, Integer> buildHashMap(Scanner scan) {
        String[] coefficients = {"A", "B", "C", "xZero", "yZero", "R"};
        HashMap<String, Integer> mapData = new HashMap<>();

        System.out.println("The program will prompt you to enter the coefficients of linear and circle equasions");
        
        for (String coefficient: coefficients) {
            System.out.format("Enter %s: ", coefficient);
            mapData.put(coefficient, scan.nextInt());
        }

        mapData.put("intersectionPoints", calculateIntersectionPoints(mapData));
        
        return mapData;
    }

    private static boolean durakProtocol(String target, int value) {
        return false;
    }

    private static int calculateIntersectionPoints(HashMap<String, Integer> map) {
        int a = map.get("A"), b = map.get("B"), c = map.get("C"), xZero = map.get("xZero"), yZero = map.get("yZero"), r = map.get("R");
        int points = 0, distance = Math.abs(a * xZero + b * yZero + c) / (int)Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        if (distance == r) {
            points = 1;
        } else if (distance < r) {
            points = 2;
        }
        return points;
    }

    private static void systemComaprison(int points1, int points2) {
        if (points1 > points2) {
            System.out.println("The first system has more intersection points than the second system");
        } else if (points1 < points2) {
            System.out.println("The first system has less intersection points than the second system");
        } else {
            System.out.println("The first system has the same amount of intersection points as the second system");
        }
        System.out.format("Intersection points:\n System 1: %d\t System2: %d\n", points1, points2);
    }
}
