public class 插入排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,5,7,4,6,1,2,88,0,664,412};

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ,");
        }

    }

    /**
     *
     * @param arr
     * 进行n-1次
     * 因为默认第一个数为有序序列
     * 每次从无序序列中拿出一个数在有序序列中找到它的插入位置（逆序遍历有序序列 边找边交换）
     */
    public void insertSort(int[] arr){
        int n = arr.length;
        for (int i = 1; i < n; i++) {

            for (int j = i - 1; j >= 0 && arr[j+1] < arr[j] ; j--) {
                swap(arr, j, j + 1);
            }
        }
    }





    public void swap(int[] arr, int a, int b){
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
}
