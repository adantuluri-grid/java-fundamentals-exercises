package com.bobocode.basics;

/**
 * {@link Box} is a container class that can store a value of any given type.
 * By using Generics (T), we ensure type safety at compile time and eliminate
 * the need for manual casting when retrieving values.
 *
 * @param <T> the type of value stored in this box
 */
public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}