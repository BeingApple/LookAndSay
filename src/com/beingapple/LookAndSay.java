package com.beingapple;

import com.beingapple.iterator.Concat;
import com.beingapple.iterator.Group;
import com.beingapple.iterator.Map;

import java.util.Arrays;
import java.util.Iterator;

public class LookAndSay {
    private int startNumber;
    private int lineNumber;
    private Iterator<Integer> iterator;

    public LookAndSay(int startNumber, int lineNumber){
        this.startNumber = startNumber;
        this.lineNumber = lineNumber;
    }

    public Iterator<Integer> makeLookAndSay(){
        iterator = makeIterator(startNumber);

        for(int i = 0 ; i < lineNumber; i++){
            iterator = makeNextSequenceLine(iterator);
        }

        return iterator;
    }

    private Iterator<Integer> makeNextSequenceLine(Iterator<Integer> beforeLine){
        return new Concat(new Map(g -> Arrays.asList(g.size(), g.get(0)).iterator() , new Group(beforeLine)));
    }

    private Iterator<Integer> makeIterator(int startNumber){
        return Arrays.asList(startNumber).iterator();
    }
}
