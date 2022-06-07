package Java.Main;

public class RecursionSort {
    //Project Requirement fulfillment
    public static int binarySearch (int[] arr, int left, int right, int x){
        if (right >= left) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                return (mid);
            } else {
                if (arr[mid] > x) {
                    return (binarySearch(arr, left, mid - 1, x));
                } else {
                    return (binarySearch(arr, mid + 1, right, x));
                }
            }
        }
        return (-1);
    }

    public static void merge (int[] arr, int left, int mid, int right) {
        int n1 = (mid - left + 1);
        int n2 = (right - mid);
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        System.arraycopy(arr, left, leftArr, 0, n1);
        for (int j = 0; j < n2; j++){
            rightArr[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2){
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < n1){
            arr[k] = rightArr[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void sort (int[] arr, int left, int right) {
        if (left < right) {
            int m = (left + right) / 2;
            sort(arr, left, m);
            sort(arr, m + 1, right);
            merge(arr, left, m, right);
        }
    }
}
