package easy;

import java.util.Arrays;

public class findMissingNumber {

    int MissingNumber(int array[], int n) {
        // Your Code Here
        Arrays.sort(array);
        int i = 0;
        while (i < n - 1 && array[i] == i + 1) {
            i++;
        }
        return ++i;
    }

}
