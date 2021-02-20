package juc;

/**
 * @author 陈东东
 * @date 2021/2/7 13:37
 * @description 一句話描述用途
 */
public class LambdaExpressDemo {
}

@FunctionalInterface
interface Foo {

    public int add(int x, int y);

    public default void say(){
        System.out.println("hello");
    }

}