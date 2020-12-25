package i18n;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

/**
 * @Author ISJINHAO
 * @Date 2020/12/23 19:35
 */
public class ReloadableResourceBundleMessageSourceDemo {

    public static void main(String[] args) throws Exception {

        GenericApplicationContext context = new GenericXmlApplicationContext("META-INF/reload-ms-context.xml");

        ReloadableResourceBundleMessageSource messageSource = (ReloadableResourceBundleMessageSource)context.getBean("messageSource");

        while(true) {
            System.out.println(messageSource.getMessage("say", null, Locale.getDefault()));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
