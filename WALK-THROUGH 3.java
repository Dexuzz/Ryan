import java.util.*;

public class Array {
    
    public static double calculateAverage(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (double) sum / arr.length;
    }

    public static int[] findMinMax(int[] arr) {
        int minVal = arr[0], maxVal = arr[0];
        for (int num : arr) {
            if (num < minVal) minVal = num;
            if (num > maxVal) maxVal = num;
        }
        return new int[]{minVal, maxVal};
    }

    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] mergedArr = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, mergedArr, 0, arr1.length);
        System.arraycopy(arr2, 0, mergedArr, arr1.length, arr2.length);
        return mergedArr;
    }
    
    public static int[] removeDuplicates(int[] arr) {
        Set<Integer> uniqueSet = new LinkedHashSet<>();
        for (int num : arr) {
            uniqueSet.add(num);
        }
        int[] uniqueArr = new int[uniqueSet.size()];
        int index = 0;
        for (int num : uniqueSet) {
            uniqueArr[index++] = num;
        }
        return uniqueArr;
    }

    public static void main(String[] args) {
        int[] grades = {85, 90, 75, 95, 88};
        System.out.println("Average Grade: " + calculateAverage(grades));

        int[] minMax = findMinMax(grades);
        System.out.println("Minimum Grade: " + minMax[0] + ", Maximum Grade: " + minMax[1]);

        reverseArray(grades);
        System.out.println("Reversed Array: " + Arrays.toString(grades));
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] mergedArr = mergeArrays(arr1, arr2);
        System.out.println("Merged Array: " + Arrays.toString(mergedArr));

        int[] arrWithDuplicates = {1, 2, 3, 2, 4, 5, 1, 6};
        int[] uniqueArr = removeDuplicates(arrWithDuplicates);
        System.out.println("Array after removing duplicates: " + Arrays.toString(uniqueArr));
    }
}
