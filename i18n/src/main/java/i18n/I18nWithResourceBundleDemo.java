package i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @Author ISJINHAO
 * @Date 2020/12/23 15:18
 */
public class I18nWithResourceBundleDemo {

    public static void main(String[] args) {

        // 使用当前操作系统的语言环境
        ResourceBundle rb = ResourceBundle.getBundle("META-INF/i18ntest", Locale.getDefault());
        System.out.println(rb.getString("say"));

        // 指定简体中文环境
        rb = ResourceBundle.getBundle("META-INF/i18ntest", new Locale("zh", "CN"));
        System.out.println(rb.getString("say"));

        // 通过预设指定简体英文环境
        rb = ResourceBundle.getBundle("META-INF/i18ntest", Locale.SIMPLIFIED_CHINESE);
        System.out.println(rb.getString("say"));

        // 指定美国英语
        rb = ResourceBundle.getBundle("META-INF/i18ntest", Locale.US);
        System.out.println(rb.getString("say"));

        // 使用自定义的语言环境
        Locale locale = new Locale("web", "BASE64");
        rb = ResourceBundle.getBundle("META-INF/i18ntest", locale);
        System.out.println(rb.getString("say"));

        // 在找不到的时候会去寻找默认配置，默认配置和时区有关，规则如下：
        // 假如当前时区是 zh_CN：默认配置有三个，优先级由高至低分别是
        // i18n/i18ntest_zh_CN.properties
        // i18n/i18ntest_zh.properties
        // i18n/i18ntest.properties
        rb = ResourceBundle.getBundle("META-INF/i18ntest", Locale.JAPAN);
        System.out.println(rb.getString("say"));

    }

}
