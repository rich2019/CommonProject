/**
 * @author 陈东东
 * @date 2021/1/11 16:45
 * @description 一句話描述用途
 */
public class Test {


    public static void main(String[] args) {
        String s = new String("abc");
        change(s);
        System.out.println(s);
    }

    public static void change(String a) {
        a = "efg";
    }
}

