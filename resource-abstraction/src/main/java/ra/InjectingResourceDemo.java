package ra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import ra.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.util.stream.Stream;

/**
 * @Author ISJINHAO
 * @Date 2021/1/2 15:20
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
