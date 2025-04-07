package org.example.collection;

import java.util.Arrays;
import java.util.HashMap;

class CustomArrayList<E>{
    private static int DEFAULT_SIZE = 10;
    private Object[] elements;
    int size =0;
    public CustomArrayList(){
        elements = new Object[DEFAULT_SIZE];
    }

    public boolean add(E element){
        capacity();
        elements[size++] = element;
        return true;
    }
    public int size(){
        return elements.length;
    }

    public E get(int index){
        rangeCheck(index);
        return (E) elements[index];
    }

    public E remove(int index){
        rangeCheck(index);
        Object removedNum = elements[index];
        int removedIdx = size-index-1;
        if (removedIdx > 0){
            System.arraycopy(elements,size, elements, index+1, removedIdx);
        }
        elements[size--] = null;

        return (E) removedNum;
    }

    public void rangeCheck(int index){
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException("Index Out of bound exception");
        }
    }

    public void capacity(){
        if (size == elements.length){
            elements = Arrays.copyOf(elements, size*2);
        }
    }
}
public class CustomArrayListExample {

    public static void main(String[] args) {

    }
}
