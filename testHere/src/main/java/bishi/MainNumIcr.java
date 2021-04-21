package bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainNumIcr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        while (in.hasNext()) {
            String str = in.next();

            List<Character> list = new ArrayList<>();
            List<Character> list2 = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                list.add(str.charAt(i));
                if (Character.isDigit(str.charAt(i))) {
                    list2.add(str.charAt(i));
                }
            }

            int num = len(list, list2);
            System.out.println(num);
        }
    }


    private static int len(List<Character> list, List<Character> list2) {
        if (list.size() == 0 || list2.size() == 0) {
            return 0;
        }
        int max = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            int temp = 1;
            int j = i;
            while (Character.isDigit(list.get(j + 1)) && Character.isDigit(list.get(j)) && list.get(j + 1) - list.get(j) >= 0) {
                temp++;
                j++;
                if (j == list.size() - 1) {
                    break;
                }
            }
            if (max < temp) {
                max = temp;
            }
        }
        return max;
    }


}