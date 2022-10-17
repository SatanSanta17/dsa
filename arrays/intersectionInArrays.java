package arrays;

import java.util.HashSet;

public class intersectionInArrays {
    public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
        HashSet<Integer> intersection = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            intersection.add(a[i]);
        }
        for (int i = 0; i < m; i++) {
            if (intersection.contains(b[i])) {
                intersection.remove(b[i]);
                count++;
            }
        }
        return count;
    }
}
