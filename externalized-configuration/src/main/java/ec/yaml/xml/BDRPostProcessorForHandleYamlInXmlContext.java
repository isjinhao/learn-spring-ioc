package ec.yaml.xml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.beans.factory.support.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.InputStreamResource;
import org.springframework.util.DefaultPropertiesPersister;

import java.io.*;
import java.util.Properties;

/**
 * @Author ISJINHAO
 * @Date 2020/12/18 20:59
 */
public class BDRPostProcessorForHandleYamlInXmlContext implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // do nothing
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) registry;
        beanFactory.addBeanPostProcessor(new XmlYamlBeanPostProcessor());
    }

}

class XmlYamlBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass().equals(PropertySourcesPlaceholderConfigurer.class)) {
            PropertySourcesPlaceholderConfigurer placeholderConfigurer = (PropertySourcesPlaceholderConfigurer) bean;
            placeholderConfigurer.setPropertiesPersister(new XmlYamlPropertiesPersister());
        }
        return bean;
    }
}

class XmlYamlPropertiesPersister extends DefaultPropertiesPersister {

    @Override
    public void load(Properties props, Reader reader) throws IOException {
        InputStreamReader inputStreamReader = (InputStreamReader)reader;

        char buf[] = new char[10];
        inputStreamReader.read(buf, 0, 10);
        if(!"yaml: true".equals(new String(buf))){
            super.load(props, reader);
            return;
        }

        StringBuffer propertiesBuffer = new StringBuffer();
        BufferedReader bufferedreader = new BufferedReader(inputStreamReader);
        String line ;
        while((line = bufferedreader.readLine()) != null) {
            propertiesBuffer.append(line + "\n");
        }

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(propertiesBuffer.toString().getBytes("UTF-8"));
        InputStreamResource inputStreamResource = new InputStreamResource(byteArrayInputStream);
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        yamlPropertiesFactoryBean.setResources(inputStreamResource);
        Properties yamlProperties = yamlPropertiesFactoryBean.getObject();
        propertiesBuffer.setLength(0);
        yamlProperties.forEach((o, o2) -> propertiesBuffer.append(o.toString() + "=" + o2.toString() + "\n"));

        props.load(new ByteArrayInputStream(propertiesBuffer.toString().getBytes("UTF-8")));
    }

}
