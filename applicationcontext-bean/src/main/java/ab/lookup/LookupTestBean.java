package ab.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

/**
 * @Author ISJINHAO
 * @Date 2020/12/30 22:37
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LookupTestBean {
    
    @Autowired
    private HelloWorldService service;
    
    private String msg;

    public void print() {
        service.helloWorld(msg);
    }

    public LookupTestBean(String msg) {
        this.msg = msg;
    }
}
