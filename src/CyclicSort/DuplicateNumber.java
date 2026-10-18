package CyclicSort;

public class DuplicateNumber {

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 2, 2};

        DuplicateNumber obj = new DuplicateNumber();

        System.out.println(obj.DuplicateElement(arr));
    }

    int DuplicateElement(int[] arr) {

        int i = 0;

        while (i < arr.length) {

            int idx = arr[i] - 1;

            // Already in correct position
            if (arr[i] == i + 1) {
                i++;
            }

            // Duplicate found
            else if (arr[i] == arr[idx]) {
                return arr[i];
            }

            // Put element in correct position
            else {
                swap(arr, i, idx);
            }
        }

        return -1;
    }

    private void swap(int[] arr, int i, int idx) {

        int temp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = temp;
    }
}