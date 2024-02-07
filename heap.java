
public class Heap {

    public static void heapify(int arr[], int n, int i) {
        int large = i;
        int left = 2 * i;
        int right = 2 * i + 1;
        if (left <= n && arr[large] < arr[left]) {
            large = left;
        }
        if (right <= n && arr[large] < arr[right]) {
            large = right;
        }
        if (large != i) {
            swap(arr, large, i);
            heapify(arr, n, large);
        }
    }

    public static void heapsort(int arr[], int n) {
        int size = n;
        while (size > 1) {
            swap(arr, size, 1);
            size--;
            heapify(arr, size, 1);
        }
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {54, 55, 32, 40, 50, 53};
        int n = 5;

        for (int i = n / 2; i > 0; i--) {
            heapify(arr, n, i);
        }
        System.out.println();
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        heapsort(arr, n);
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
