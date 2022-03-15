import java.util.Scanner;

public class Solution {
    public int maxWindow(int N, int T, int[] arr){
//        int[] arr = new int[N];
//        Scanner sc = new Scanner(System.in);
//        for (int i = 0; i < N; i++) {
//            arr[i] = sc.nextInt();
//        }
//        int[] arr = new int[]{4,6,3,5,7};

        int l = 0, r = 0, max = 0;

        while (l <= r){
            int sum = 0;
            while (r < arr.length && sum + arr[r] <= T){
                sum += arr[r];
                r ++;
            }
            r --;
            max = Math.max(max, r - l + 1);

            l++;
        }
        return max;
    }


}
