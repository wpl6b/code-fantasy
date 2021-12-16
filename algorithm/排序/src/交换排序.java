public class 交换排序 {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 7, 4, 6, 1, 2, 88, 0, 664, 412};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ,");
        }

    }

    /**
     * 内外循环优化的冒泡排序    稳定
     *
     * @param arr
     */
    public static void bubble(int[] arr) {
        int n = arr.length;
        int position = n - 1;
        for (int i = 1; i < n; i++) {
            boolean isSwap = false;
            int newPosition = 0;
            for (int j = 0; j < position; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSwap = true;
                    newPosition = j;
                }
            }

            position = newPosition;
            if (!isSwap) break;
        }
    }


//    public static void swap(int[] arr, int a, int b) {
//        arr[a] = arr[a] ^ arr[b];
//        arr[b] = arr[a] ^ arr[b];
//        arr[a] = arr[a] ^ arr[b];
//    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }


    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {  //条件不能掉
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);

            int[] border = partition(arr, l, r);
            quickSort(arr, l, border[0]);
            quickSort(arr, border[1], r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {

        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) swap(arr, ++less, l++);
            else if (arr[l] > arr[r]) swap(arr, --more, l);
            else l++;
        }
        swap(arr, less + 1, r);
        return new int[]{less, more};

    }


}
