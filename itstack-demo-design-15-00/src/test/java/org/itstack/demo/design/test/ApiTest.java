package org.itstack.demo.design.test;


import cn.caifujin.demo.mysign.group.Employee;
import cn.caifujin.demo.mysign.group.GroupStructure;
import cn.caifujin.demo.mysign.group.Link;
import cn.caifujin.demo.mysign.lang.Iterator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiTest {

    Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_iterator(){
        GroupStructure groupStructure = new GroupStructure("1","大菜");
        groupStructure.add(new Employee("2","花花","二级部门"));
        groupStructure.add(new Employee("3", "豆包", "二级部门"));
        groupStructure.add(new Employee("4", "蹦蹦", "三级部门"));
        groupStructure.add(new Employee("5", "大烧", "三级部门"));
        groupStructure.add(new Employee("6", "虎哥", "四级部门"));
        groupStructure.add(new Employee("7", "玲姐", "四级部门"));
        groupStructure.add(new Employee("8", "秋雅", "四级部门"));

        groupStructure.addLink("1",new Link("1","2"));
        groupStructure.addLink("1",new Link("1","3"));

        groupStructure.addLink("2",new Link("2","4"));
        groupStructure.addLink("2",new Link("2","5"));

        groupStructure.addLink("3",new Link("3","6"));
        groupStructure.addLink("3",new Link("3","7"));
        groupStructure.addLink("3",new Link("3","8"));

        Iterator<Employee> iterator = groupStructure.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            logger.info("{},雇员id：{} Name：{}",employee.getDesc(),employee.getuId(),employee.getName());
        }
    }
}
