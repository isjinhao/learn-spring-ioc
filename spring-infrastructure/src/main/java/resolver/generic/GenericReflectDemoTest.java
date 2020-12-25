package resolver.generic;

import org.springframework.core.ResolvableType;
import sun.reflect.generics.reflectiveObjects.GenericArrayTypeImpl;

import java.lang.reflect.*;
import java.util.List;
import java.util.Map;

public class GenericReflectDemoTest {

    public static <T, K extends Comparable<Number> & Cloneable> Map<T, K[]> test(
            GenericReflectDemoTest p1,
            List<GenericReflectDemoTest> p2,
            Map<String, GenericReflectDemoTest> p3,
            List<String>[] p4,
            Map<String, GenericReflectDemoTest>[] p5,
            List<? extends Comparable> p6,
            Map<? extends Number, ? super GenericReflectDemoTest> p7,
            T p8,
            K p9 ) {
        return null;
    }

    private static void showUsingSpring(Method method) {

        // 简化开发
        ResolvableType resolvableTypeMethod = ResolvableType.forMethodParameter(method, 2);
        ResolvableType resolvableType1 = resolvableTypeMethod.asMap();
        System.out.println(resolvableType1.resolveGeneric(0));
        System.out.println(resolvableType1.resolveGeneric(1));

        // 复杂情景还是得调用JDK的方法
        ResolvableType resolvableTypeReturn = ResolvableType.forMethodReturnType(method);
        System.out.println(resolvableTypeReturn.getRawClass());

        ResolvableType generic1 = resolvableTypeReturn.getGenerics()[0];  // T
        ResolvableType generic2 = resolvableTypeReturn.getGenerics()[1];  // K[]

        TypeVariable type = (TypeVariable) generic1.getType();   // 获取原始的T
        System.out.println(type);

        ResolvableType componentType = generic2.getComponentType();  // 获取数组的组件类型
        TypeVariable parameterizedType = (TypeVariable) componentType.getType();     // 获取原始的K
        System.out.println(parameterizedType);
        for (Type bound : parameterizedType.getBounds()) {
            System.out.println(bound);
        }

    }

    private static void showUsingOriginal(Method testMethod) {

        System.out.println("\n以下是第一个参数：----------------------------------");

        Type[] types = testMethod.getGenericParameterTypes();
        // 第一个参数，TestReflect
        Class type0 = (Class) types[0];
        // class jdkclass.reflect.TestReflect
        System.out.println("type0: " + type0.getName());

        System.out.println("\n以下是第二个参数：----------------------------------");
        // 第二个参数，List<TestReflect>
        Type type1 = types[1];
        Type rawType1 = ((ParameterizedType) type1).getRawType();    // 原始类型
        Type ownerType = ((ParameterizedType) type1).getOwnerType();
        // 返回类型所属的类型，例如A<T>里定义了内部类InnerA<T>，则InnerA<T>所属的类型是A<T>，如果是顶层则返回null。
        System.out.println(ownerType);    // null

        System.out.println("rawType  " + rawType1);        // interface java.util.List
        Type[] parameterizedType1 = ((ParameterizedType) type1).getActualTypeArguments();
        Class parameterizedType1_0 = (Class) parameterizedType1[0];    // 泛型类型
        System.out.println("parameterizedType1_0: " + parameterizedType1_0); // class jdkclass.reflect.TestReflect

        System.out.println("\n以下是第三个参数：----------------------------------");
        // 第三个参数，Map<String, TestReflect>
        Type type2 = types[2];
        Type rawType = ((ParameterizedType) type2).getRawType();    // 原始类型
        System.out.println("rawType    " + rawType);
        Type[] parameterizedType2 = ((ParameterizedType) type2).getActualTypeArguments();
        Class parameterizedType2_0 = (Class) parameterizedType2[0];
        System.out.println("parameterizedType2_0: " + parameterizedType2_0); // class java.lang.String
        Class parameterizedType2_1 = (Class) parameterizedType2[1];
        System.out.println("parameterizedType2_1: " + parameterizedType2_1); // class jdkclass.reflect.TestReflect

        System.out.println("\n以下是第四个参数：----------------------------------");
        // 第四个参数，List<String>[]
        Type type3 = types[3];
        // 获得数组的元素类型
        Type genericArrayType3 = ((GenericArrayType) type3).getGenericComponentType();
        ParameterizedType parameterizedType3 = (ParameterizedType) genericArrayType3;
        Type[] parameterizedType3Arr = parameterizedType3.getActualTypeArguments();
        Class class3 = (Class) parameterizedType3Arr[0];
        System.out.println("class3:" + class3); // java.lang.String

        System.out.println("\n以下是第五个参数：----------------------------------");
        // 第五个参数，Map<String, TestReflect>[]
        Type type4 = types[4];
        // 获得数组的元素类型
        Type genericArrayType4 = ((GenericArrayType) type4).getGenericComponentType();
        ParameterizedType parameterizedType4 = (ParameterizedType) genericArrayType4;
        Type[] parameterizedType4Arr = parameterizedType4.getActualTypeArguments();
        Class class4_0 = (Class) parameterizedType4Arr[0];
        System.out.println("class4_0:" + class4_0);  // class java.lang.String
        Class class4_1 = (Class) parameterizedType4Arr[1];
        System.out.println("class4_1:" + class4_1);  // class jdkclass.reflect.TestReflect

        System.out.println("\n以下是第六个参数：----------------------------------");
        // 第六个参数，List<? extends Comparable>
        Type type5 = types[5];
        Type[] parameterizedType5 = ((ParameterizedType) type5).getActualTypeArguments();
        Type[] parameterizedType5_0_upper = ((WildcardType) parameterizedType5[0]).getUpperBounds();    // 上界
        Type[] parameterizedType5_0_lower = ((WildcardType) parameterizedType5[0]).getLowerBounds();    // 下界
        for (Type type : parameterizedType5_0_upper) {
            System.out.println(type);    // interface java.lang.Comparable
        }
        System.out.println("*******************");
        for (Type type : parameterizedType5_0_lower) {
            System.out.println(type);    // 不输出任何信息
        }

        System.out.println("\n以下是第七个参数：----------------------------------");
        // 第七个参数，Map<? extends Number, ? super TestReflect> p6
        Type type6 = types[6];
        Type[] parameterizedType6 = ((ParameterizedType) type6).getActualTypeArguments();
        Type[] parameterizedType6_0_upper = ((WildcardType) parameterizedType6[0]).getUpperBounds();
        Type[] parameterizedType6_0_lower = ((WildcardType) parameterizedType6[0]).getLowerBounds();
        Type[] parameterizedType6_1_upper = ((WildcardType) parameterizedType6[1]).getUpperBounds();
        Type[] parameterizedType6_1_lower = ((WildcardType) parameterizedType6[1]).getLowerBounds();
        for (Type type : parameterizedType6_0_upper) {
            System.out.println(type);    // class java.lang.Number
        }
        System.out.println("*******************");
        for (Type type : parameterizedType6_0_lower) {
            System.out.println(type);    // 不输出任何信息
        }
        System.out.println("*******************");
        for (Type type : parameterizedType6_1_upper) {
            System.out.println(type);    // class java.lang.Object
        }
        System.out.println("*******************");
        for (Type type : parameterizedType6_1_lower) {
            System.out.println(type);    // class jdkclass.reflect.TestReflect
        }

        System.out.println("\n以下是第八个参数：----------------------------------");
        TypeVariable type7 = (TypeVariable) types[7];
        System.out.println(type7);    // T
        System.out.println(type7.getGenericDeclaration());
        // public static void jdkclass.reflect.TestReflect.test(jdkclass.reflect.TestReflect,java.util.List,java.util.Map,
        // java.util.List[],java.util.Map[],java.util.List,java.util.Map,java.lang.Object,java.lang.Comparable)

        System.out.println("\n以下是第九个参数：----------------------------------");
        TypeVariable type8 = (TypeVariable) types[8];
        System.out.println(type8);    // K
        Type[] bounds = type8.getBounds();
        for (Type t : bounds) {
            System.out.println(t);
            // java.lang.Comparable<java.lang.Number>
            // interface java.lang.Cloneable
        }

        System.out.println("\n以下是返回值类型：----------------------------------");
        Type genericReturnType = testMethod.getGenericReturnType();

        Type[] actualReturnTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();

        System.out.println(actualReturnTypeArguments[0]);   // T
        System.out.println(actualReturnTypeArguments[1]);   // K[]

        Type bounds1 = ((GenericArrayTypeImpl) actualReturnTypeArguments[1]).getGenericComponentType();
        System.out.println(bounds1);    // K

        Type[] bounds2 = ((TypeVariable) bounds1).getBounds();
        for (Type t : bounds2) {
            System.out.println(t);
            // java.lang.Comparable<java.lang.Number>
            // interface java.lang.Cloneable
        }

        ParameterizedType type9 = (ParameterizedType) bounds2[0];
        System.out.println(type9.getRawType()); // interface java.lang.Comparable
        System.out.println(type9.getActualTypeArguments()[0]);  // class java.lang.Number
    }

    public static void main(String[] args) {
        Method[] methods = GenericReflectDemoTest.class.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method testMethod = methods[i];
            if (testMethod.getName().equals("test")) {
                showUsingSpring(testMethod);
                showUsingOriginal(testMethod);
            }
        }
    }
}