import sun.net.idn.Punycode;

import java.sql.SQLOutput;
import java.util.*;

/**
 * *******************************  DP表和 search表 是不一样的！！！！！！！！  *******************************
 * P10 补充视频  36Min
 */
public class DPquestion {
    public static void main(String[] args) {

//        sub("abc");
//        hanoi("左", "右", "中", 3);
//        System.out.println("a" + ch + "b");
//        sub("abc");
//        permutation("aba");
//        permute(new int[]{1,2,3});

//        System.out.println(maxScore(new int[]{53,14,91,35,51,9,80,27,6,15,77,86,34,62,55,45,91,45,23,75,66,42,62,13,34,18,89,67,93,83,100,14,92,73,48,2,47,93,99,100,88,84,48}, 43));
//        System.out.println(maxScore(new int[]{1,79,80,1,1,1,200,1}, 3));
//        Stack<Integer> st = new Stack<>();
//        st.add(3);
//        st.add(2);
//        st.add(1);
//        reverseStack(st);
//        System.out.println(st.pop());
//        System.out.println(st.pop());
//        System.out.println(st.pop());
//        System.out.println((char)('A' + 25));
//        System.out.println(nums2Alphabet(new int[]{1,2,3}));
//        System.out.println(beibao(new int[]{1,2,3,4}, new int[]{2,4,4,5}, 5));
//        System.out.println(queen(8));
//        System.out.println(queenNew(8));
//        System.out.println(robot(10, 1, 3, 10));
//        System.out.println(robotSearch(10, 1, 3, 10));
//        System.out.println(robotDP(10, 1, 3, 10));
//        System.out.println(canJump(new int[]{2,0,0}));
//        System.out.println(coinNum(new int[]{2, 3, 5, 7, 2}, 10));
//        System.out.println(coinNumSearch(new int[]{2, 3, 5, 7, 2}, 10));
//        System.out.println(coinNumDP(new int[]{2, 3, 5, 7, 2}, 10));
//        System.out.println(coinChange(new int[]{1,2,5}, 11));
//        System.out.println(coinChange(new int[]{2}, 3));
//        System.out.println(coinChangeSearch(new int[]{1,2,5}, 11));
//        System.out.println(coinChangeSearch(new int[]{2}, 3));

//        System.out.println(coinChangeDP(new int[]{1,2,5}, 11));
//        System.out.println(coinChangeDP(new int[]{2}, 3));
//
//        System.out.println(boyi(new int[]{3, 100, 4, 50}));
//        System.out.println(boyiDP(new int[]{3, 100, 4, 50}));

//        System.out.println(horseK(8,8, 10));
//        System.out.println(horseDP(8,8, 10));
//        System.out.println(knightProbability(3, 2, 0, 0));
//        System.out.println(knightProbabilityDP(3, 2, 0, 0));
        System.out.println(coinWay(new int[]{3,5,10,1}, 1000));
        System.out.println(coinWayDP(new int[]{3,5,10,1}, 1000));

    }


    public static void hanoi(String a, String b, String c, int cnt) {
        if (cnt == 1) {
            System.out.println(a + " -----> " + b);
            return;
        } else {

            hanoi(a, c, b, cnt - 1);
            System.out.println(a + " -----> " + b);
            hanoi(c, b, a, cnt - 1);
        }
    }


    /**
     * 1、求字符串的所有子序列
     *
     * @param str
     */
    public static void sub(String str) {
        ArrayList<Character> res = new ArrayList<>();
        if (str == null || str.length() == 0) return;

//        process0(str.toCharArray(), 0, res);
        process1(str.toCharArray(), 0);
    }

    /**
     * process含义从第n个字符起要或者不要
     *
     * @param strs
     * @param n
     * @param res
     */
    public static void process0(char[] strs, int n, List<Character> res) {
        if (n == strs.length) {
            res.forEach(System.out::print);
            System.out.println();
            return;
        }

        ArrayList<Character> tmp = new ArrayList<>(res);
        tmp.add(strs[n]);
        process0(strs, n + 1, tmp);
        process0(strs, n + 1, res);

    }

    public static void process1(char[] strs, int n) {

        if (n == strs.length) {
//            for (int i = 0; i < strs.length; i++) {
//                if(strs[i] != 0)   System.out.print(strs[i]);
//            }
//            System.out.println();
            System.out.println(String.valueOf(strs).replace(" ", ""));
            return;
        }

        char ch = strs[n];

        strs[n] = ' ';
        process1(strs, n + 1);

        strs[n] = ch;
        process1(strs, n + 1);

    }

    /**
     * 2、求字符串的全排列    "abc"
     * <p>
     * 进阶：要求不重复    "aba"           -----------分支限界----------
     */
    public static ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) return res;

        process2(str.toCharArray(), 0, res);
        res.forEach(System.out::println);
        return res;
    }

    /**
     * process含义 前i-1个字符已经确定, 在第i个位置尝试 i至末尾的每一个字符
     *
     * @param strs
     * @param i
     * @param res
     */
    public static void process2(char[] strs, int i, ArrayList<String> res) {

        if (i == strs.length) res.add(String.valueOf(strs));

        boolean visit[] = new boolean[26];  //记录第j个位置的字符是否在第i个位置上尝试过
        for (int j = i; j < strs.length; j++) {
            if (!visit[strs[j] - 'a']) {    //尝试过 则跳过
                visit[strs[j] - 'a'] = true;
                swap(strs, i, j);
                process2(strs, i + 1, res);
                swap(strs, i, j);
            }
        }
    }

    public static void swap(char[] strs, int i, int j) {
        char ch = strs[i];
        strs[i] = strs[j];
        strs[j] = ch;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * Exercise
     * leetcode 46. 全排列
     */
    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        process(nums, 0, res);
        return res;
    }

    public static void process(int[] nums, int i, List<List<Integer>> res) {
        if (i == nums.length) res.add(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)));
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            process(nums, i + 1, res);
            swap(nums, i, j);
        }

    }

    /**
     * 3、先后手游戏
     *
     * @param arr
     * @return
     */
    public static int boyi(int[] arr) {
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    public static int f(int[] arr, int l, int r) {
        if (l == r) return arr[l];
        return Math.max(arr[l] + s(arr, l + 1, r), arr[r] + s(arr, l, r - 1));
    }

    public static int s(int[] arr, int l, int r) {
        if (l == r) return 0;
        return Math.min(f(arr, l + 1, r), f(arr, l, r - 1));
    }

    public static int boyiDP(int[] arr) {
        int[][] dpf = new int[arr.length][arr.length];
        int[][] dps = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {

            dpf[i][i] = arr[i];

        }

        for (int i = 1; i < dpf.length; i++) {
            int row = 0;
            int col = i;
            while (col < dpf.length) {
                dpf[row][col] = Math.max(arr[row] + dps[row + 1][col], arr[col] + dps[row][col - 1]);
                dps[row][col] = Math.min(dpf[row + 1][col], dpf[row][col - 1]);
                row++;
                col++;
            }
        }

        return Math.max(dpf[0][arr.length - 1], dps[0][arr.length - 1]);
    }


    /**
     * Exercise
     * leetcode 1423. 可获得的最大点数                     超时
     *
     * @param cardPoints
     * @param k
     * @return
     */
    public static int maxScore(int[] cardPoints, int k) {
        return fetch(cardPoints, 0, cardPoints.length - 1, k, 0);
    }

    public static int fetch(int[] arr, int l, int r, int k, int cnt) {
        cnt++;
        if (cnt == k) return Math.max(arr[l], arr[r]);
        return Math.max(arr[l] + fetch(arr, l + 1, r, k, cnt), arr[r] + fetch(arr, l, r - 1, k, cnt));
    }


    /**
     * 4、不使用额外数据结构 逆序栈
     *
     * @param stack
     */
    public static void reverseStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int bottom = f(stack);
            reverseStack(stack);
            stack.add(bottom);
        } else return;


    }


    /**
     * f作用：移除栈底元素并返回
     *
     * @param stack
     * @return
     */
    public static int f(Stack<Integer> stack) {
        int maybeBottom = stack.pop();  //弹出栈顶元素 该元素可能是栈底元素
        if (!stack.isEmpty()) {  //不是栈底元素则 继续做f操作 直到弹出栈底元素
            int realBottom = f(stack);
            stack.push(maybeBottom);
            return realBottom;
        } else {     //是栈底元素则之间返回
            return maybeBottom;
        }
    }


    /**
     * 5、 数字数组--->字母串
     *
     * @param nums
     * @return
     */
    public static List<String> nums2Alphabet(int[] nums) {
        ArrayList<String> res = new ArrayList<>();
        process3(nums, 0, "", res);
//        res.forEach(System.out::println);
        return res;
    }

    /**
     * process 含义：携带i位置之前已经形成的字母串before    所有可能结果存在res中
     * 测试  123---> [ABC, AW, LC]
     *
     * @param nums
     * @param i
     * @param before
     * @param res
     */
    public static void process3(int[] nums, int i, String before, List<String> res) {
        if (i >= nums.length) {
            res.add(before);
            return;
        }

        if (nums[i] == 0) return;

        if (nums[i] == 1) {
            process3(nums, i + 1, before + 'A', res);
            process3(nums, i + 2, before + (char) ('A' + nums[i] * 10 + nums[i + 1] - 1), res);
            return;
        }

        if (nums[i] == 2) {
            process3(nums, i + 1, before + 'B', res);
            if (nums[i + 1] <= 6) {
                process3(nums, i + 2, before + (char) ('A' + nums[i] * 10 + nums[i + 1] - 1), res);
            }
            return;
        }

        process3(nums, i + 1, before + (char) ('A' + nums[i] - 1), res);
    }


    /**
     * 6、背包问题
     *
     * @param weights
     * @param values
     * @param bag
     * @return
     */
    public static int beibao(int[] weights, int[] values, int bag) {
        return process4(weights, values, bag, 0);
    }

    public static int process4(int[] weights, int[] values, int bag, int i) {
        if (i == weights.length) return 0;
        if (bag - weights[i] >= 0) {
            return Math.max(values[i] + process4(weights, values, bag - weights[i], i + 1),
                    process4(weights, values, bag, i + 1));
        } else return 0;
    }

    /**
     * 7、N皇后
     *
     * @param n
     * @return
     */
    public static int queen(int n) {
        if (n < 1) return 0;
        int[] record = new int[n];  //记录i行皇后所在的列
        return deployQueen(record, n, 0);   //从0行皇后开始点
    }

    /**
     * deployQueen含义：点i行皇后
     *
     * @param record
     * @param n
     * @param i
     * @return
     */
    public static int deployQueen(int[] record, int n, int i) {

        if (i == n) return 1;

        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValidPoint(record, i, j)) {
                record[i] = j;
                res += deployQueen(record, n, i + 1);
            }
        }

        return res;

    }

    public static boolean isValidPoint(int[] record, int i, int col) { //判断i行皇后在col列是否是可选列

        for (int j = 0; j < i; j++) {
            if (record[j] == col || Math.abs(record[j] - col) == Math.abs(j - i)) return false;
        }

        return true;

    }

    public static int queenNew(int n) {
        if (n > 32) return -1;
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return deployQueenNew(limit, 0, 0, 0);
    }

    public static int deployQueenNew(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) return 1;

        int res = 0;
        int pos = limit & ~(colLim | leftDiaLim | rightDiaLim);
        int mr = 0;
        while (pos != 0) {
            mr = pos & (~pos + 1);
            res += deployQueenNew(limit, colLim | mr, (leftDiaLim | mr) << 1, (rightDiaLim | mr) >> 1);
            pos -= mr;
        }

        return res;
    }

    //***************************************************暴力递归提升****************************************************
    //                                                      P16

    /**
     * 1、机器人在s位置开始走k步 到e位置  有多少种方法     PS：可走位置为 1 ~ n
     *
     * @param n
     * @param s
     * @param e
     * @param k
     * @return
     */
    public static int robot(int n, int s, int e, int k) {
        if (k == 0) {
            if (s == e) return 1;
            else return 0;
        }

        int res = 0;
        if (s - 1 >= 1) res += robot(n, s - 1, e, k - 1);
        if (s + 1 <= n) res += robot(n, s + 1, e, k - 1);

        return res;
    }

    public static int robotSearch(int n, int s, int e, int k) {
        int[][] dp = new int[n + 1][k + 1];
        return process5(n, s, e, k, dp);
    }

    public static int process5(int n, int s, int e, int k, int[][] dp) {
        if (dp[s][k] != 0) return dp[s][k];
        if (k == 0) {
            dp[s][k] = s == e ? 1 : 0;
            return dp[s][k];
        }

        int res = 0;
        if (s - 1 >= 1) {
            if (dp[s - 1][k - 1] == 0) {
                dp[s - 1][k - 1] = robot(n, s - 1, e, k - 1);
            }
            res += dp[s - 1][k - 1];
        }
        if (s + 1 <= n) {
            if (dp[s + 1][k - 1] == 0) {
                dp[s + 1][k - 1] = robot(n, s + 1, e, k - 1);
            }
            res += dp[s + 1][k - 1];
        }

        return res;

    }

    public static int robotDP(int n, int s, int e, int k) {
        int[][] dp = new int[n + 1][k + 1];
        dp[e][0] = 1;

//        for (int i = 1; i <= n ; i++) {
//            for (int j = 1; j <= k ; j++) {
//                if(i == 1 ){
//                    dp[i][j] = dp[2][j-1];
//                }
//                else if(i == n ){
//                    dp[i][j] = dp[n-1][j-1];
//                }else {
//                    dp[i][j] = dp[i-1][j-1] + dp[i+1][j - 1];
//                }
//            }
//        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == 1) {
                    dp[j][i] = dp[2][i - 1];
                } else if (j == n) {
                    dp[j][i] = dp[n - 1][i - 1];
                } else {
                    dp[j][i] = dp[j - 1][i - 1] + dp[j + 1][i - 1];
                }
            }

        }

//        for (int i = 0; i < n + 1; i++) {
//            for (int j = 0; j < k + 1; j++) {
//                System.out.print(dp[i][j]);
//            }
//            System.out.println();
//        }

        return dp[s][k];
    }

    /**
     * Exercise leetcode.55  超时
     * 正确做法：贪心
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {

        int farthest = 0;
        for (int i = 0; i <= farthest && i < nums.length; i++) {
            if (i + nums[i] > farthest) farthest = i + nums[i];
        }
        return farthest >= nums.length - 1;
//        return process(nums, 0);
//        return processSearch(nums, 0, new boolean[nums.length]);
    }

    public static boolean process(int[] nums, int i) {
        if (i + nums[i] >= nums.length - 1) return true;
        for (int j = 1; j <= nums[i]; j++) {
            if (process(nums, i + j)) return true;
        }
        return false;
    }

//    //错！ 改记忆化搜索失败
//    public boolean processSearch(int[] nums, int i, boolean[] dp) {
//        if(i >= nums.length)    return false;
//        if(dp[i])   return true;
//
//        if (i + nums[i] >= nums.length - 1) {
//            dp[i] = true;
//        }
//        for (int j = 1; j <= nums[i]; j++) {
//            if(i + j < nums.length && dp[i + j])   return true;
//            if (processSearch(nums, i + j, dp)){
//                dp[i] = true;
//                return true;
//            }
//        }
//        return dp[i];
//    }


    /**
     * 2、凑零钱    每个面值对应只有一张  返回凑出amount的方法数
     *
     * @param coins
     * @param target
     * @return
     */
    public static int coinKind(int[] coins, int target) {
        return selectCoinKind(coins, target, 0);
    }

    public static int selectCoinKind(int[] coins, int target, int i) {
        if (i >= coins.length && target != 0) return 0;
        if (target == 0) return 1;

        return selectCoinKind(coins, target - coins[i], i + 1) +
                selectCoinKind(coins, target, i + 1);
    }

    /**
     * 2、凑零钱   每个面值对应只有一张  返回凑出amount的最少硬币数量
     *
     * @param coins
     * @param target
     * @return
     */
    public static int coinNum(int[] coins, int target) {
        return selectCoinNum(coins, target, 0);
    }

    public static int selectCoinNum(int[] coins, int target, int i) {
        if (target < 0) return -1;
        if (target == 0) return 0;
        if (i >= coins.length) return -1;

        int select = selectCoinNum(coins, target - coins[i], i + 1);
        int notSelect = selectCoinNum(coins, target, i + 1);
        if (select == -1 && notSelect == -1) {
            return -1;
        } else if (select == -1) {
            return notSelect;
        } else if (notSelect == -1) {
            return select + 1;
        } else {
            return Math.min(select + 1, notSelect);
        }

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
        if (dp[i][target] != -2) return dp[i][target];


        if (i == coins.length) {
            dp[i][target] = -1;
            return dp[i][target];
        }
        if (target == 0) {
            dp[i][target] = 0;
            return dp[i][target];
        }


        int select = selectCoinNumSearch(coins, target - coins[i], i + 1, dp);
        int notSelect = selectCoinNumSearch(coins, target, i + 1, dp);
//        int select = target - coins[i] >= 0 ? (dp[i+1][target - coins[i]] == -2 ? selectCoinNumSearch(coins, target - coins[i], i + 1, dp): dp[i+1][target - coins[i]]) : -1;
//        int notSelect = dp[i+1][target] == -2 ? selectCoinNumSearch(coins, target, i + 1, dp) : dp[i+1][target];
        if (select == -1 && notSelect == -1) {
            dp[i][target] = -1;
        } else if (select == -1) {
            dp[i][target] = notSelect;
        } else if (notSelect == -1) {
            dp[i][target] = select + 1;
        } else {
            dp[i][target] = Math.min(select + 1, notSelect);
        }

        return dp[i][target];

    }

    //改dp
    public static int coinNumDP(int[] coins, int target) {
        int row = coins.length;     //行最大下标
        int col = target;           //列最大下标
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i <= row; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= col; j++) {
            dp[row][j] = -1;
        }


        for (int i = row - 1; i >= 0; i--) {
            for (int j = 1; j <= col; j++) {
                int select = j - coins[i] >= 0 ? dp[i + 1][j - coins[i]] : -1;
                int notSelect = dp[i + 1][j];
                if (select == -1 && notSelect == -1) dp[i][j] = -1;
                else {
                    if (select == -1) dp[i][j] = notSelect;
                    else if (notSelect == -1) dp[i][j] = select + 1;
                    else dp[i][j] = Math.min(select + 1, notSelect);
                }
            }
        }

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[0][target];
    }

    /**
     * leetcode  剑指 Offer II 103. 最少的硬币数目
     * 同 322. 零钱兑换
     * 凑零钱 每个面值对应无限张 返回凑出amount的最少硬币数量
     *
     * @param coins
     * @param amount
     * @return 超时
     */
    public static int coinChange(int[] coins, int amount) {

        return selectMinCoins(coins, amount, 0);
    }

    public static int selectMinCoins(int[] coins, int amount, int i) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (i >= coins.length) return -1;
        int res = Integer.MAX_VALUE;
        int flag = 0;
        for (int j = amount / coins[i]; j >= 0; j--) {
            int tmp = selectMinCoins(coins, amount - j * coins[i], i + 1);
            if (tmp != -1) {
                flag = 1;
                res = Math.min(res, tmp + j);
            }
        }

        return flag == 0 ? -1 : res;
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
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return res;
    }

    public static int selectMinCoinsSearch(int[] coins, int amount, int i, int[][] dp) {
        if (amount < 0) return -1;
        if (dp[i][amount] != -2) return dp[i][amount];

        if (amount == 0) {
            dp[i][amount] = 0;
            return 0;
        }
        //交换上下  会影响最终结果（当表 左下角初始化为 0时才能得到正确结果 初始化为-1时 错）   为什么？？？
        if (i >= coins.length) {
            dp[i][amount] = -1;
            return -1;
        }


        int res = Integer.MAX_VALUE;
        int flag = 0;
        for (int j = amount / coins[i]; j >= 0; j--) {
//            int tmp = selectMinCoins(coins, amount - j * coins[i], i + 1);
            int tmp = amount - j * coins[i] >= 0 ? (dp[i + 1][amount - j * coins[i]] == -2 ? selectMinCoinsSearch(coins, amount - j * coins[i], i + 1, dp) : dp[i + 1][amount - j * coins[i]]) : -1;

            if (tmp != -1) {
                flag = 1;
                res = Math.min(res, tmp + j);

            }

            if (flag == 0) {
                dp[i][amount] = -1;
            } else dp[i][amount] = res;
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
                    int tmp = j - k * coins[i] >= 0 ? dp[i + 1][j - k * coins[i]] : -1;
                    if (tmp != -1) {
                        flag = 1;
                        res = Math.min(res, tmp + k);
                    }
                }

                if (flag == 0) {
                    dp[i][j] = -1;
                } else dp[i][j] = res;


            }
        }

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[0][amount];

    }


    //                                                      P17

    //1、boyi改DP

    /**
     * 2、 马跳K步到(a, b)的方法数
     *
     * @param a
     * @param b
     * @param k
     * @return 方法数
     */
    public static int horseK(int a, int b, int k) {
        return jump(a, b, k, 1, 1);
    }

    public static int jump(int a, int b, int k, int i, int j) {  //当前位置(i, j)    合法范围（1，1） （9, 10）
        if (i <= 0 || i > 9 || j <= 0 || j > 10) return 0;   //跳出棋盘
        if (k == 0) return i == a && j == b ? 1 : 0;

        int res = 0;

        res = jump(a, b, k - 1, i - 2, j + 1)
                + jump(a, b, k - 1, i - 2, j - 1)
                + jump(a, b, k - 1, i + 2, j - 1)
                + jump(a, b, k - 1, i + 2, j + 1)
                + jump(a, b, k - 1, i - 1, j + 2)
                + jump(a, b, k - 1, i - 1, j - 2)
                + jump(a, b, k - 1, i + 1, j - 2)
                + jump(a, b, k - 1, i + 1, j + 2);

        return res;
    }

    public static int horseDP(int a, int b, int k) {
        int[][][] dp = new int[10][11][k + 1];
        dp[1][1][0] = 1;

        for (int step = 1; step <= k; step++) {
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 11; j++) {
                    dp[i][j][step] += i - 2 <= 0 || i - 2 > 9 || j + 1 <= 0 || j + 1 > 10 ? 0 : dp[i - 2][j + 1][step - 1];
                    dp[i][j][step] += i - 2 <= 0 || i - 2 > 9 || j - 1 <= 0 || j - 1 > 10 ? 0 : dp[i - 2][j - 1][step - 1];
                    dp[i][j][step] += i + 2 <= 0 || i + 2 > 9 || j - 1 <= 0 || j - 1 > 10 ? 0 : dp[i + 2][j - 1][step - 1];
                    dp[i][j][step] += i + 2 <= 0 || i + 2 > 9 || j + 1 <= 0 || j + 1 > 10 ? 0 : dp[i + 2][j + 1][step - 1];
                    dp[i][j][step] += i - 1 <= 0 || i - 1 > 9 || j + 2 <= 0 || j + 2 > 10 ? 0 : dp[i - 1][j + 2][step - 1];
                    dp[i][j][step] += i - 1 <= 0 || i - 1 > 9 || j - 2 <= 0 || j - 2 > 10 ? 0 : dp[i - 1][j - 2][step - 1];
                    dp[i][j][step] += i + 1 <= 0 || i + 1 > 9 || j - 2 <= 0 || j - 2 > 10 ? 0 : dp[i + 1][j - 2][step - 1];
                    dp[i][j][step] += i + 1 <= 0 || i + 1 > 9 || j + 2 <= 0 || j + 2 > 10 ? 0 : dp[i + 1][j + 2][step - 1];
                }
            }
        }

        return dp[a][b][k];
    }

    /**
     * leetcode 688. “马”在棋盘上的概率
     *
     * @param n
     * @param k
     * @param row
     * @param column
     * @return
     */
    public static double knightProbability(int n, int k, int row, int column) {

        return getProb(n, k, row, column);


    }


    public static double getProb(int n, int k, int row, int column) {
        if (row < 0 || row >= n || column < 0 || column >= n) return 0;
        if (k == 0) {
            return 1.0;
        }

        return getProb(n, k - 1, row + 2, column + 1) / 8
                + getProb(n, k - 1, row + 2, column - 1) / 8
                + getProb(n, k - 1, row - 2, column - 1) / 8
                + getProb(n, k - 1, row - 2, column + 1) / 8
                + getProb(n, k - 1, row - 1, column + 2) / 8
                + getProb(n, k - 1, row - 1, column - 2) / 8
                + getProb(n, k - 1, row + 1, column + 2) / 8
                + getProb(n, k - 1, row + 1, column - 2) / 8;
    }

    //改DP
    public static double knightProbabilityDP(int n, int k, int row, int column) {

        double[][][] dp = new double[n][n][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = 1.0;
            }
        }
        for (int step = 1; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    dp[i][j][step] += (i - 2 < 0 || j + 1 >= n ? 0 : dp[i - 2][j + 1][step - 1]) / 8;
                    dp[i][j][step] += (i - 2 < 0 || j - 1 < 0 ? 0 : dp[i - 2][j - 1][step - 1]) / 8;
                    dp[i][j][step] += (i + 2 >= n || j - 1 < 0 ? 0 : dp[i + 2][j - 1][step - 1]) / 8;
                    dp[i][j][step] += (i + 2 >= n || j + 1 >= n ? 0 : dp[i + 2][j + 1][step - 1]) / 8;
                    dp[i][j][step] += (i - 1 < 0 || j + 2 >= n ? 0 : dp[i - 1][j + 2][step - 1]) / 8;
                    dp[i][j][step] += (i - 1 < 0 || j - 2 < 0 ? 0 : dp[i - 1][j - 2][step - 1]) / 8;
                    dp[i][j][step] += (i + 1 >= n || j - 2 < 0 ? 0 : dp[i + 1][j - 2][step - 1]) / 8;
                    dp[i][j][step] += (i + 1 >= n || j + 2 >= n ? 0 : dp[i + 1][j + 2][step - 1]) / 8;

                }
            }
        }
        return dp[row][column][k];
    }


    /**
     * 凑零钱   每个面值对应无限张 返回凑出amount的总方法数
     *
     * @param coins
     * @param amount
     * @return
     */
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
            for (int col = 0; col <= amount; col++) {
//                for (int zhang = 0; zhang <= col / coins[row]; zhang++) {
//                    dp[row][col] += dp[row + 1][col - zhang*coins[row]];
//                }
                if(col - coins[row] >= 0)
                dp[row][col] = dp[row][col - coins[row]] + dp[row + 1][col];
                else dp[row][col] = dp[row + 1][col];
            }
        }

        return dp[0][amount];
    }




}
