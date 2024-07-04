package org.itstack.demo.design.test;

import org.itstack.demo.design.IUserDao;
import org.itstack.demo.design.fj.IMyUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_IUserDao(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserDao userDao = beanFactory.getBean("userDao", IUserDao.class);
        String res = userDao.queryUserInfo("10001");
        logger.info("测试结果：{}",res);
    }

    @Test
    public void test_IMyUserDao(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        IMyUserDao myUserDao = beanFactory.getBean("myUserDao", IMyUserDao.class);
        String res = myUserDao.updateUserInfo("10003");
        logger.info("测试结果：{}",res);
    }
}
