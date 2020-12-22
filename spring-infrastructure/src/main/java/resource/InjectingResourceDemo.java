package resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.util.stream.Stream;
import resource.util.ResourceUtils;

/**
 * 注入 {@link Resource} 对象示例
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see Resource
 * @see Value
 * @see AnnotationConfigApplicationContext
 * @since
 */
public class InjectingResourceDemo {

    @Value("classpath:/META-INF/resource/default.properties")
    private Resource defaultPropertiesResource;

    @Value("classpath*:/META-INF/**/*.properties")
    private Resource[] propertiesResources;

    @Value("${user.dir}")
    private String currentProjectRootPath;

    @PostConstruct
    public void init() {
        System.out.println(ResourceUtils.getContent(defaultPropertiesResource));
        System.out.println("================");
        Stream.of(propertiesResources).map(ResourceUtils::getContent).forEach(System.out::println);
        System.out.println("================");
        System.out.println(currentProjectRootPath);
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册当前类作为 Configuration Class
        context.register(InjectingResourceDemo.class);
        // 启动 Spring 应用上下文
        context.refresh();
        // 关闭 Spring 应用上下文
        context.close();

    }
}
