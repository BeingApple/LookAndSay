package com.beingapple;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	    LookAndSay lookAndSay = new LookAndSay(1, 10);
        Iterator<Integer> result = lookAndSay.makeLookAndSay();

        while(result.hasNext()){
            System.out.print(result.next());
        }
    }
}
