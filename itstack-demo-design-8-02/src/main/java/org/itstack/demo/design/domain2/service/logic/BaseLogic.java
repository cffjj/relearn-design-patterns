package org.itstack.demo.design.domain2.service.logic;

import org.itstack.demo.design.domain2.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

public abstract class BaseLogic implements LogicFilter{
    @Override
    public Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList) {
        for (TreeNodeLink treeNodeLink : treeNodeLinkList) {
            if (decisionLogin(matterValue,treeNodeLink)) return treeNodeLink.getNodeIdTo();
        }
        return 0L;
    }

    @Override
    public abstract String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);

    public boolean decisionLogin(String matterValue,TreeNodeLink treeNodeLink){
        switch (treeNodeLink.getRuleLimitType()){
            case 1:
                return matterValue.equals(treeNodeLink.getRuleLimitValue());
            case 2:
                return Double.parseDouble(matterValue) > Double.parseDouble(treeNodeLink.getRuleLimitValue());
            case 3:
                return Double.parseDouble(matterValue) < Double.parseDouble(treeNodeLink.getRuleLimitValue());
            case 4:
                return Double.parseDouble(matterValue) >= Double.parseDouble(treeNodeLink.getRuleLimitValue());
            case 5:
                return Double.parseDouble(matterValue) <= Double.parseDouble(treeNodeLink.getRuleLimitValue());
            default:
                return false;
        }

    }
}
