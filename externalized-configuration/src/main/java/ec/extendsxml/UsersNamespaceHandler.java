package ec.extendsxml;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @Author ISJINHAO
 * @Date 2020/12/19 22:17
 */
public class UsersNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        // 将 "user" 元素注册对应的 BeanDefinitionParser 实现
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
