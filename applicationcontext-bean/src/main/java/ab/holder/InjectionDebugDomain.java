package ab.holder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * @Author ISJINHAO
 * @Date 2020/12/6 15:41
 */
@Setter
@Getter
@ToString
public class InjectionDebugDomain {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ACDomain acDomain;

}
