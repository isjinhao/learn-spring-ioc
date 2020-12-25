package ra;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;

/**
 * 带有字符编码的 {@link FileSystemResourceLoader} 示例
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see FileSystemResourceLoader
 * @see FileSystemResource
 * @see EncodedResource
 * @since
 */
public class EncodedFileSystemResourceLoaderDemo {

    private static String classpathFileLocation = "resource\\EncodedFileSystemResourceLoaderDemo";

    public static void main(String[] args) throws IOException {
        String currentJavaFilePath = "/" + System.getProperty("user.dir") +
                "\\spring-infrastructure\\src\\main\\java\\" + classpathFileLocation + ".java";
        FileSystemResourceLoader fsResourceLoader = new FileSystemResourceLoader();
        Resource resource = fsResourceLoader.getResource(currentJavaFilePath);
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        // 字符输入流
        try (Reader reader = encodedResource.getReader()) {
            System.out.println(IOUtils.toString(reader));
        }


        DefaultResourceLoader cpResourceLoader = new DefaultResourceLoader();
        Resource resource1 = cpResourceLoader.getResource(classpathFileLocation + ".class");
        try (InputStream reader = resource1.getInputStream()) {
            System.out.println(IOUtils.toString(reader, Charset.forName("UTF-8")));
        }
    }
}
