import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BackTrackingMain {
    public static void main(String[] args) {
        BackTrackingMain main = new BackTrackingMain();
//        main.combine(4, 2);
//        main.combinationSum(new int[]{2,3,6,7}, 7);

//        System.out.println(main.getProb( new int[]{1,1,1}, new int[]{1,2,3}));
//        System.out.println(main.maxWindow(5, 13));
//        main.permuteUnique(new int[]{1,1,2});

//        ArrayList<List<String>> parm = new ArrayList<>();
//        ArrayList<String> p1 = new ArrayList<>();
//        p1.add("JFK");
//        p1.add("SFO");
//        ArrayList<String> p2 = new ArrayList<>();
//        p2.add("JFK");
//        p2.add("ATL");
//        ArrayList<String> p3 = new ArrayList<>();
//        p3.add("SFO");
//        p3.add("ATL");
//        ArrayList<String> p4 = new ArrayList<>();
//        p4.add("ATL");
//        p4.add("JFK");
//        ArrayList<String> p5 = new ArrayList<>();
//        p5.add("ATL");
//        p5.add("SFO");
//
//        parm.add(p1);
//        parm.add(p2);
//        parm.add(p3);
//        parm.add(p4);
//        parm.add(p5);
//
//        main.findItinerary(parm);

//        List<List<String>> lists = main.solveNQueens(3);
//        System.out.println(lists);


    }


//    //按暴力递归来做 错版
//    ArrayList<List<Integer>> res;
//    public List<List<Integer>> combine(int n, int k) {
//        res = new ArrayList<>();
//        process(n, k, new ArrayList<>());
//        return res;
//    }
//
//    public void process(int i, int k, List<Integer> pre){
//        if(i == 0) {
//            if(pre.size() == k) res.add(pre);
//            return;
//        }
//
//        ArrayList<Integer> tmp = new ArrayList<>(pre);
//        tmp.add(i);
//        process(i - 1, k, tmp);
//        process(i - 1, k, pre);
//    }

//    public List<List<Integer>> combine(int n, int k) {    //标准答案
//        res = new ArrayList<List<Integer>>();
//        path = new ArrayList<Integer>();
//        backTracking(1, n, k);
//        return res;
//    }
//    ArrayList<List<Integer>>    res;
//    ArrayList<Integer>  path;
//    public void backTracking(int start, int n, int k){
//        if(path.size() == k){
//            res.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = start; i <= n + 1 - k + path.size ; i++) {   // n - i + 1 表示还剩多少个数可供选择， k - path.size() 表示还需要选择多少个数
//            path.add(i);                                                  // n - i + 1 < k - path.size() 可剪掉
//            backTracking(i + 1, n, k);
//            path.remove(path.size() - 1);
//        }
//    }

    //按暴力递归来做
//    ArrayList<List<Integer>> res;
//    public List<List<Integer>> combine(int n, int k) {
//        res = new ArrayList<>();
//        process(n, k, new ArrayList<>());
//        return res;
//    }
//
//    public void process(int i, int k, List<Integer> pre){
//
//        if(pre.size() == k) {
//            res.add(new ArrayList<Integer>(pre));
//            return;
//        }
//
//        if(i == 0)  return;
//
//        pre.add(i);
//        process(i - 1, k, pre);
//        pre.remove(pre.size() - 1);
//        process(i - 1, k, pre);
//    }

//    ArrayList<List<Integer>> res;
//    public List<List<Integer>> combinationSum3(int k, int n) {
//        res = new ArrayList<List<Integer>>();
//        process(k, n, 1, new ArrayList<Integer>(), 0);
//        return res;
//    }
//
//    public void process(int k, int n, int index, ArrayList<Integer> item, int sum){
//        if(item.size() == k){
//            if(n == sum)    res.add(new ArrayList<Integer>(item));
//            return;
//        }
//
//        if(index == 10) return;
//
//        sum += index;
//        item.add(index);
//        process(k, n, index + 1, item, sum);
//
//        sum -= index;
//        item.remove(item.size() - 1);
//        process(k, n, index + 1, item, sum);
//    }

//    ArrayList<List<Integer>> res;
//    public List<List<Integer>> combinationSum3(int k, int n) {       //标准答案
//        res = new ArrayList<List<Integer>>();
//        backTracking(k, n, 1,0,new ArrayList<Integer>());
//        return res;
//    }
//
//    public void backTracking(int k, int n, int index,int sum,ArrayList<Integer> path){
//        if(path.size() == k){
//            if(n == sum)    res.add(new ArrayList<Integer>(path));
//            return;
//        }
//
//        for (int i = index; i <= 9 ; i++) {
//            path.add(i);
//            backTracking(k, n, i+1, sum + i,path);
//            path.remove(path.size() - 1);
//        }
//    }

//    HashMap<Character, String> map;
//    ArrayList<String> res;
//    public List<String> letterCombinations(String digits) {
//        map = new HashMap<>();
//        res = new ArrayList<String>();
//        if(digits.equals(""))   return res;
//        map.put('2', "abc");
//        map.put('3', "def");
//        map.put('4', "ghi");
//        map.put('5', "jkl");
//        map.put('6', "mno");
//        map.put('7', "pqrs");
//        map.put('8', "tuv");
//        map.put('9', "wxyz");
//        process(digits.toCharArray(), 0, new StringBuilder(digits.length()) );
//        return res;
//    }
//
//    public void process(char[] digits, int index, StringBuilder item){
//        if(index == digits.length){
//            res.add(item.toString());
//            return;
//        }
//
//
//        String available = map.get(digits[index]);
//        for (int i = 0; i < available.length(); i++) {
//            if(item.length() == index + 1)    process(digits, index + 1, item);
//            item.append(available.charAt(i));
//            process(digits, index + 1, item);
//            item.deleteCharAt(item.length() - 1);
//
//        }
//    }

//    ArrayList<String> res;
//    HashMap<Character, String> map;
//    public List<String> letterCombinations(String digits) {     //标准答案
//        map = new HashMap<>();
//        res = new ArrayList<String>();
//        if (digits.equals("")) return res;
//        map.put('2', "abc");
//        map.put('3', "def");
//        map.put('4', "ghi");
//        map.put('5', "jkl");
//        map.put('6', "mno");
//        map.put('7', "pqrs");
//        map.put('8', "tuv");
//        map.put('9', "wxyz");
//        backTracking(digits, 0, new StringBuilder());
//        return res;
//    }
//
//    public void backTracking(String str, int index, StringBuilder path){
//        if(path.length() == str.length())   res.add(path.toString());
//        if(index == str.length())   return;
////        for (int i = index; i < str.length(); i++) {
//        String choice = map.get(str.charAt(index));
//        for (int j = 0; j < choice.length(); j++) {
//            path.append(choice.charAt(j));
//            backTracking(str, index + 1, path);
//            path.deleteCharAt(path.length() - 1);
//        }
////        }
//    }


//    ArrayList<List<Integer>> res;
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        res = new ArrayList<>();
//
//        process(candidates, target, 0, new ArrayList<Integer>(), 0);
//        return res;
//    }
//
//    public void process(int[] candidates, int target, int sum, ArrayList<Integer> path, int index ){
//        if(sum > target)    return;
//        if(sum == target){
//            res.add(new ArrayList<Integer>(path));
//            return;
//        }
//
//        for (int i = index; i < candidates.length; i++) {
//
//            path.add(candidates[i]);
//            process(candidates, target, sum + candidates[i], path, i);
//
//            path.remove(path.size() - 1);
//        }
//    }

//    ArrayList<List<Integer>> res;
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        res = new ArrayList<>();
//        Arrays.sort(candidates);
//        process(candidates, target, 0, new ArrayList<Integer>(), 0);
//        return res;
//    }
//
//    public void process(int[] candidates, int target, int sum, ArrayList<Integer> path, int index ){
//        if(sum > target)    return;
//        if(sum == target){
//            res.add(new ArrayList<Integer>(path));
//            return;
//        }
//
//        for (int i = index; i < candidates.length; i++) {
//            if(sum + candidates[i] > target)    break;
//            path.add(candidates[i]);
//            process(candidates, target, sum + candidates[i], path, i);
//
//            path.remove(path.size() - 1);
//        }
//    }

//    ArrayList<List<Integer>> res;
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {   //标准答案
//        res = new ArrayList<>();
//        Arrays.sort(candidates);
//        backTracking(candidates, target, 0,0,new ArrayList<Integer>());
//        return res;
//    }
//
//    public void backTracking(int[] arr, int target, int index,int sum, ArrayList<Integer> path){
//        if(sum == target) {
//            res.add(new ArrayList<Integer>(path));
//            return;
//        }
//        if(sum > target)    return;
//
//        for (int i = index; i < arr.length && sum + arr[i] <= target; i++) {
//
//            path.add(arr[i]);
//
//            backTracking(arr, target, i,sum + arr[i], path);
//            path.remove(path.size() - 1);
//        }
//    }

//    ArrayList<List<Integer>> res;
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        res = new ArrayList<>();
//        Arrays.sort(candidates);
////        process(candidates, target, 0, new ArrayList<Integer>(), 0);
//        backTracking(candidates, target, 0, new ArrayList<Integer>(), 0);
//        return res;
//    }
//
//    public void process(int[] arr, int target,int index, ArrayList<Integer> item, int sum){
//
//        if(sum == target){
//            res.add(new ArrayList<Integer>(item));
//            return;
//        }
//        if(sum > target || index >= arr.length)    return;
//
//        item.add(arr[index]);
//        process(arr, target, index + 1, item, sum + arr[index]);
//
//        item.remove(item.size() - 1);
//        process(arr, target, index + 1, item, sum);
//    }
//
//    public void backTracking(int[] arr, int target,int index, ArrayList<Integer> item, int sum){
//        if(sum == target){
//            res.add(new ArrayList<Integer>(item));
//            return;
//        }
//        if(sum > target || index >= arr.length)    return;
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = index; i < arr.length; i++) {
//
//            if(set.contains(arr[i]))   continue;
//            else set.add(arr[i]);
//            item.add(arr[i]);
//            backTracking(arr, target, i + 1, item, sum + arr[i]);
//
//            item.remove(item.size() - 1);
//        }
//
//    }

//    ArrayList<List<Integer>> res;
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {      //标准答案
//        res = new ArrayList<>();
//        Arrays.sort(candidates);
//        backTracking(candidates, target, 0, 0, new ArrayList<Integer>());
//        return res;
//    }
//
//    public void backTracking(int[] arr, int target, int index, int sum,ArrayList<Integer> path) {
//        if(sum > target)    return;
//        if(sum == target)   {
//            res.add(new ArrayList<Integer>(path));
//        }
//
//        for (int i = index; i < arr.length && sum + arr[i] <= target; i++) {
//            if(i > index && arr[i] == arr[i-1]) continue;
//            path.add(arr[i]);
//            backTracking(arr, target, i + 1, sum + arr[i], path);
//            path.remove(path.size()  - 1);
//        }
//    }


//    ArrayList<List<String>> res;
//    public List<List<String>> partition(String s) {
//        res = new ArrayList<>();
//        backTracking(s, 0, new ArrayList<String>());   //0 ~ s.length() - 1 可供切割的范围
//        return res;
//    }
//
//    public void backTracking(String str, int index, ArrayList<String> path){
//        if(index == str.length()){
//            res.add(new ArrayList<String>(path));
//            return;
//        }
//
//        for (int i = index; i < str.length(); i++) {
//
//            String sub = str.substring(index, i+1);
//            if(!palindrome(sub.toCharArray()))  continue;
//
//            path.add(sub);
//            backTracking(str, i + 1, path);
//            path.remove(path.size() - 1);
//
//        }
//
//    }
//    public boolean palindrome(char[] str){
//        int l = 0, r = str.length - 1;
//        while (l <= r){
//            if(str[l] != str[r])    return false;
//            l ++ ;
//            r --;
//        }
//
//        return true;
//    }

//    ArrayList<String> res;
//    public List<String> restoreIpAddresses(String s) {
//        res = new ArrayList<String>();
//        backTracking(s, 0, 0, new ArrayList<String>());
//        return res;
//    }
//
//    public void backTracking(String s, int index, int cut, ArrayList<String> path){
//
//        if(index == s.length()){
//            if(path.size() == 4){
//                StringBuilder IP = new StringBuilder();
//                for (String item :
//                        path) {
//                    IP.append(item);
//                    IP.append(".");
//                }
//                IP.deleteCharAt(IP.length() - 1);
//                res.add(IP.toString());
//            }
//            return;
//        }
//
//        if(cut > 4) return;
//
//        for (int i = index; i < s.length(); i++) {
//            String sub = s.substring(index, i + 1);
//            if(!validIPNumber(sub)) break;
//            path.add(sub);
//            backTracking(s, i + 1, cut + 1, path);
//
//            path.remove(path.size() - 1);
//        }
//    }
//
//    public boolean validIPNumber(String str){
//
//        if("0".equals(str)) return true;
//        if(str.charAt(0) == '0')    return false;
//        int num = Integer.parseInt(str);
//        return num > 0 && num <= 255;
//    }

//    ArrayList<List<Integer>> res;
//    public List<List<Integer>> subsets(int[] nums) {
//        res = new ArrayList<>();
//        process(nums, 0, new ArrayList<Integer>());
//        return res;
//    }
//
//    public void process(int[] nums, int index, ArrayList<Integer> path){
//        if(index == nums.length){
//            res.add(new ArrayList<Integer>(path));
//            return;
//        }
//
//        path.add(nums[index]);
//        process(nums, index + 1, path);
//
//        path.remove(path.size() - 1);
//        process(nums, index + 1, path);
//    }


//    ArrayList<List<Integer>> res;
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        res = new ArrayList<>();
//        Arrays.sort(nums);
//        backTracking(nums, 0, new ArrayList<Integer>());
//        return res;
//    }
//
//    public void backTracking(int[] nums, int index, ArrayList<Integer> path){
//        res.add(new ArrayList<Integer>(path));
//        if(index == nums.length)    return;
//
//        for (int i = index; i < nums.length; i++) {
//            if(i - 1 >= index && nums[i] == nums[i-1])  continue;
//
//
//
//            path.add(nums[i]);
//            backTracking(nums, i + 1, path);
//
//            path.remove(path.size() - 1);
//        }
//    }

//    ArrayList<List<Integer>> res;
//    public List<List<Integer>> findSubsequences(int[] nums) {
//        res = new ArrayList<>();
//
//        backTracking(nums, 0, new ArrayList<Integer>());
//        return res;
//    }
//
//    public void backTracking(int[] nums, int index, ArrayList<Integer> path) {
//
//        if(path.size() >= 2 )    res.add(new ArrayList<Integer>(path));
//
//        if (index == nums.length) return;
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = index; i < nums.length; i++) {
////            if (i - 1 >= index && nums[i] == nums[i - 1]) continue;
//            if(set.contains(nums[i]) || !path.isEmpty() && nums[i] < path.get(path.size() - 1))  continue;
//            else set.add(nums[i]);
//
//            path.add(nums[i]);
//            backTracking(nums, i + 1, path);
//
//            path.remove(path.size() - 1);
//        }
//    }

//    ArrayList<List<Integer>> res;
//    public List<List<Integer>> permute(int[] nums) {
//         res = new ArrayList<>();
//         backTracking(nums, new LinkedHashSet<Integer>());
//         return res;
//
//    }
//
//    public void backTracking(int[] nums, LinkedHashSet<Integer> path){
//        if(path.size() == nums.length)   res.add(new ArrayList<Integer>(path));
//
//        for (int i = 0; i < nums.length; i++) {
//            if(path.contains(nums[i]))  continue;
//
//            path.add(nums[i]);
//            backTracking(nums, path);
//            path.remove(nums[i]);
//        }
//
//    }

//    ArrayList<List<Integer>> res;
//    public List<List<Integer>> permute(int[] nums) {
//        res = new ArrayList<>();
//        backTracking(nums, new ArrayList<Integer>(), new boolean[nums.length]);
//        return res;
//
//    }
//
//    public void backTracking(int[] nums, ArrayList<Integer> path, boolean[] used){
//        if(path.size() == nums.length)  res.add(new ArrayList<Integer>(path));
//
//        for (int i = 0; i < nums.length; i++) {
//            if(used[i] )  continue;
//
//            path.add(nums[i]);
//            used[i] = true;
//            backTracking(nums, path, used);
//            path.remove(path.size() - 1);
//            used[i] = false;
//        }
//    }

//    ArrayList<List<Integer>> res;
//    public List<List<Integer>> permuteUnique(int[] nums) {
//         res = new ArrayList<>();
//         Arrays.sort(nums);
//         backTracking(nums, new ArrayList<Integer>(), new boolean[nums.length]);
//         return res;
//    }
//
//    public void backTracking(int[] nums, ArrayList<Integer> path, boolean[] used){
//        if(path.size() == nums.length)  res.add(new ArrayList<Integer>(path));
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(used[i] )  continue;    //深度上修剪
//
//            if(set.contains(nums[i]))   continue;   //广度上修剪
//            else set.add(nums[i]);
//
//            path.add(nums[i]);
//            used[i] = true;
//            backTracking(nums, path, used);
//            path.remove(path.size() - 1);
//            used[i] = false;
//        }
//    }

//    ArrayList<List<Integer>> res;
//    public List<List<Integer>> permuteUnique(int[] nums) {  //标准答案
//        res = new ArrayList<>();
//        Arrays.sort(nums);
//        backTracking(nums, new ArrayList<Integer>(), new boolean[nums.length]);
//        return res;
//    }
//
//    public void backTracking(int[] nums, ArrayList<Integer> path, boolean[] used){
//        if(path.size() == nums.length)  res.add(new ArrayList<Integer>(path));
//
//        for (int i = 0; i < nums.length; i++) {
//            if(i > 0 && nums[i-1] == nums[i] && !used[i - 1] )  continue;
//
//            if(used[i] == false){
//                path.add(nums[i]);
//                used[i] = true;
//                backTracking(nums, path, used);
//                path.remove(path.size() - 1);
//                used[i] = false;
//            }
//
//        }
//    }


//    ArrayList<String> res;
//    boolean find;
//    public List<String> findItinerary(List<List<String>> tickets) {
//        res = new ArrayList<String>();
//
//        TreeMap<List<String>, Integer> map = new TreeMap<>((a, b) -> {
//            return a.get(0).compareTo(b.get(0)) == 0 ? a.get(1).compareTo(b.get(1)) : a.get(0).compareTo(b.get(0));
//        });
//
//        for (int i = 0; i < tickets.size(); i++) {
//            List<String> item = tickets.get(i);
//            if(map.containsKey(item))   map.put(item, map.get(item) + 1);
//            else map.put(item, 1);
//        }
//
//
//        backTracking(map, "JFK",  new ArrayList<String>(), tickets.size());
//
//        return res;
//    }
//
//    public void backTracking(TreeMap<List<String>, Integer> map, String next,  ArrayList<String> path, int len){
//        if(find)    return;
//        if(path.size() == len){
//            path.add(next);
//            res = new ArrayList<String>(path);
//
//            find = true;
//            return;
//        }
//
//
//        Iterator<Map.Entry<List<String>, Integer>> entries = map.entrySet().iterator();
//
//        while (entries.hasNext()) {
//            if(find)    return;
//            Map.Entry<List<String>, Integer> entry = entries.next();
//
//            List<String> key = entry.getKey();
//            int rest = entry.getValue();
//
//            String from = key.get(0);
//            String to = key.get(1);
//            if(rest != 0){
//                if(from.equals(next)){
//                    path.add(from);
//                    map.put(entry.getKey(), rest - 1);
//
//                    backTracking(map, to, path, len);
//                    path.remove(path.size() - 1);
//                    map.put(entry.getKey(), rest);
//                }
//            }
//
//        }
//
//
//    }

//    ArrayList<List<String>> res;
//    public List<List<String>> solveNQueens(int n) {
//        res = new ArrayList<>();
//        int[] flag = new int[n];
//        for (int i = 0; i < n; i++) {
//            flag[i] = -1;
//        }
//        backTracking(n, 0, flag, new ArrayList<String>());
//        return res;
//    }
//
//    public void backTracking(int n, int row,int[] flag, List<String> path){
//        if(row == n){
//            res.add(new ArrayList<String>(path));
//        }
//
//        for (int col = 0; col < n; col++) {
//            if(isValid(row, col, flag)){
//                flag[row] = col;
//                StringBuilder str = new StringBuilder();
//                for (int i = 0; i < n; i++) {
//                    if(i == col)     str.append("Q");
//                    else str.append(".");
//                }
//                path.add(str.toString());
//                backTracking(n, row + 1, flag, path);
//
//                flag[row] = -1;
//                path.remove(path.size() - 1);
//            }
//        }
//    }
//
//    public boolean isValid(int row, int col, int[] flag){
//        for (int i = 0; i < row; i++) {
//            if(flag[i] == col || Math.abs(flag[i] - col) == Math.abs(i - row))  return false;
//        }
//        return true;
//    }
    char[][] res;
    public void solveSudoku(char[][] board) {
        res = new char[9][9];
        backTracking(board, 0, 0);

    }

    public void backTracking(char[][] board, int row, int col) {
//        if(board[row][col] != '\0')
        if(col == 9)    backTracking(board, row + 1, 0);
        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + ",");
                }
                System.out.println();
            }
        };


        for (int num = 1; num <= 9; num++) {
            if(board[row][col] == (char)('0' + num))    break;
            if (isValid(board, row, col, num)){
                board[row][col] = (char) (num + '0');
                backTracking(board, row, col + 1);
                board[row][col] = '.';
            }
        }

    }

    public boolean isValid(char[][] board, int row, int col, int num) {

        for (int i = 0; i < 9; i++) {
            if(board[i][col] - '0' == num)  return false;
        }

        for (int j = 0; j < 9; j++) {
            if(board[row][j] - '0' == num)   return false;
        }

        int boxRow = row/3;
        int boxCol = col/3;
        for (int i = boxRow * 3; i < boxRow * 3 + 3 ; i++) {
            for (int j = boxCol * 3; j < boxCol * 3 + 3; j++) {
                if(board[i][j] - '0' == num)    return false;
            }
        }

        return true;
    }


}
