package bishi;

/**
 * @author 陈东东
 * @date 2021/3/26 9:13
 * @description 一句話描述用途
 */
public class Dynamic {
    public static void main(String[] args) {
        //商品的体积2、3、4、5
        int[] w = {0, 2, 3, 5, 4};
        //商品的价值3、4、5、6
        int[] v = {0, 3, 4, 6, 5};
        //背包大小
        int bagV = 8;
        //动态规划表
        int[][] dp = new int[5][9];

        for (int i = 1; i < w.length; i++) {
            for (int j = 1; j <= bagV; j++) {
                if (j < w[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        //动态规划表的输出
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }


    }
}
