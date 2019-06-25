package com.company.Interview;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by sunbinqiang on 2019/4/20.
 */
public class HashMapDemo {

    private void test() {
        Map<String, String> map = new HashMap<>();
        map.put("123", "xyz");
        Map<String, String> conMap = new ConcurrentHashMap<>();
    }
}
