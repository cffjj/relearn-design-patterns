package org.itstack.demo.design.domain2.service.engine;

import org.itstack.demo.design.domain2.service.logic.LogicFilter;
import org.itstack.demo.design.domain2.service.logic.impl.UserAgeFilter;
import org.itstack.demo.design.domain2.service.logic.impl.UserGenderFilter;

import java.util.HashMap;
import java.util.Map;

public class EngineConfig {
    static Map<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap = new HashMap<>();
        logicFilterMap.put("userAge",new UserAgeFilter());
        logicFilterMap.put("userGender",new UserGenderFilter());
    }

    public static Map<String, LogicFilter> getLogicFilterMap() {
        return logicFilterMap;
    }

    public static void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
        EngineConfig.logicFilterMap = logicFilterMap;
    }
}
