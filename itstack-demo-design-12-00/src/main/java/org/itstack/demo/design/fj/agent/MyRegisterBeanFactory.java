package org.itstack.demo.design.fj.agent;

import org.itstack.demo.design.fj.IMyUserDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class MyRegisterBeanFactory implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(MyMapperFactoryBean.class);
        genericBeanDefinition.setScope("singleton");
        genericBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue(IMyUserDao.class);
        BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(genericBeanDefinition, "myUserDao");
        BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder,registry);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
