package ab.dependency.injection.generic;

import org.springframework.core.ResolvableType;

import java.util.List;

/**
 * @Author ISJINHAO
 * @Date 2020/12/14 20:50
 */
public class TestResolvableType {

    public static void main(String[] args) throws NoSuchFieldException {

        ResolvableType rawResolvableType = ResolvableType.forField(ResolvableTypeDemo.class.getDeclaredField("rawList"));
        ResolvableType specificResolvableType = ResolvableType.forField(ResolvableTypeDemo.class.getDeclaredField("specificList"));

        System.out.println(rawResolvableType.hasUnresolvableGenerics());
        System.out.println(specificResolvableType.hasUnresolvableGenerics());

    }

}
class ResolvableTypeDemo {
    private List rawList;
    private List<String> specificList;
}