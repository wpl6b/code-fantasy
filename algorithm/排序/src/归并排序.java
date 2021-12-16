public class 归并排序 {
    public void mergeSort(int[] arr){
        if(arr == null || arr.length <= 2)  return;
        process(arr, 0, arr.length -1);
    }

    public void process(int[] arr, int l, int r){
        if(l == r)  return;
        int mid = l + r >> 1;
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public void merge(int[] arr, int l, int mid, int r){
        int i = l, j = mid + 1;
        int[] tmp = new int[r - l + 1];
        int cnt = 0;
        while (i <= mid && j <= r){
            if(arr[i] < arr[j]){
                tmp[cnt++] = arr[i++];
            }else tmp[cnt++] = arr[j++];
        }

        while (i <= mid)    tmp[cnt++] = arr[i++];
        while (j <= r)    tmp[cnt++] = arr[j++];

        i = l;
        for (int val :
                tmp) {
            arr[i++] = val;
        }
    }
}
