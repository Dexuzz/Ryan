import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        selectionSort(arr);
        System.out.println("Sorted array (Selection Sort): " + Arrays.toString(arr));

        System.out.print("Enter a number to search (Linear Search): ");
        int target = scanner.nextInt();
        int linearIndex = linearSearch(arr, target);
        if (linearIndex != -1) {
            System.out.println("Element found at index " + linearIndex + " (Linear Search).");
        } else {
            System.out.println("Element not found (Linear Search).");
        }

        int binaryIndex = binarySearch(arr, target);
        if (binaryIndex != -1) {
            System.out.println("Element found at index " + binaryIndex + " (Binary Search).");
        } else {
            System.out.println("Element not found (Binary Search).");
        }

        System.out.print("Enter the number of strings: ");
        int strCount = scanner.nextInt();
        scanner.nextLine();

        String[] stringArray = new String[strCount];
        System.out.println("Enter " + strCount + " strings:");
        for (int i = 0; i < strCount; i++) {
            stringArray[i] = scanner.nextLine();
        }

        insertionSort(stringArray);
        System.out.println("Sorted strings (Insertion Sort): " + Arrays.toString(stringArray));

        scanner.close();
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void insertionSort(String[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            String key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
