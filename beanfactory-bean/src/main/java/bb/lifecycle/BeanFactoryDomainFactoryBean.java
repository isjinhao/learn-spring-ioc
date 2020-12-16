package bb.lifecycle;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author ISJINHAO
 * @Date 2020/12/15 21:08
 */
public class BeanFactoryDomainFactoryBean implements FactoryBean<BeanFactoryDomain> {
    @Override
    public BeanFactoryDomain getObject() throws Exception {
        return new BeanFactoryDomain(20, "create-by-factory-bean");
    }
    @Override
    public Class<?> getObjectType() {
        return BeanFactoryDomain.class;
    }
}