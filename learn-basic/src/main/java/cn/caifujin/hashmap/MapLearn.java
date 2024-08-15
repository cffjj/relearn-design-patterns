package cn.caifujin.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapLearn {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);
        // 一
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() +"："+ entry.getValue());
        }
        // 二
        for (String key : map.keySet()) {
            System.out.println(key + "：" + map.get(key));
        }
        // 三
        for (Integer value : map.values()) {
            System.out.println(value);
        }
        // 四
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey() +"："+ next.getValue());
        }
        // 五
        map.forEach((key,value) -> System.out.println(key + "：" + value));
    }
}
