import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset_all_possible {
	public static void main(String[] args) {

		System.out.println(subsets(new int[] { 1, 2, 3, 4 }));
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<Integer>(), nums, 0);
		return list;
	}

	private static void backtrack(List<List<Integer>> list,
			ArrayList<Integer> tempList, int[] nums, int start) {

		list.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			System.out.println("add " + nums[i] + " " + tempList + "\t\ti=" + i);
			backtrack(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
			System.out.println("rem " + nums[i] + " " + tempList + "\t\ti=" + i);
		}
	}
}
