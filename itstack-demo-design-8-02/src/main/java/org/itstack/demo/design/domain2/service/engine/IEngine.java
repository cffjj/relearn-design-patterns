package org.itstack.demo.design.domain2.service.engine;

import org.itstack.demo.design.domain2.model.aggregates.TreeRich;
import org.itstack.demo.design.domain2.model.vo.EngineResult;

import java.util.Map;

public interface IEngine {
    EngineResult process(final Long treeId, final String userId, TreeRich treeRich, final Map<String,String> decisionMatter);
}
