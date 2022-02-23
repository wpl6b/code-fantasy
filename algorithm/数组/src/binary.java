

import java.util.*;

public class binary {
    public static void main(String[] args) {
//        double res = findMedianSortedArrays(new int[]{1,2}, new int[]{3});
//        int res = maxArea(new int[]{1,1});
//        System.out.println(res);
//        threeSum(new int[]{-1,0,1,2,-1,-4});
//        backspaceCompare("a#c",     "b");
//        sortedSquares(new int[]{-5,-3,-2,-1});
//        minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1});
//        totalFruit(new int[]{1,2,1});
//        minWindow("cabwefgewcwaefgcf", "cae");
//        generateMatrix(3);
//        spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
//        myPow(2.0, 10);
//        System.out.println(quickAdd(5, 8));
        System.out.println(divide(10,3));
//        int flag = 0;
//        for (int i = 0; i < 9999; i++) {
//            for (int j = 0; j < 9999; j++) {
//                if(fun1(i,j) != fun2(i, j)){
//                    flag = 1;
//                    System.out.println("boom!" + i + "," + j);
//                    break;
//                }
//            }
//
//            if(flag == 1)   break;
//        }
//
//        if(flag == 0) System.out.println("OK");
    }

    //二分
    //4. 寻找两个正序数组的中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        //合并总长度为奇偶的情况
        int k1 = (len1 + len2 + 1) / 2;
        int k2 = (len1 + len2 + 2) / 2;


        return (findK(nums1, nums2, 0, len1 - 1, 0, len2 - 1, k1)
                + findK(nums1, nums2, 0, len1 - 1, 0, len2 - 1, k2)) * 0.5;
    }

    public static int findK(int[] arr1, int[] arr2, int l1, int r1, int l2, int r2, int k){
        // 任一数组长度清零 则返回另一数组中第k大的数
        if(l1 > r1)     return arr2[l2 + k - 1];
        if(l2 > r2)     return arr1[l1 + k - 1];

        //都未清零时 k==1 则第一大的数为要找的数
        if(k == 1)  return Math.min(arr1[l1], arr2[l2]);

        //都未清零且 k != 1
         int len1 = r1 - l1 + 1;
         int len2 = r2 - l2 + 1;
         int cmp1;
         int cmp2;

         //arr1中需要拿出来比较的数的下标
         cmp1 = l1 + Math.min(len1, k/2) - 1;

         //arr2中需要拿出来比较的数的下标
         cmp2 = l2 + Math.min(len2, k/2) - 1;


        if(arr1[cmp1] < arr2[cmp2])     return findK(arr1, arr2, cmp1 + 1, r1, l2, r2, k - (cmp1 - l1 + 1));
        else return findK(arr1, arr2, l1, r1, cmp2 + 1, r2, k - (cmp2 - l2 + 1));

    }

    //双指针
    //11. 盛最多水的容器
    public static int maxArea(int[] height) {
        int max = 0;
        int l = 0, r = height.length - 1;
        while (l != r){

            if(height[l] < height[r]){
                max = Math.max(height[l] * (r - l), max);
                l ++;
            }
            else{
                max = Math.max(height[r] * (r - l), max);
                r --;
            }
        }
        return max;
    }

    //双指针
    //15. 三数之和
    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {

            if(i == 0 || nums[i] != nums[i-1]){


                int k = nums.length - 1;
                for (int j = i + 1; j < nums.length; j++) {


                    if(j == i + 1 || nums[j] != nums[j-1]){

//                        for (int k = j + 1; k < nums.length; k++) {
//
//                            if(k == j + 1 || nums[k] != nums[k-1]){
//                                if(nums[i] + nums[j] + nums[k] == 0){
//                                    ArrayList<Integer> item = new ArrayList<>();
//                                    item.add(nums[i]);
//                                    item.add(nums[j]);
//                                    item.add(nums[k]);
//                                    res.add(item);
//                                }
//                            }
//
//                        }

                        while (j < k && nums[i] + nums[j] + nums[k] > 0){
                            k --;
                        }


                        if(j == k)  break;

                        if(nums[i] + nums[j] + nums[k] == 0){
                                    ArrayList<Integer> item = new ArrayList<>();
                                    item.add(nums[i]);
                                    item.add(nums[j]);
                                    item.add(nums[k]);
                                    res.add(item);
                        }



                    }

                }

            }

        }

        return res;
    }

    //双指针
    //27. 移除元素
    public int removeElement(int[] nums, int val) {
        int s = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val)  nums[++s] = nums[i];
        }

        return s+1;
    }

    //双指针
    //26. 删除有序数组中的重复项
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1)    return 1;
        int s = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[s])  nums[++s] = nums[i];
        }

        return s + 1;
    }

    //283.移动零
    public void moveZeroes(int[] nums) {
        int s = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0)    nums[++s] = nums[i];
        }

        for (int i = nums.length - 1; i > s; i --){
            nums[i] = 0;
        }
    }


    //844.比较含退格的字符串
    public static boolean backspaceCompare(String s, String t) {
        int ss = -1, st = -1;
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        for (int i = 0; i < str1.length; i++) {
            if(str1[i] != '#')    str1[++ss] = str1[i];
            else {
                if(ss != -1)  --ss;
            }
        }

        for (int i = 0; i < str2.length; i++) {
            if(str2[i] != '#')    str2[++st] = str2[i];
            else {
                if(st != -1)  --st;
            }
        }

        if(ss != st)    return false;

        for (int i = 0; i <= ss; i++) {
            if(str1[i] != str2[i])  return false;
        }

        return true;

    }

    //977.有序数组的平方
    public static int[] sortedSquares(int[] nums) {
        //第一个大于等于0的数的索引
        int split = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= 0)   {
                split = i;
                break;
            }
        }

        int l = split - 1,r = split;


        int[] res = new int[nums.length];

        int i = 0;
        while (i < nums.length && l >= 0 && r < nums.length){
            if(nums[l]*nums[l] < nums[r]*nums[r]){
                res[i++] = nums[l]*nums[l];
                l --;
            }else {
                res[i++] = nums[r]*nums[r];
                r ++;
            }
        }

        while (i < nums.length && l >= 0){
            res[i++] = nums[l]*nums[l];
            l --;
        }

        while (i < nums.length && r < nums.length){
            res[i++] = nums[r]*nums[r];
            r ++;
        }

        return res;
    }


    //209.长度最小的子数组

    //前缀和 + 二分
//    public static int minSubArrayLen(int target, int[] nums) {
//
//        int min = Integer.MAX_VALUE;
//
//        int[] preSum = new int[nums.length];
//        preSum[0] = 0;
//        for (int i = 1; i < nums.length; i++) {
//            preSum[i] = preSum[i - 1] + nums[i - 1];
//        }
//
//        //利用preSum 在 nums 上进行二分
//        for (int i = 0; i < nums.length; i++) {
//            int l = i, r = nums.length - 1;
//            while (l < r){
//                int mid = l + r >> 1;
//                if(preSum[mid] - preSum[i] + nums[mid] >= target) r = mid;
//                else l = mid + 1;
//            }
//            if(preSum[l] - preSum[i] + nums[l] >= target)   min = Math.min(min, l - i + 1);
//        }
//
//        return min == Integer.MAX_VALUE ? 0 : min;
//
//    }

    //滑动窗口
//    public static int minSubArrayLen(int target, int[] nums) {
//
//        int min = Integer.MAX_VALUE;
//        int j = 0;
//        int sum = 0;
//        for (int i = 0; i < nums.length ; i++) {
//
//            while (j < nums.length && sum < target) sum += nums[j++];
//            if(sum >= target)   min = Math.min(min, j - i);
//            sum -= nums[i];
//
//        }
//
//        return min == Integer.MAX_VALUE ? 0 : min;
//
//    }
    public static int minSubArrayLen(int target, int[] nums) {

        int min = Integer.MAX_VALUE;
        int i = 0;
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target){
                min = Math.min(min, j - i + 1);
                sum -= nums[i];
                i ++;
            }
//            min = Math.min(min, j - i + 2);

        }
        return min == Integer.MAX_VALUE ? 0 : min;

    }

    //904.水果成篮
    //暴力
//    public int totalFruit(int[] fruits) {
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < fruits.length; i++) {
//            int another = -1;
//
//            int j;
//            for (j = i; j < fruits.length; j++) {
//                if(fruits[j] != fruits[i]){
//                    if (another == -1 || another == fruits[j])  another = fruits[j];
//                    else break;
//                }
//            }
//            max = Math.max(max, j - i);
//        }
//
//        return max;
//    }

    //滑动窗口
    public static int totalFruit(int[] fruits) {
        int i = 0;
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j <  fruits.length; j++) {
            if(map.containsKey(fruits[j]))  map.put(fruits[j], 1 + map.get(fruits[j]));
            else map.put(fruits[j], 1);

            while (map.size() >= 3){
                int cnt = map.get(fruits[i]);
                if(cnt == 1) map.remove(fruits[i]);
                else map.put(fruits[i], cnt - 1);
                i ++;
            }

            max = Math.max(max, j - i + 1);
        }
        return max;
    }

    //76. 最小覆盖子串
    public static String minWindow(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        HashMap<Character, Integer> tmap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> smap = new HashMap<>();
        for (int i = 0; i < tt.length; i++) {
//            if(tmap.containsKey(tt[i])) tmap.put(tt[i], 1 + tmap.get(tt[i]));
//            else tmap.put(tt[i], 1);
            tmap.put(tt[i], tmap.getOrDefault(tt[i], 0) + 1);
        }

        int i = 0;
        int min = Integer.MAX_VALUE;
        int iindex = -1;
        int jindex = -1;
        for (int j = 0; j < ss.length; j++) {
//            if(smap.containsKey(ss[j])) smap.put(ss[j], 1 + smap.get(ss[j]));
//            else smap.put(ss[j], 1);
            smap.put(ss[j], smap.getOrDefault(ss[j], 0) + 1);

            while (checkMap(smap, tmap)){
                if(smap.get(ss[i]) == 1)    smap.remove(ss[i]);
                else smap.put(ss[i], smap.get(ss[i]) - 1);
                if(min > j - i + 1){
                    min = j - i  + 1;
                    iindex = i;
                    jindex = j;
                }
//                min = Math.min(min, j - i + 1);
//                iindex = i;
//                jindex = j;
                i ++;
            }


        }
        return iindex == -1 && jindex == - 1 ? "" : s.substring(iindex , jindex + 1);
    }
    
    public static boolean checkMap(Map<Character, Integer> smap, Map<Character, Integer> tmap){
        for (Map.Entry<Character, Integer> entry :
                tmap.entrySet()) {

            if(smap.get(entry.getKey()) == null || smap.get(entry.getKey()) < entry.getValue())    return false;

        }

        return true;
    }


    //59. 螺旋矩阵 II
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1;
        res[0][0] = 1;
        int i = 0, j = 0;
        char dir = 'r';
        while (num < n*n){
            if(dir == 'r'){
                if(j + 1 == n || res[i][j+1] != 0)  dir = 'd';
                else res[i][++j] = ++num;
            }else if(dir == 'd'){
                if(i + 1 == n || res[i+1][j] != 0)  dir = 'l';
                else res[++i][j] = ++num;
            }else if(dir == 'l'){
                if(j - 1 < 0 || res[i][j-1] != 0)   dir = 'u';
                else res[i][--j] = ++num;
            }else if(dir == 'u'){
                if(i - 1 < 0 || res[i - 1][j] != 0)   dir = 'r';
                else res[--i][j] = ++num;
            }
        }

        return res;
    }

    //54. 螺旋矩阵
    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();

        int i = 0, j = 0;
        char dir = 'r';
        int lu = -1;
        int lr = col;
        int ld = row;
        int ll = -1;
        res.add(matrix[0][0]);
        int cnt = 1;
        while (cnt < row * col){
            if(dir == 'r'){
                if(j + 1 == lr) {
                    dir = 'd';
                    lu ++;
                }
                else {
                    res.add(matrix[i][++j]);
                    cnt++;
                }
            }else if(dir == 'd'){
                if(i + 1 == ld){
                    dir = 'l';
                    lr --;
                }
                else {
                    res.add(matrix[++i][j]);
                    cnt++;
                }
            }else if(dir == 'l'){
                if(j - 1 == ll){
                    dir = 'u';
                    ld --;
                }
                else {
                    res.add(matrix[i][--j]);
                    cnt++;
                }
            }else if(dir == 'u'){
                if(i - 1 == lu){
                    dir = 'r';
                    ll ++;
                }
                else {
                    res.add(matrix[--i][j]);
                    cnt++;
                }
            }


        }
        return res;
    }

    //快速幂
    public static double myPow(double x, int n) {
//        return n > 0 ? quickMul(x, n) : 1 / quickMul(x, -n);
        long N = n ;
        return N > 0 ? quickMulIteration(x, N) : 1 / quickMulIteration(x, -N);
    }

    public static double quickMul(double x, int n){
        if(n == 0)  return 1;
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y*y : y*y*x;
    }

    public static double quickMulIteration(double x, long n){

//        1.00000
//        2147483647
        double res = 1;
        double base = x;
        while (n > 0){
            if(n % 2 != 0){
                res *= base;
            }
            base *= base;       // ！！！！！
            n /= 2;
        }

        return res;
    }

    public static int divide(int dividend, int divisor) {

        if(dividend == -Math.pow(2, 31) && divisor == -1)    return (int) (Math.pow(2, 31) - 1);

        int res = 1;
        if(dividend > 0){
            dividend = -dividend;
            res *= -1;
        }
        if(divisor > 0){
            divisor = -divisor;
            res *= -1;
        }

        int l = 1, r = (int) (Math.pow(2, 31) - 1);
        while (l  < r){
//            int mid = l + ( (r - l) >> 1 ) + 1 ;
            int mid = l + (r - l + 1>> 1) ;
            if(quickAddTemplate(mid, divisor) >= dividend)  r = mid;
//            if(quickAdd(mid, divisor, dividend)) r = mid;
//            if(!quickAddAns(divisor, mid, dividend)) r = mid;
            else l = mid + 1;
        }

        return l*res;
    }

    public static double quickAddTemplate(int x, int y){


        double res = 0;
        double base = y;
        while (x > 0){
            if((x & 2) != 0){
                res += base;
            }
            base += base;       // ！！！！！
            x >>= 1;
        }

        return res;
    }

    public static boolean quickAdd(int x, int y, int lim){
        //x > 0 011,  y < 0, lim < 0

        int res = 0;
        int base = y;
        while (x != 0){
            if((x & 1) != 0){
                res += base;
            }
            if(res < lim)   return false;
            base += base;       // ！！！！！
            x >>= 1;
        }

        return true;
    }

    public static boolean quickAddAns(int y, int z, int x) {
        // x 和 y 是负数，z 是正数
        // 需要判断 z * y >= x 是否成立
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                // 需要保证 result + add >= x
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                // 需要保证 add + add >= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            // 不能使用除法
            z >>= 1;
        }
        return true;
    }


    public static int fun1(int l, int r){
        return l + (r - l + 1>> 1);
    }

    public static int fun2(int l, int r){
        return l + r + 1 >> 1;
    }


}



