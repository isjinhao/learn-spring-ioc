/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ab.dependency.injection.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.util.StringValueResolver;

/**
 * 基于 {@link Aware} 接口回调的依赖注入示例
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since
 */
public class AwareInterfaceDependencyInjectionDemo implements BeanFactoryAware, ApplicationContextAware, EmbeddedValueResolverAware, EnvironmentAware {

    private static BeanFactory beanFactory;

    private static ApplicationContext applicationContext;

    private static StringValueResolver stringValueResolver;

    private static StandardEnvironment environment;

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        context.register(AwareInterfaceDependencyInjectionDemo.class);

        // 启动 Spring 应用上下文
        context.refresh();

        System.out.println(beanFactory == context.getBeanFactory());
        System.out.println(applicationContext == context);
        System.out.println(environment.resolvePlaceholders("123"));
        System.out.println(stringValueResolver.resolveStringValue("123"));

        // 显示地关闭 Spring 应用上下文
        context.close();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        AwareInterfaceDependencyInjectionDemo.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AwareInterfaceDependencyInjectionDemo.applicationContext = applicationContext;
    }


    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        AwareInterfaceDependencyInjectionDemo.stringValueResolver = resolver;
    }

    @Override
    public void setEnvironment(Environment environment) {
        AwareInterfaceDependencyInjectionDemo.environment = (StandardEnvironment) environment;
    }

}
