package com.beingapple.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class Map implements Iterator<Iterator<Integer>> {
    private boolean hasNext;

    private Iterator<List<Integer>> innerIterator;
    private Function<List, Iterator> functionalInterface;

    public Map(Function<List, Iterator> functionalInterface, Iterator<List<Integer>> innerIterator){
        this.functionalInterface = functionalInterface;
        this.innerIterator = innerIterator;
        this.hasNext = innerIterator.hasNext();
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public Iterator<Integer> next() {
        List<Integer> innerList = innerIterator.next();
        Iterator<Integer> returnData = functionalInterface.apply(innerList);
        hasNext = innerIterator.hasNext();

        return returnData;
    }
}
