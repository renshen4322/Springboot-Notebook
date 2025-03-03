package com.xiaofu.process;

import lombok.NoArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;

@NoArgsConstructor
public class MyPropertiesBeanFactoryPostProcessor implements BeanFactoryPostProcessor, Ordered {

    EnvCopy1 envCopy1 ;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory a) throws BeansException {
        MutablePropertySources propertySources = envCopy1.get().getPropertySources();
        for (PropertySource<?> propertySource : propertySources) {
            if (propertySource instanceof PropertiesPropertySource) {
                System.out.println(propertySource.getProperty("propertyKey"));
                //用propertySource.getSource()  可以获取全部配置
            }
        }
    }
    @Override
    public int getOrder() {
        return 0;
    }


}
