package org.itstack.demo.design.domain.service.engine.impl;

import org.itstack.demo.design.domain.model.aggregates.TreeRich;
import org.itstack.demo.design.domain.model.vo.EngineResult;
import org.itstack.demo.design.domain.model.vo.TreeNode;
import org.itstack.demo.design.domain.service.engine.EngineBase;

import java.util.Map;

public class TreeEngineHandle extends EngineBase {
    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);

        return new EngineResult(userId,treeId,treeNode.getTreeNodeId(),treeNode.getNodeValue());
    }
}
