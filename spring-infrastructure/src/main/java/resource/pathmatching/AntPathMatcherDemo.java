package resource.pathmatching;

import java.io.File;
import org.springframework.util.AntPathMatcher;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/12/22
 */
public class AntPathMatcherDemo {

    static AntPathMatcher pathMatcher = new AntPathMatcherWithOutput(File.separator);
//    AntPathMatcher matcher = new AntPathMatcher(System.getProperty("file.separator");

    public static void main(String[] args) {

        System.out.println(System.getProperty("file.separator"));

        // test exact matching
        System.out.println("--------------------测试精确匹配！--------------------");
        pathMatcher.match("test", "test");
        pathMatcher.match("/test", "/test");
        pathMatcher.match("http://example.org", "http://example.org"); // SPR-14141
        pathMatcher.match("/test.jpg", "test.jpg");
        pathMatcher.match("test", "/test");
        pathMatcher.match("/test", "test");

        // test matching with ?'s
        System.out.println("--------------------测试?匹配！--------------------");
        pathMatcher.match("t?st", "test");
        pathMatcher.match("??st", "test");
        pathMatcher.match("tes?", "test");
        pathMatcher.match("te??", "test");
        pathMatcher.match("?es?", "test");
        pathMatcher.match("tes?", "tes");
        pathMatcher.match("tes?", "testt");
        pathMatcher.match("tes?", "tsst");

        // test matching with *'s
        System.out.println("--------------------测试*匹配！--------------------");
        pathMatcher.match("*", "test");
        pathMatcher.match("test*", "test");
        pathMatcher.match("test*", "testTest");
        pathMatcher.match("test/*", "test/Test");
        pathMatcher.match("test/*", "test/t");
        pathMatcher.match("test/*", "test/");
        pathMatcher.match("*test*", "AnothertestTest");
        pathMatcher.match("*test", "Anothertest");
        pathMatcher.match("*.*", "test.");
        pathMatcher.match("*.*", "test.test");
        pathMatcher.match("*.*", "test.test.test");
        pathMatcher.match("test*aaa", "testblaaaa");
        pathMatcher.match("test*", "tst");
        pathMatcher.match("test*", "tsttest");
        pathMatcher.match("test*", "test/");
        pathMatcher.match("test*", "test/t");
        pathMatcher.match("test/*", "test");
        pathMatcher.match("*test*", "tsttst");
        pathMatcher.match("*test", "tsttst");
        pathMatcher.match("*.*", "tsttst");
        pathMatcher.match("test*aaa", "test");
        pathMatcher.match("test*aaa", "testblaaab");

        // test matching with ?'s and /'s
        System.out.println("--------------------测试?s匹配！--------------------");
        pathMatcher.match("/?", "/a");
        pathMatcher.match("/?/a", "/a/a");
        pathMatcher.match("/a/?", "/a/b");
        pathMatcher.match("/??/a", "/aa/a");
        pathMatcher.match("/a/??", "/a/bb");
        pathMatcher.match("/?", "/a");

        // test matching with **'s
        System.out.println("--------------------测试*s匹配！--------------------");
        pathMatcher.match("/**", "/testing/testing");
        pathMatcher.match("/*/**", "/testing/testing");
        pathMatcher.match("/**/*", "/testing/testing");
        pathMatcher.match("/bla/**/bla", "/bla/testing/testing/bla");
        pathMatcher.match("/bla/**/bla", "/bla/testing/testing/bla/bla");
        pathMatcher.match("/**/test", "/bla/bla/test");
        pathMatcher.match("/bla/**/**/bla", "/bla/bla/bla/bla/bla/bla");
        pathMatcher.match("/bla*bla/test", "/blaXXXbla/test");
        pathMatcher.match("/*bla/test", "/XXXbla/test");
        pathMatcher.match("/bla*bla/test", "/blaXXXbl/test");
        pathMatcher.match("/*bla/test", "XXXblab/test");
        pathMatcher.match("/*bla/test", "XXXbl/test");

        pathMatcher.match("/????", "/bala/bla");
        pathMatcher.match("/**/*bla", "/bla/bla/bla/bbb");

        pathMatcher.match("/*bla*/**/bla/**", "/XXXblaXXXX/testing/testing/bla/testing/testing/");
        pathMatcher.match("/*bla*/**/bla/*", "/XXXblaXXXX/testing/testing/bla/testing");
        pathMatcher.match("/*bla*/**/bla/**", "/XXXblaXXXX/testing/testing/bla/testing/testing");
        pathMatcher.match("/*bla*/**/bla/**", "/XXXblaXXXX/testing/testing/bla/testing/testing.jpg");

        pathMatcher.match("*bla*/**/bla/**", "XXXblaXXXX/testing/testing/bla/testing/testing/");
        pathMatcher.match("*bla*/**/bla/*", "XXXblaXXXX/testing/testing/bla/testing");
        pathMatcher.match("*bla*/**/bla/**", "XXXblaXXXX/testing/testing/bla/testing/testing");
        pathMatcher.match("*bla*/**/bla/*", "XXXblaXXXX/testing/testing/bla/testing/testing");

        pathMatcher.match("/x/x/**/bla", "/x/x/x/");

        pathMatcher.match("/foo/bar/**", "/foo/bar");

        pathMatcher.match("", "");

        pathMatcher.match("/{bla}.*", "/testing.html");

    }


    static class AntPathMatcherWithOutput extends AntPathMatcher {

        public AntPathMatcherWithOutput(String pathSeparator) {
            super(pathSeparator);
        }

        @Override
        public boolean match(String pattern, String path) {
            boolean match = doMatch(pattern, path, true, null);
            System.out.println("pattern: " + pattern + "\t\t" + "path: " + path + "  ----->   " + (match? "匹配成功！" : "匹配失败！"));
            return match;
        }
    }

}
