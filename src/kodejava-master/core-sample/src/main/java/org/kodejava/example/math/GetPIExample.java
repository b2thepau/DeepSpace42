
package org.kodejava.example.math;

public class GetPIExample {
    public static void main(String[] args) {
        //
        // The pi value represented by Math.PI
        //
        System.out.println("PI = " + Math.PI);

        //
        // Using the Math.PI to calculate area of a circle.
        //
        double radius = 8;
        double circleArea = Math.PI * Math.pow(radius, 2);
        System.out.println("Circle Area = " + circleArea);
    }
}
