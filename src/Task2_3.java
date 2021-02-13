public class Task2_3 {

    public static void main(String[] args) {

        int[] arr = {66, 99, 1, 77, 6, 14, 55, 32, 67};
        int[] arr1 = {97, 25, 42, 90, 71, 16, 82, 39, 36, 74 };
        int[] arr2 = {186, 338, 675, 726, 570, 382, 164, 507, 496, 674, 955, 75, 150, 825, 899, 886, 859, 811, 338, 403,
                172, 383, 137, 13, 540, 290, 397, 912, 497, 947, 713, 96, 964, 562, 579, 19, 333, 930, 243, 380, 878,
                256, 759, 542, 280, 639, 998, 955, 826, 254};

        print_arr(thanos_sort(arr));
        print_arr(thanos_sort(arr1));
        print_arr(thanos_sort(arr2));

    }

    public static int[] thanos_sort(int[] arr) {
        if (arr.length > 0) sort(arr, 0, arr.length - 1);
        return arr;
    }

    public static void sort(int[] unsorted_arr, int left, int right) {

        int sum_arr = 0;

        for (int i = left; i <= right; i++) {
            sum_arr += unsorted_arr[i];
        }

        double average = sum_arr / (right - left + 1);

        int[] subarray = new int[right - left + 1];
        int min = 0;
        int max = subarray.length - 1;
        int cursor = left;

        for (int i = left; i <= right; i++) {
            if (unsorted_arr[i] <= average) {
                subarray[min++] = unsorted_arr[i];
            } else {
                subarray[max--] = unsorted_arr[i];
            }
        }

        for (int i = 0; i < subarray.length; i++ ) {
            unsorted_arr[cursor++] = subarray[i];
        }

        if (right > left + 1) {
                sort(unsorted_arr, left, left + min - 1);
                sort(unsorted_arr, left + min, right);
        }
    }

    public static void print_arr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
