package org.example.collection;


import java.io.Serializable;
import java.util.*;

class HashSetC<E> extends AbstractSet<E> implements Cloneable, Serializable{

    private transient HashMap<E, Object> map;
    private static final Object PRESENT = new Object();

    public HashSetC(){
        map = new HashMap<>();
    }
    @Override
    public int size() {
        if (map.isEmpty()){
            throw new NullPointerException("E");
        }else {
            return map.size();
        }
    }

    @Override
    public boolean isEmpty() {
        if (map.isEmpty()){
            throw new NullPointerException("E");
        }else {
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        if (map.containsKey(o)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public boolean remove(Object o) {
        if (map.isEmpty()){
            throw new NullPointerException("Message");
        }else {
            return map.remove(o) == PRESENT;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        return false;
    }

    @Override
    public void clear() {
        map.clear();
    }
}
public class HashSetCustom {
}
