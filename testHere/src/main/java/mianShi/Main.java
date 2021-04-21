package mianShi;

/**
 * 题目：在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * <p>
 * 示例:
 * 输入:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 输出: 4
 */
public class Main {
    public static void main(String[] args) {
        int[][] arr = {{1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}};
        int a = getNum(arr);
        System.out.println(a);
    }

    private static int getNum(int[][] arr) {
        int count = 0;
        int x = arr.length;
        int y = arr[1].length;

        int size = Math.min(x, y);
        while (size > 1) {
            int temp = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (arr[i][j] == 0) {
                       temp = 1;
                    }
                }
            }
            if (temp != 1) {
                count = Math.max(count, size * size);
            }

            size--;
        }

        return count;
    }


}


