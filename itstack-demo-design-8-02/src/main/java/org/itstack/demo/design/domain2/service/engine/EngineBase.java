package org.itstack.demo.design.domain2.service.engine;

import org.itstack.demo.design.domain2.model.aggregates.TreeRich;
import org.itstack.demo.design.domain2.model.vo.EngineResult;
import org.itstack.demo.design.domain2.model.vo.TreeNode;
import org.itstack.demo.design.domain2.model.vo.TreeRoot;
import org.itstack.demo.design.domain2.service.logic.LogicFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public abstract class EngineBase extends EngineConfig implements IEngine{
    Logger logger = LoggerFactory.getLogger(EngineBase.class);
    @Override
    public abstract EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter);

    protected TreeNode engineDecisionMaker(TreeRich treeRich,Long treeId,String userId,Map<String,String> decisionMatter){
        TreeRoot treeRoot = treeRich.getTreeRoot();
        Map<Long, TreeNode> treeNodeMap = treeRich.getTreeNodeMap();
        Long treeRootNodeId = treeRoot.getTreeRootNodeId();
        TreeNode treeNode = treeNodeMap.get(treeRootNodeId);
        while (treeNode.getNodeType().equals(1)){
            String ruleKey = treeNode.getRuleKey();
            LogicFilter logicFilter = logicFilterMap.get(ruleKey);
            String matterValue = logicFilter.matterValue(treeNode.getTreeId(), userId, decisionMatter);
            Long nodeId = logicFilter.filter(matterValue, treeNode.getTreeNodeLinkList());
            treeNode = treeNodeMap.get(nodeId);
            logger.info("决策树引擎=>{} userId：{} treeId：{} treeNode：{} ruleKey：{} matterValue：{}",treeRoot.getTreeName(),userId,treeNode.getTreeId(),treeNode.getTreeNodeId(),ruleKey,matterValue);
        }

        return treeNode;
    }
}
