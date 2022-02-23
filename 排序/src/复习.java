import java.util.ArrayList;
import java.util.Scanner;

public class 复习 {
    public static void main(String[] args) {



        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] strs = str.toCharArray();


        int[] ch = new int[26];
        for (int i = 0; i < strs.length; i++) {
            ch[strs[i] - 'a'] = 1;
        }

        for (int i = 0; i < ch.length; i++) {
            System.out.println(ch[i]);
        }
        int maxIndex = 0;
        for (int i = 25; i >= 0 ; i--) {
            if(ch[i] == 1){
                maxIndex = i;
            }
        }

        for (int i = 0; i < strs.length; i++) {
            System.out.print(strs[i]);
            if(strs[i] - 'a' == maxIndex) System.out.print("(" + "max)");
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    //冒泡
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
            }
        }
    }

    //冒泡优化  （内外层优化）
    public static void bubbleBetter(int[] arr) {
        int n = arr.length;
        int position = n - 1;

        for (int i = 1; i < n; i++) {
            int flag = 0;
            int newPosition = 0;
            for (int j = 0; j < position; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    newPosition = j;
                    flag = 1;
                }
            }
            position = newPosition;
            if (flag == 0) break;
        }
    }

    //选择
    public static void selectSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int maxIndex = n - i;
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[maxIndex]) maxIndex = j;
            }

            swap(arr, maxIndex, n - i);
        }

    }

    //插入
    public static void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0 && arr[j] >= arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }

        }
    }

    //归并
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int l, int r) {
        if (l == r) return;
        int mid = l + (r - l >> 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int[] tmp = new int[arr.length];
        int cnt = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            if (arr[p1] < arr[p2]) {
                tmp[cnt++] = arr[p1++];
            } else if (arr[p1] > arr[p2]) {
                tmp[cnt++] = arr[p2++];
            } else {
                tmp[cnt++] = arr[p1++];
                tmp[cnt++] = arr[p2++];
            }
        }

        while (p1 <= mid) tmp[cnt++] = arr[p1++];
        while (p2 <= r) tmp[cnt++] = arr[p2++];

        cnt = 0;
        while (l <= r) {
            arr[l++] = tmp[cnt++];
        }
    }


    //快排
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        process1(arr, 0, arr.length - 1);
    }

    public static void process1(int[] arr, int l, int r) {
        if (l < r) {
            int random = (int) (l + (r - l + 1) * Math.random());
//            int random = l + (int)((r - l + 1)*Math.random());
            swap(arr, random, r);
            int[] border = partition(arr, l, r);
            process1(arr, l, border[0]);
            process1(arr, border[1], r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {

        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, l++, ++less);
            } else if (arr[l] > arr[r]) {
                swap(arr, l, --more);
            } else l++;
        }

        swap(arr, less + 1, r);
        return new int[]{less, more};
    }


}
