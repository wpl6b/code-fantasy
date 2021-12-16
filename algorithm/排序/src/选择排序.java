public class 选择排序 {
    /**
     *  不稳定
     * @param arr
     *从无序序列中选出最大的数和无序序列中的最后一个数做交换
     * 做n-1次
     * 因为最后一次无序序列中仅剩一个数 不用交换
     */
    public static void selectSort(int[] arr){
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int index = n - i;  //index记录无序序列中最大数下标
            for (int j = 0; j < n - i; j++) {
                if(arr[j] > arr[index]) index = j;
            }
            swap(arr, index, n - i);
        }
    }

//    public static void swap(int[] arr, int a, int b){
//        arr[a] = arr[a] ^ arr[b];
//        arr[b] = arr[a] ^ arr[b];
//        arr[a] = arr[a] ^ arr[b];
//    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 7, 4, 6, 1, 2, 88, 0, 664, 412};
//        bubbleSort(arr);

//        bubbleBetter(arr);

        selectSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ,");
        }
    }
}
