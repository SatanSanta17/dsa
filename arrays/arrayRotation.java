package arrays;

import java.util.*;

public class arrayRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int n = rd.nextInt(10000);
        System.out.println(n);
        int k = rd.nextInt(10000);
        System.out.println(k);
        int a[] = new int[n];
        for (int i = 1; i <= n; i++) {
            a[i - 1] = i;
        }
        // int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        sc.close();
        long startTimeinN2 = System.nanoTime();
        int b[] = rotateByKinN2(a, k);
        long elapsedTimeinN2 = System.nanoTime() - startTimeinN2;

        long startTimeinN = System.nanoTime();
        int c[] = rotateByKinN(a, k);
        long elapsedTimeinN = System.nanoTime() - startTimeinN;

        long startTimeinEfficient = System.nanoTime();
        int d[] = rotateByK(a, k);
        long elapsedTimeinEfficient = System.nanoTime() - startTimeinEfficient;
        // for (int e : b) {
        // System.out.print(e + " ");
        // }
        // System.out.println();
        System.out.println("Time Elapsed in N2(in micro-seconds): " + elapsedTimeinN2 / 1000);

        System.out.println("Time Elapsed in N(in micro-seconds): " + elapsedTimeinN / 1000);

        System.out.println("Time Elapsed in Efficient(in micro-seconds): " + elapsedTimeinEfficient / 1000);
    }

    //
    // bruteforce approach
    // time complexity O(n^2);
    // space complexity O(1);
    public static int[] rotateByKinN2(int a[], int k) {
        int n = a.length;
        // for if k>=n
        k = k % n;
        for (int i = 1; i <= k; i++) {
            int first = a[0];
            for (int j = 0; j < n - 1; j++) {
                a[j] = a[j + 1];
            }
            a[n - 1] = first;
        }
        return a;
    }

    //
    // little optimized
    // Time Complexity O(n)
    // Space Complexity O(n)
    public static int[] rotateByKinN(int[] a, int k) {
        int n = a.length;
        // for if k>=n
        k = k % n;
        int[] temp = new int[n];
        for (int i = 0; i < k; i++) {
            temp[n - k + i] = a[i];
        }
        for (int i = k; i < n; i++) {
            temp[i - k] = a[i];
        }
        return temp;
    }

    //
    // best Approach SO far THe Juggling approach as they say so
    // but my 2nd approach is better in time complexity
    // here the time complexity > O(n)
    // and space complexity is O(1)
    public static int[] rotateByK(int[] a, int k) {
        int n = a.length;
        // for if k>=n
        k = k % n;
        int x = gcd.gcd(n, k);
        int temp = 0;
        for (int i = 0; i < x; i++) {
            // i is the set number
            temp = a[i];
            int j = i;
            while (true) {
                int p = j + k;
                if (p >= n) {
                    p = p - n;
                }
                if (p == i) {
                    break;
                }
                a[j] = a[p];
                j = p;
            }
            a[j] = temp;
        }
        return a;
    }
}
