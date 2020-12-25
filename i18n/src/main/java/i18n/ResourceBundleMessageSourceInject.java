package i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

/**
 * @Author ISJINHAO
 * @Date 2020/12/23 18:47
 */
public class ResourceBundleMessageSourceInject {

    @Autowired
    private ResourceBundleMessageSource rbMessageSource;

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericXmlApplicationContext("META-INF/ms-context.xml");

        ResourceBundleMessageSourceInject rbMessageSourceInject = context.getBean(ResourceBundleMessageSourceInject.class);

        System.out.println("依赖注入的ms： " + rbMessageSourceInject.rbMessageSource);
        System.out.println("依赖查找的ms： " + context.getBean("messageSource"));
        System.out.println("Aware注入的ms： " + ((MessageSourceAwareDomain)context.getBean("msDomain")).messageSource);
        System.out.println("ApplicationContext作为ms： " + context);
        System.out.println(context.getMessage("say", null, Locale.getDefault()));
    }

}

class MessageSourceAwareDomain implements MessageSourceAware {
    public MessageSource messageSource;
    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}