import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permuation_one_way {
	public static int solve(int arr[]) {

		return 0;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		System.out.println(permute(arr));
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		// Arrays.sort(nums); // not necessary
		backtrack(list, new ArrayList<Integer>(), nums);
		return list;
	}

	private static void backtrack(List<List<Integer>> list,
			List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i]))
					continue; // element already exists, skip
				tempList.add(nums[i]);
				System.out.println("add"+tempList);
				backtrack(list, tempList, nums);
				System.out.println("rem"+tempList);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
