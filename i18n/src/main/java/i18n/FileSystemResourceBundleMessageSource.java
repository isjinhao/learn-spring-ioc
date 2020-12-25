package i18n;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @Author ISJINHAO
 * @Date 2020/12/24 15:53
 */
public class FileSystemResourceBundleMessageSource extends ResourceBundleMessageSource {

    private FileSystemResourceLoader fileSystemResourceLoader = new FileSystemResourceLoader();

    private List<String> propertyPaths;

    private List<PropertyResourceBundle> propertyResourceBundleList;

    private String separator = "_";

    private String suffix = ".properties";

    /**
     * <baseName, TreeMap<LocaleKey, PropertyResourceBundle>>
     */
    private Map<String, TreeMap<LocaleKey, PropertyResourceBundle>> prbMap = new HashMap<>();

    @Override
    protected ResourceBundle doGetBundle(String basename, Locale locale) throws MissingResourceException {

        for (PropertyResourceBundle prb : propertyResourceBundleList) {

        }

        return super.doGetBundle(basename, locale);
    }

    public void setProperties(List<String> propertyPaths) {
        this.propertyPaths = propertyPaths;
        for (String propertyPath : propertyPaths) {
            Resource resource = fileSystemResourceLoader.getResource(propertyPath);
            try {
                String propertyFileName = propertyPath.replaceAll(suffix, "");
                propertyFileName = propertyFileName.substring(propertyFileName.lastIndexOf((File.separator)) + 1);
                String[] split = propertyPath.split(separator);
                int length = split.length;
                LocaleKey localeKey = new LocaleKey();

                String country;
                String language;
                String baseName = null;

                if (length > 2) {
                    country = split[length - 1];
                    language = split[length - 2];
                    baseName = propertyFileName.replaceAll(separator + language + separator + country, "");
                    localeKey.setCountry(country);
                    localeKey.setLanguage(language);
                    localeKey.setBaseName(baseName);
                } else if (length == 2) {
                    language = split[length - 1];
                    baseName = propertyFileName.replaceAll(separator + language, "");
                    localeKey.setLanguage(language);
                    localeKey.setBaseName(baseName);
                } else if (length == 1) {
                    localeKey.setBaseName(propertyPath);
                }

                localeKey.setFileName(propertyPath);

                if(baseName == null) {
                    return;
                }

                TreeMap<LocaleKey, PropertyResourceBundle> localeKeyPropertyResourceBundleTreeMap = prbMap.get(baseName);
                if(localeKeyPropertyResourceBundleTreeMap == null) {


                }

                propertyResourceBundleList.add(new PropertyResourceBundle(resource.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (propertyResourceBundleList != null && propertyResourceBundleList.size() != 0) {

        }
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public void setSuffix(String suffix) {
        if (!suffix.startsWith(".")) {
            suffix = "." + suffix;
        }
        this.suffix = suffix;
    }

    public static void main(String[] args) {

        String str = "D:\\develop\\workspace\\java\\back-end\\fuck-spring\\data-operation\\src\\main\\resources\\i18n\\i18ntest_zh_CN.properties";

        System.out.println(str.substring(str.lastIndexOf((File.separator)) + 1));


        Locale locale = Locale.getDefault();
        System.out.println(locale.getCountry());
        System.out.println(locale.getLanguage());

    }


    private static class LocaleKey implements Comparable<LocaleKey> {
        private String baseName;
        private String language;
        private String country;
        private String fileName;

        public LocaleKey() {
        }

        public LocaleKey(String baseName, String language, String country) {
            this.baseName = baseName;
            this.language = language;
            this.country = country;


            this.fileName = baseName + language + country;
        }

        public String getBaseName() {
            return baseName;
        }

        public void setBaseName(String baseName) {
            this.baseName = baseName;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public int compareTo(LocaleKey o) {
            return 0;
        }
    }

}
