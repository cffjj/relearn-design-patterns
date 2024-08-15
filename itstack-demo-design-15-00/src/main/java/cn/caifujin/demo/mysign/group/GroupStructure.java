package cn.caifujin.demo.mysign.group;

import cn.caifujin.demo.mysign.lang.Collection;
import cn.caifujin.demo.mysign.lang.Iterator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GroupStructure implements Collection<Employee,Link> {

    private String groupId;

    private String groupName;

    Map<String,Employee> employeeMap = new ConcurrentHashMap<>();

    Map<String, List<Link>> linkMap = new ConcurrentHashMap<>();

    private Map<String,String> invertedMap = new ConcurrentHashMap<>();

    public GroupStructure(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    @Override
    public boolean add(Employee employee) {
        return null != employeeMap.put(employee.getuId(),employee);
    }

    @Override
    public boolean remove(Employee employee) {
        return null != employeeMap.remove(employee.getuId());
    }

    @Override
    public boolean addLink(String key, Link link) {
        invertedMap.put(link.getToId(),link.getFromId());
        if (linkMap.containsKey(key)){
            return linkMap.get(key).add(link);
        }else {
            List<Link> links = new LinkedList<>();
            links.add(link);
            linkMap.put(key,links);
            return true;
        }
    }

    @Override
    public boolean removeLink(String key) {
        return null != linkMap.remove(key);
    }

    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<Employee>() {

            HashMap<String,Integer> keyMap = new HashMap<>();
            int totalIdx = 0;

            private String fromId = groupId;

            private String toId = groupId;
            @Override
            public boolean hasNext() {
                return totalIdx < employeeMap.size();
            }

            @Override
            public Employee next() {
                List<Link> links = linkMap.get(toId);
                int cursorIdx = getCursorIdx(toId);

                if (null == links) {
                    cursorIdx = getCursorIdx(fromId);
                    links = linkMap.get(fromId);
                }

                while (cursorIdx > links.size() - 1) {
                    fromId = invertedMap.get(fromId);
                    cursorIdx = getCursorIdx(fromId);
                    links = linkMap.get(fromId);
                }
                Link link = links.get(cursorIdx);
                toId = link.getToId();
                fromId = link.getFromId();
                totalIdx++;
                return employeeMap.get(link.getToId());
            }

            public int getCursorIdx(String key) {
                int idx = 0;
                if (keyMap.containsKey(key)){
                    idx = keyMap.get(key);
                    keyMap.put(key,++idx);
                }else {
                    keyMap.put(key,idx);
                }
                return idx;
            }
        };
    }
}
