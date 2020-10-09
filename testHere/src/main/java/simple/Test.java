package simple;

/**
 * @author 陈东东
 * @date 2020/10/9 13:53
 * @description 一句話描述用途
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            System.out.println("i------    " + i);
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (j == 2){
                    count++;
                    continue;
                }
                System.out.println("     j------    " + j);
            }
//            if (count != 0) {
//                continue;
//            }
//            System.out.println("count ****" + count);
        }
    }
}
