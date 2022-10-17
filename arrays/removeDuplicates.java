package arrays;

public class removeDuplicates {
    int remove_duplicate(int A[], int N) {
        // code here
        int a[] = new int[N];
        int count = 0;
        if (N == 1) {
            return 1;
        }

        for (int i = 0; i < N - 1; i++) {
            if (A[i] != A[i + 1]) {
                a[count] = A[i];
                count++;
            }
            if (i == N - 2 && A[N - 2] != A[N - 1]) {
                a[count] = A[N - 1];
                count++;
            }
            if (i == N - 2 && count > 0 && a[count - 1] != A[N - 1]) {
                a[count] = A[N - 1];
                count++;
            }
            if (i == N - 2 && count == 0) {
                a[count] = A[N - 1];
                count++;
            }
        }

        for (int i = 0; i < N; i++) {
            A[i] = a[i];
        }
        return count;

    }

}
