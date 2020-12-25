package i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

/**
 * @Author ISJINHAO
 * @Date 2020/12/23 18:28
 */
@Configuration
public class I18nWithSpringDemo {
    @Bean("messageSource")
    ResourceBundleMessageSource resourceBundleMessageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        // 添加资源名称
        messageSource.setBasenames(new String[]{"META-INF/i18ntest", "META-INF/extend"});
        return messageSource;
    }


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(I18nWithSpringDemo.class);
        System.out.println("Spring Default 1:" + context.getMessage("say", null, Locale.getDefault()));
        System.out.println("Spring Default 2:" + context.getMessage("say", null, null));
        System.out.println("Spring Chinese:" + context.getMessage("say", null, Locale.SIMPLIFIED_CHINESE));
        System.out.println("Spring Us English:" + context.getMessage("say", null, Locale.US));
        System.out.println("Spring Custom:" + context.getMessage("say", null, new Locale("web", "BASE64")));
        // 第二个参数可以使用MessageFormat格式
        System.out.println("Spring Argument:" + context.getMessage("info", new String[]{"chkui"}, null));
        // locale为空，取得是默认的Locale
        System.out.println("Spring Info:" + context.getMessage("say", null, null));
        //
        System.out.println("Spring Info:" + context.getMessage("say", null, Locale.JAPAN));

    }

}