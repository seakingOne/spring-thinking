package com.ynhuang.math.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author YuHuang
 */
public class LruImplFromLinkedHashMap<K, V> {

    private LinkedHashMap<K, V> linkedHashMap;

    public LruImplFromLinkedHashMap(int size) {

        linkedHashMap = new LinkedHashMap(size, 0.75f, true) {

            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                if (this.size() > size) {
                    return true;
                }

                return false;
            }
        };

    }

    public void put(K key, V value) {
        linkedHashMap.put(key, value);
    }

    public V get(K key) {
        return linkedHashMap.get(key);
    }

    public static void main(String[] args) {

        LruImplFromLinkedHashMap<String, String> lru = new LruImplFromLinkedHashMap<>(3);
        lru.put("1", "1");
        lru.put("2", "2");
        lru.put("3", "3");
        lru.put("4", "4");
        lru.put("2", "2");

        String s = lru.get("1");
        System.out.println(s);
    }


}
