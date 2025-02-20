package com.github.sogandjavaheri.Fractional;
import java.util.Scanner;

public class Fractional {

    private int numerator;
    private int denominator;


    public Fractional(){
        this(1,1);
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

    public int getDenominator() {
        return this.denominator;
    }

    public void setDenominator(int den) {
        this.denominator = den;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public void setNumerator(int num) {
        this.numerator = num;
    }

    public Fractional add(Fractional f){
            return new Fractional(numerator * f.denominator + f.numerator * denominator, denominator * f.denominator);
        }

    public Fractional subtract(Fractional f) {
            return new Fractional(numerator * f.denominator - f.numerator * denominator, denominator * f.denominator);
        }

    public Fractional multiply(Fractional f) {
            return new Fractional(numerator * f.numerator, denominator * f.denominator);
        }

    public Fractional divide(Fractional f) {
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
            numerator = -numerator;
            denominator = -denominator;
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
}
