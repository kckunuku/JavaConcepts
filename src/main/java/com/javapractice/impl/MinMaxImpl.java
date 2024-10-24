package com.javapractice.impl;

import com.javapractice.interfaces.MinMax;

public class MinMaxImpl<T extends Comparable<T>> implements MinMax<T> {

    T[] vals;

    public MinMaxImpl(T[] vals) {
        this.vals = vals;
    }

    @Override
    public T min() {
        T min = this.vals[0];
        for(T val: vals) {
            if(val.compareTo(min) < 0) {
                min = val;
            }
        }
        return min;
    }

    @Override
    public T max() {
        T max = this.vals[0];
        for(T val: vals) {
            if(val.compareTo(max) > 0) {
                max = val;
            }
        }
        return max;
    }
}
