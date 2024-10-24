package com.javapractice;

import com.javapractice.impl.MinMaxImpl;

import java.sql.SQLOutput;

public class GenericInterfacesPractice {
    public static void main(String[] args) {
        Integer [] integers = {6, 4, 10, 42, 40, 81, 99, 1, 100};
        Character [] characters = {'x', 'a', 'd', 'e', 'w', 'h','i'};

        MinMaxImpl<Integer> iob = new MinMaxImpl<Integer>(integers);
        MinMaxImpl<Character> chob = new MinMaxImpl<Character>(characters);

        var test = new MinMaxImpl<>(characters);

        System.out.println("The min integer in the list of Integers is : " + iob.min());
        System.out.println("The max integer in the list of Integers is : " + iob.max());

        System.out.println("The min character in the list of characters is : " + chob.min());
        System.out.println("The max character in the list of characters is : " + chob.max());
    }
}
