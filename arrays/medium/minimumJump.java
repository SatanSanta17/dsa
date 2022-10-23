package medium;

////Given an array of N integers arr[] where each element represents the max length of the jump that can be made
////forward from that element.
////Find the minimum number of jumps to reach the end of the array (starting from the first element).
////If an element is 0, then you cannot move through that element.
////Note: Return -1 if you can't reach the end of the array.

public class minimumJump {
    static int minJumps(int[] a) {
        int n = a.length;
        if (n == 1) {
            return 0;
        }
        if (a[0] == 0) {
            return -1;
        }
        int maxReach = a[0];
        int steps = a[0]; // steps is the no. of elements we can travers from the selected element.
        int jumps = 1;
        for (int i = 1; i < n - 1; i++) {
            maxReach = Math.max(maxReach, i + a[i]);
            steps--;
            if (steps == 0) {
                jumps++;
                if (i >= maxReach) {
                    return -1;
                }
                steps = maxReach - i;
            }
        }
        return jumps;
    }
}