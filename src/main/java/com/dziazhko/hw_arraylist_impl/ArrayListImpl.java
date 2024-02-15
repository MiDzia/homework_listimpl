package com.dziazhko.hw_arraylist_impl;

import java.util.Arrays;

public class ArrayListImpl<T> {
    private static final int START_CAPACITY = 10;

    private T[] array;

    private int size;

    private int capacity;

    private boolean isSorted = false;

    public ArrayListImpl() {
        this.array = (T[]) new Object[START_CAPACITY];
        size = 0;
    }

    public int length() {
        return array.length;
    }

    public ArrayListImpl(int capacity) {
        this.array = (T[]) new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    public T get(int num) {
        if (num < 0 || num >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            return array[num];
        }
    }

    public void add(T obj) {
        if (size == array.length) {
            increaseCapacity();
        }
        array[size++] = obj;
        isSorted = false;
    }

    public void increaseCapacity() {
        int newCapacity = array.length + 1;
        array = Arrays.copyOf(array, newCapacity);
    }

    public void remove(int num) {
        int newCapacity = size - 1;
        T[] arr = Arrays.copyOf(array, size);
        array = Arrays.copyOf(array, newCapacity);
        for (int i = 0; i < newCapacity; i++) {
            if (i >= num) {
                array[i] = arr[i + 1];
            }
        }
        size--;
    }

    public void addAll(T[] arrayNext) {
        int newCapacity = arrayNext.length + size;
        array = Arrays.copyOf(array, newCapacity);
        for (T t : arrayNext) {
            array[size++] = t;
        }
        isSorted = false;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public void sort() {

        if (!isSorted) {
            for (int i = 1; i < size; i++) {
                for (int j = size - 1; j >= i; j--) {
                    if ((int) array[j - 1] > (int) array[j]) {
                        T t = array[j - 1];
                        array[j - 1] = array[j];
                        array[j] = t;
                    }
                }
            }
        } else {
            System.out.println("Этот список уже отсортирован!");
        }
        isSorted = true;
    }

}
