package utils;

import java.util.Scanner;

public class UserInput {
    private static Scanner sc = new Scanner(System.in);

    public static String getStringValue(String msg){
        System.out.println(msg);
        String str = "";
        while (str.isBlank()) {
            str = sc.nextLine();
        }
        return str;
    }

    public static int getIntValue(String msg) {
        System.out.println(msg);
        int value = sc.nextInt();
        return value ;
    }

    public static double getDoubleValue(String msg){
        System.out.println(msg);
        double value = sc.nextDouble();
        sc.nextLine();
        return value;

    }
}
