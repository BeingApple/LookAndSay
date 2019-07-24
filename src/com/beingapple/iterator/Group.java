package com.beingapple.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Group implements Iterator<List<Integer>>{
    List<Integer> innerList;

    private int state = State.INIT;
    private int next;
    private int elem;

    private boolean hasNext;

    private Iterator<Integer> innerIterator;

    public Group(Iterator<Integer> innerIterator){
        this.innerIterator = innerIterator;
        this.hasNext = innerIterator.hasNext();
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public List<Integer> next() {
        innerList = new ArrayList<>();

        if(state == State.INIT){
            state = State.HAS_NEXT;
            next = innerIterator.next();
        }

        if(state == State.HAS_NEXT){
            state = State.LAST;
            elem = next;
            innerList.add(elem);

            hasNext = innerIterator.hasNext();
            while(hasNext){
                int next = innerIterator.next();
                if(next == elem){
                    innerList.add(next);
                }else{
                    state = State.HAS_NEXT;
                    this.next = next;
                    break;
                }

                hasNext = innerIterator.hasNext();
            }

            return innerList;
        }else{
            state = State.INIT;
            return innerList;
        }
    }
}
