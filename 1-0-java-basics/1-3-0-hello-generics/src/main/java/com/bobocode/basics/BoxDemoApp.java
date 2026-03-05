package com.bobocode.basics;

/**
 * Refactored demo using Generics.
 * Now, trying to set a String value into an Integer box will result
 * in a compile-time error, fulfilling the "fail-fast" principle.
 */
public class BoxDemoApp {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>(123);
        Box<Integer> intBox2 = new Box<>(321);

        System.out.println(intBox.getValue() + intBox2.getValue());

        intBox.setValue(222);

        // TODO: The line below will now cause a COMPILE-TIME ERROR.


        System.out.println(intBox.getValue() + intBox2.getValue());
    }
}