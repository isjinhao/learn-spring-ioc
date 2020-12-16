package bb.lifecycle;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author 01395265
 * @date 2020/12/3
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
