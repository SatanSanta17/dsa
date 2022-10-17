package arrays;

import java.util.Arrays;

public class productArrayPuzzle {
    //
    // brute force
    public static long[] productExceptSelf(int nums[], int n) {
        long[] products = new long[n];
        for (int i = 0; i < n; i++) {
            long product = 1;
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    product *= nums[j];
                }
            }
            products[i] = product;
        }
        return products;
    }

    //
    // optimized
    // link to the solution:
    public static long[] productExceptSelfOP(int nums[], int n) {
        long[] pref = new long[n];
        long[] suff = new long[n];
        long[] prods = new long[n];
        Arrays.fill(pref, 1);
        Arrays.fill(suff, 1);
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] * nums[i - 1];
        }
        pref[0] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }
        suff[n - 1] = 1;
        for (int i = 0; i < n; i++) {
            prods[i] = pref[i] * suff[i];
        }
        return prods;
    }

}
