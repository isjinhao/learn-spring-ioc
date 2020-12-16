package ab.holder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;

/**
 * @Author ISJINHAO
 * @Date 2020/12/5 14:07
 */
@Setter
@Getter
@ToString
public class ACDomainWithSmartInitializing implements SmartInitializingSingleton {

    private BeanFactory beanFactory;
    private ApplicationContext applicationContext;

    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("所有Bean都实例化完成了，现在执行ACDomainWithSmartInitializing的afterSingletonsInstantiated");
    }
}
