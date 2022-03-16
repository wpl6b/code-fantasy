import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class GreedyMain {
    public static void main(String[] args) {
        GreedyMain main = new GreedyMain();
        System.out.println(main.wiggleMaxLength(new int[]{33,53,12,64,50,41,45,21,97,35,47,92,39,0,93,55,40,46,69,42,6,95,51,68,72,9,32,84,34,64,6,2,26,98,3,43,30,60,3,68,82,9,97,19,27,98,99,4,30,96,37,9,78,43,64,4,65,30,84,90,87,64,18,50,60,1,40,32,48,50,76,100,57,29,63,53,46,57,93,98,42,80,82,9,41,55,69,84,82,79,30,79,18,97,67,23,52,38,74,15}));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, res = 0;
        while (i < g.length && j < s.length){
            if(g[i] <= s[j]){
                i ++;
                j ++;
                res ++;
            }
            else j++;
        }

        return res;
    }

//    int max = 0;      //回溯超时
//    public int wiggleMaxLength(int[] nums) {
//        backTracking(nums, 0, new ArrayList<Integer>());
//        return max;
//    }
//
//    public void backTracking(int[] nums, int index,  ArrayList<Integer> path){
//        if(index == nums.length && isWiggle(path.stream().mapToInt(Integer::intValue).toArray())) {
//            max = Math.max(max, path.size());
//            path.forEach(System.out::print);
//        }
//
//
//        for (int i = index; i < nums.length; i++) {
//            path.add(nums[i]);
//            backTracking(nums, i + 1, path);
//            path.remove(path.size() - 1);
//        }
//    }
//
//    public boolean isWiggle(int[] nums){
//
//        if(nums.length == 1 )    return true;
//        if(nums[0] == nums[1])  return false;
//        boolean preGap = nums[1] - nums[0] > 0; //正true 负false
//        for (int i = 2; i < nums.length; i++) {
//            if(nums[i] - nums[i-1] == 0)   return false;
//            boolean gap = nums[i] - nums[i-1] > 0;
//
//            if(preGap && !gap || !preGap && gap)    preGap = gap;
//            else return false;
//        }
//
//        return true;
//    }

    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 1)    return 1;
        int max = 0;
        int index = -1;
        int[] diff = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            diff[i] = nums[i + 1] - nums[i];
            if(index == -1 && diff[i] != 0)  index = i;
        }

        for (int i = 0; i < diff.length; i++) {
            if(diff[i] != 0){
                index = i;
                break;
            }
        }

        int len = 1;
        int i = index;
        int j = i + 1;
        while (i >= 0 && j < diff.length){
            if (diff[j] * diff[i] < 0) {
                i = j;
                j++;
                len++;
            } else j++;
        }
        return index == -1 ? 1 : Math.max(len + 1, max);
    }
}


