package com.github.sogandjavaheri.FractionCalculator;
import java.util.Scanner;

public class Fractional {


        int numerator, denominator;

        public Fractional(){

        }

        public Fractional(int numerator, int denominator) {
            Scanner scanner = new Scanner(System.in);

            while (denominator == 0) {
                System.out.print("Denominator cannot be zero! Enter again: ");
                denominator = scanner.nextInt();
            }

            this.numerator = numerator;
            this.denominator = denominator;
            simplify();
        }

    Fractional add(Fractional f){
            return new Fractional(numerator * f.denominator + f.numerator * denominator, denominator * f.denominator);
        }

    Fractional subtract(Fractional f) {
            return new Fractional(numerator * f.denominator - f.numerator * denominator, denominator * f.denominator);
        }

    Fractional multiply(Fractional f) {
            return new Fractional(numerator * f.numerator, denominator * f.denominator);
        }

    Fractional divide(Fractional f) {
            if (f.numerator == 0) {
                System.out.println("Cannot divide by zero fraction!");
                return this;
            }

            return new Fractional(numerator * f.denominator, denominator * f.numerator);
        }

        public void simplify() {
            int gcd = findGCD(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;

            if (denominator < 0) {
                numerator = -numerator; denominator = -denominator;
            }
        }

        public int findGCD(int a, int b) {
            a = a < 0 ? -a : a;
            b = b < 0 ? -b : b;

                while (b != 0) {
                    int temp = b;
                    b = a % b;
                    a = temp;
                }
            return a;
        }

        public String toString() {
            return numerator + "/" + denominator;
        }

        static void startCalculator() {
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
