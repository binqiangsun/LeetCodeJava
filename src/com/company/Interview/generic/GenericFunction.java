package com.company.Interview.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunbinqiang on 2020/7/4.
 */
public class GenericFunction {
    public void test() {
        Map<String, List<String>> map = new HashMap();
        map.put("", new ArrayList<>());
    }

    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }
}
