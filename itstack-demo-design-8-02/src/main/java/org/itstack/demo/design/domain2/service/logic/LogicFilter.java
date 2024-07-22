package org.itstack.demo.design.domain2.service.logic;

import org.itstack.demo.design.domain2.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

public interface LogicFilter {

    Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList);

    String matterValue(Long treeId, String userId, Map<String,String> decisionMatter);
}
