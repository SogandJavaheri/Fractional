package com.github.sogandjavaheri.Fractional;

import java.util.Scanner;

public class FractionalTest {
    public static void main(String[] args) {

        startCalculator();

    }

    public static void startCalculator() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
                System.out.println("Enter first fraction:");
                Fractional f1 = new Fractional(scanner.nextInt(), scanner.nextInt());
                System.out.println("Enter second fraction:");
                Fractional f2 = new Fractional(scanner.nextInt(), scanner.nextInt());

                System.out.println("\n1. Add  2. Subtract  3. Multiply  4. Divide ");
                System.out.print("Choice: ");
                int choice = scanner.nextInt();

                if (choice == 1)
                    System.out.println("Result: " + f1.add(f2));

                else if (choice == 2)
                    System.out.println("Result: " + f1.subtract(f2));

                else if (choice == 3)
                    System.out.println("Result: " + f1.multiply(f2));

                else if (choice == 4)
                    System.out.println("Result: " + f1.divide(f2));

                else
                    System.out.println("Invalid choice. Try again.");

                break;
        }
    }
}