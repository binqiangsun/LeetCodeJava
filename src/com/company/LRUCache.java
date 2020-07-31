package com.company;



import java.util.LinkedList;

/**
 * Created by sunbinqiang on 2020/5/10.
 */

class LRUCache {

    class Element<T, V> {
        private T key;
        private V value;

        public Element(T k, V v) {
            this.key = k;
            this.value = v;
        }

        public T getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private LinkedList<Element<Integer, Integer>> list = new LinkedList<>();
    private int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Element<Integer, Integer> res = findByKey(key);
        if (res == null) {
            return -1;
        } else {
            list.remove(res);
            list.addFirst(res);
            return res.getValue();
        }
    }

    private Element<Integer, Integer> findByKey(int key) {
        for (Element<Integer, Integer> element: list) {
            if (element.getKey() == key) {
                return element;
            }
        }
        return null;
    }

    public void put(int key, int value) {
        Element<Integer, Integer> element = findByKey(key);
        if (element != null) {
            list.remove(element);
        }
        Element<Integer, Integer> elementNew = new Element<>(key, value);
        list.addFirst(elementNew);
        trim();
    }

    /**
     * 删除多余的数据
     */
    private void trim() {
        if (list.size() > capacity) {
            list.removeLast();
        }
    }
}
