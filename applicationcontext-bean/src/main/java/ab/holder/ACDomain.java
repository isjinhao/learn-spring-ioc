package ab.holder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

/**
 * @Author ISJINHAO
 * @Date 2020/12/5 14:07
 */
@Setter
@Getter
@ToString
public class ACDomain {

    private BeanFactory beanFactory;
    private ApplicationContext applicationContext;

}
