package com.company;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String exchangeIds="1092,1094,1002,1003,1105";
        String exchangeId = "1105";

        System.out.println(Arrays.asList(exchangeIds.split(",")).contains(exchangeId));
    }



}
