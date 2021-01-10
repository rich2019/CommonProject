package single;

/**
 * @author 陈东东
 * @date 2021/1/10 16:09
 * @description 懒汉模式
 */
public class LazyMan {

    private LazyMan() {
        System.out.println(Thread.currentThread().getName() + "----ok");
    }

    private static LazyMan LAZY_MAN;

    public static LazyMan getInstance() {
        if (LAZY_MAN == null) {
            LAZY_MAN = new LazyMan();
        }
        return LAZY_MAN;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> LazyMan.getInstance()).start();
        }
    }


}
