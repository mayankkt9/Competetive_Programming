package try1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Modified_Merge {
	public static void main(String[] args) {
		// code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int j = 0; j < t; j++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			MergeSort obj = new MergeSort();
			obj.sort(arr, 0, arr.length - 1, k);
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}

	}
}

class MergeSort {
	void merge(int arr[], int l, int m, int r, int kNear) {
		int n1 = m - l + 1;
		int n2 = r - m;

		if (n1 <= kNear && n2 <= kNear) {
			merge(arr, l, m, r);
			return;
		}
		int L[] = new int[kNear];
		int R[] = new int[kNear];

		int start_A1 = m - kNear + 1;
		int end_A1 = start_A1+kNear;
		int start_A2 = m + 1;
		int end_A2 = start_A2 + kNear;

		for (int i = start_A1, j = 0; i < end_A1; ++i, ++j)
			L[j] = arr[i];
		for (int i = start_A2, j = 0; i < end_A2; ++i, ++j)
			R[j] = arr[i];

		int i = 0, j = 0;
		int k = start_A1;
		while (i < kNear && j < kNear) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < kNear) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while (j < kNear) {
			arr[k] = R[j];
			j++;
			k++;
		}

	}

	void merge(int arr[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];
		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	public void mergeArray(int A[], int m, int B[], int n) {
		int i = m - 1, j = n - 1, k = m + n - 1;
		while (i >= 0 && j >= 0) {
			A[k--] = A[i] > B[j] ? A[i--] : B[j--];
		}
		while (j >= 0) {
			A[k--] = B[j--];
		}
	}

	void sort(int arr[], int l, int r, int k) {
		if (l < r) {
			int m = (l + r) / 2;
			sort(arr, l, m, k);
			sort(arr, m + 1, r, k);
			merge(arr, l, m, r, k);
		}
	}
}