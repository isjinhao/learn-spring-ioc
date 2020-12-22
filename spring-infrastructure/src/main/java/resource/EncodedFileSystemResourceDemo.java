package resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.Reader;

/**
 * @Author ISJINHAO
 * @Date 2020/12/20 10:39
 */
public class EncodedFileSystemResourceDemo {

    public static void main(String[] args) throws Exception {

        String currentJavaFilePath = System.getProperty("user.dir") + "\\spring-infrastructure\\src\\main\\java\\resource\\EncodedFileSystemResourceLoaderDemo.java";
        System.out.println(currentJavaFilePath);
        // FileSystemResource => WritableResource => Resource
        FileSystemResource fileSystemResource = new FileSystemResource(currentJavaFilePath);
        EncodedResource encodedResource = new EncodedResource(fileSystemResource, "UTF-8");
        try (Reader reader = encodedResource.getReader()) {
            System.out.println(IOUtils.toString(reader));
        }

    }

}
