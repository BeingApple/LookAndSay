package com.beingapple.iterator;

import java.util.Iterator;

public class Concat implements Iterator<Integer> {
    private Iterator<Iterator<Integer>> innerIterator;
    private Iterator<Integer> returnIterator;

    private boolean hasNext;
    private boolean innerNext;
    private boolean returnNext;

    public Concat(Iterator<Iterator<Integer>> innerIterator){
        this.innerIterator = innerIterator;
        this.innerNext = innerIterator.hasNext();
        this.hasNext = this.innerNext;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public Integer next() {
        int result = 0;

        if(returnIterator == null){
            returnIterator = innerIterator.next();
        }

        if(returnIterator != null){
            returnNext = returnIterator.hasNext();

            if(returnNext){
                result = returnIterator.next();
            }else if(innerIterator.hasNext()){
                returnIterator = innerIterator.next();
                result = returnIterator.next();
            }

            hasNext = innerNext;
        }

        innerNext = innerIterator.hasNext();

        return result;
    }
}
