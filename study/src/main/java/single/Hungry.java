package single;

/**
 * @author 陈东东
 * @date 2021/1/10 16:01
 * @description 饿汉模式
 */
public class Hungry {

    private Hungry(){}

    private final static  Hungry HUNGRY = new Hungry();

    private static Hungry getInstance() {
        return HUNGRY;
    }

}
