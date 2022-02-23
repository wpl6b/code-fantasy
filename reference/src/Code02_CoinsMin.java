import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Code02_CoinsMin {

    public static int minCoins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        return process(arr, 0, aim);
    }

    // 当前考虑的面值是arr[i]，还剩rest的钱需要找零
    // 如果返回-1说明自由使用arr[i..N-1]面值的情况下，无论如何也无法找零rest
    // 如果返回不是-1，代表自由使用arr[i..N-1]面值的情况下，找零rest需要的最少张数
    public static int process(int[] arr, int i, int rest) {
        // base case：
        // 已经没有面值能够考虑了
        // 如果此时剩余的钱为0，返回0张
        // 如果此时剩余的钱不是0，返回-1
        if (i == arr.length) {
            return rest == 0 ? 0 : -1;
        }
        // 最少张数，初始时为-1，因为还没找到有效解
        int res = -1;
        // 依次尝试使用当前面值(arr[i])0张、1张、k张，但不能超过rest
        for (int k = 0; k * arr[i] <= rest; k++) {
            // 使用了k张arr[i]，剩下的钱为rest - k * arr[i]
            // 交给剩下的面值去搞定(arr[i+1..N-1])
            int next = process(arr, i + 1, rest - k * arr[i]);
            if (next != -1) { // 说明这个后续过程有效
                res = res == -1 ? next + k : Math.min(res, next + k);
            }
        }
        return res;
    }

    public static int minCoins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        // 设置最后一排的值，除了dp[N][0]为0之外，其他都是-1
        for (int col = 1; col <= aim; col++) {
            dp[N][col] = -1;
        }
        for (int i = N - 1; i >= 0; i--) { // 从底往上计算每一行
            for (int rest = 0; rest <= aim; rest++) { // 每一行都从左往右
                dp[i][rest] = -1; // 初始时先设置dp[i][rest]的值无效
                if (dp[i + 1][rest] != -1) { // 下面的值如果有效
                    dp[i][rest] = dp[i + 1][rest]; // dp[i][rest]的值先设置成下面的值
                }
                // 左边的位置不越界并且有效
                if (rest - arr[i] >= 0 && dp[i][rest - arr[i]] != -1) {
                    if (dp[i][rest] == -1) { // 如果之前下面的值无效
                        dp[i][rest] = dp[i][rest - arr[i]] + 1;
                    } else { // 说明下面和左边的值都有效，取最小的
                        dp[i][rest] = Math.min(dp[i][rest],
                                dp[i][rest - arr[i]] + 1);
                    }
                }
            }
        }

//        for (int i = 0; i <= arr.length; i++) {
//            for (int j = 0; j <= aim; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        return dp[0][aim];
    }

    // for test
    public static int[] generateRandomArray(int len, int max) {
        int[] arr = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max) + 1;
        }
        return arr;
    }

    public static void main(String[] args) {
//        int len = 10;
//        int max = 10;
//        int testTime = 10000;
//        for (int i = 0; i < testTime; i++) {
//            int[] arr = generateRandomArray(len, max);
//            int aim = (int) (Math.random() * 3 * max) + max;
//            System.out.println("aim: " + aim);
//            int a = coinWay(arr, aim);
//            int b = coinWayDP(arr, aim);
//            System.out.println("coinWay: " + a + "     coinWayDP: " + b);
//            if (a != b) {
//                System.out.println("ooops!");
//                break;
//            }
//        }


//        System.out.println(minCoins2(new int[]{2, 3, 5, 7, 2}, 10));
//        System.out.println(coinNumSearch(new int[]{2, 3, 5, 7, 2}, 10));
//        System.out.println(coinNumDP(new int[]{2, 3, 5, 7, 2}, 10));

//        System.out.println(processdp(0, 3, 6, new int[][]{{2,1,2,3,3},{2,2,4,1,3},{2,3,2,2,1}}));
//        System.out.println(test(3, 6, new int[][]{{2,1,2,3,3},{2,2,4,1,3},{2,3,2,2,1}}));

    }


    //改记忆化搜索
    public static int coinNumSearch(int[] coins, int target) {
        int[][] dp = new int[coins.length + 1][target + 1];
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -2;
            }
        }
        int res = selectCoinNumSearch(coins, target, 0, dp);
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= target; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return res;
    }

    public static int selectCoinNumSearch(int[] coins, int target, int i, int[][] dp) {

        if (target < 0) return -1;
        if(dp[i][target] != -2)  return dp[i][target];


        if (i == coins.length){
            dp[i][target] = -1;
            return dp[i][target];
        }
        if (target == 0) {
            dp[i][target] = 0;
            return dp[i][target];
        }



//        int select = selectCoinNumSearch(coins, target - coins[i], i + 1, dp);
//        int notSelect = selectCoinNumSearch(coins, target, i + 1, dp);
        int select = target - coins[i] >= 0 ? (dp[i+1][target - coins[i]] == -2 ? selectCoinNumSearch(coins, target - coins[i], i + 1, dp): dp[i+1][target - coins[i]]) : -1;
        int notSelect = dp[i+1][target] == -2 ? selectCoinNumSearch(coins, target, i + 1, dp) : dp[i+1][target];
        if (select == -1 && notSelect == -1) {
            dp[i][target] = -1;
        } else if (select == -1) {
            dp[i][target] = notSelect;
        } else if (notSelect == -1) {
            dp[i][target] =  select + 1;
        } else {
            dp[i][target] = Math.min(select + 1, notSelect);
        }

        return dp[i][target];

    }
    //改dp
    public static int coinNumDP(int[] coins, int target){
        int row = coins.length;     //行最大下标
        int col = target;           //列最大下标
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i <= row; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= col; j++) {
            dp[row][j] = -1;
        }



        for (int i = row - 1; i >= 0 ; i--) {
            for (int j = 1; j <= col; j++) {
                int select = j - coins[i] >= 0 ? dp[i+1][j - coins[i]] : -1;
                int notSelect = dp[i+1][j];
                if(select == -1 && notSelect == -1)      dp[i][j] = -1;
                else {
                    if(select == -1)    dp[i][j] = notSelect;
                    else if (notSelect == -1)   dp[i][j] = select + 1;
                    else dp[i][j] = Math.min(select + 1, notSelect);
                }
            }
        }


        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= target; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[0][target];
    }


    //改记忆化搜索
    public static int coinChangeSearch(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = -2;
            }
        }

        int res = selectMinCoinsSearch(coins, amount, 0, dp);
//        for (int i = 0; i <= coins.length; i++) {
//            for (int j = 0; j <= amount; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        return res;
    }

    public static int selectMinCoinsSearch(int[] coins, int amount, int i, int[][] dp) {
        if (amount < 0) return -1;
        if(dp[i][amount] != -2) return dp[i][amount];

        if (amount == 0) {
            dp[i][amount] = 0;
            return 0;
        }
        //交换上下  会影响最终结果（当表 左下角初始化为 0时才能得到正确结果 初始化为-1时 错）   为什么？？？
        if(i >= coins.length){
            dp[i][amount] = -1;
            return -1;
        }



        int res = Integer.MAX_VALUE;
        int flag = 0;
        for (int j = amount / coins[i]; j >= 0 ; j--) {
//            int tmp = selectMinCoins(coins, amount - j * coins[i], i + 1);
            int tmp = amount - j * coins[i] >= 0 ? (dp[i+1][amount - j * coins[i]] == -2 ? selectMinCoinsSearch(coins, amount - j * coins[i], i + 1, dp) : dp[i+1][amount - j * coins[i]]) : -1;

            if(tmp != -1){
                flag = 1;
                res = Math.min(res , tmp + j);

            }

            if(flag == 0){
                dp[i][amount] = -1;
            }else dp[i][amount] = res;
        }


        return dp[i][amount];
    }

    //改dp
    public static int coinChangeDP(int[] coins, int amount) {



        int row = coins.length;     //行最大下标
        int col = amount;           //列最大下标
        int[][] dp = new int[row + 1][col + 1];

        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = -2;
            }
        }

        for (int j = 0; j <= col; j++) {
            dp[row][j] = -1;
        }
        for (int i = 0; i <= row; i++) {
            dp[i][0] = 0;
        }




        for (int i = row - 1; i >= 0; i--) {
            for (int j = 1; j <= col; j++) {
                int res = Integer.MAX_VALUE;
                int flag = 0;

                for (int k = j / coins[i]; k >= 0; k--) {
                    int tmp = j - k * coins[i] >= 0 ? dp[i+1][j - k * coins[i]] : -1;
                    if(tmp != -1){
                        flag = 1;
                        res = Math.min(res, tmp + k);
                    }
                }

                if(flag == 0){
                    dp[i][j] = -1;
                }else dp[i][j] = res;


            }
        }

//        for (int i = 0; i <= row; i++) {
//            for (int j = 0; j <= col; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        return  dp[0][amount];

    }


    public static int coinWay(int[] coins, int amount) {
        return selectCoinWay(coins, amount, 0);
    }

    public static int selectCoinWay(int[] coins, int amount, int i) {
        if (i == coins.length) return amount == 0 ? 1 : 0;
        int way = 0;
        for (int zhang = 0; zhang <= amount / coins[i]; zhang++) {
            way += selectCoinWay(coins, amount - zhang * coins[i], i + 1);
        }

        return way;
    }

    //改DP
    public static int coinWayDP(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[coins.length][0] = 1;

        for (int row = coins.length - 1; row >= 0; row--) {
            for (int col = amount; col >= 0; col--) {
                for (int zhang = 0; zhang <= col / coins[row]; zhang++) {
                    dp[row][col] += dp[row + 1][col - zhang*coins[row]];
                }
            }
        }

        return dp[0][amount];
    }







}
