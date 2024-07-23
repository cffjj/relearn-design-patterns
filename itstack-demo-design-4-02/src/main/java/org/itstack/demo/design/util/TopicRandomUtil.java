package org.itstack.demo.design.util;

import java.util.*;

public class TopicRandomUtil {
    /**
     *  乱序map元素，记录对应答案key
     */
    static public Topic random(Map<String,String> option, String key){
        Set<String> keySet = option.keySet();
        ArrayList<String> keyList = new ArrayList<>(keySet);
        Collections.shuffle(keyList);
        HashMap<String, String> optionNew = new HashMap<>();
        int idx = 0;
        String keyNew = "";
        for (String next : keySet) {
            String randomKey = keyList.get(idx++);
            if (key.equals(next)){
                keyNew = randomKey;
            }
            optionNew.put(randomKey,option.get(next));
        }
        return new Topic(optionNew,keyNew);

    }

}
