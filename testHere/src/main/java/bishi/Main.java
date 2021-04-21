package bishi;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String[] s = new String[0];

            if (str != null && str.length() != 0) {
                s = str.split(" ");
            }
            LinkedList<Integer> list = new LinkedList<>();

            getData(s, list);

            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.print(list.get(i));
                if (i != 0) {
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
    }

    private static void getData(String[] s, LinkedList<Integer> list) {

        if (s.length == 0) {
            return;
        }

        for (int i = 0; i < s.length; i++) {
            int num = Integer.parseInt(s[i]);
            if (i == 0) {
                list.add(num);
            } else {
                check(list, num);
            }
        }

    }

    private static void check(LinkedList<Integer> list, int num) {
        int total = 0;
        int count = 0;
        for (int j = list.size() - 1; j >= 0; j--) {
            total += list.get(j);
            if (num == total) {
                list.subList(j, list.size()).clear();
                check(list, num * 2);
                count++;
                break;
            }
        }
        if (count == 0) {
            list.add(num);
        }

    }

}