package ra.pathmatching;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * @author 01395265
 * @date 2020/12/21
 */
public class PathMatchingResourcePatternResolverDemo {

    public static void main(String[] args) throws Exception {

        DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();

        PathMatchingResourcePatternResolver resourcePatternResolver =
                new PathMatchingResourcePatternResolver(defaultResourceLoader);

        Resource[] resources = resourcePatternResolver.getResources("classpath*:ra/**/*.class");

        for (Resource resource : resources) {
            System.out.println(resource.getURL());
        }

        System.out.println(resources.length);

    }

}