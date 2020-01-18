package amazon;

import java.util.Arrays;
import java.util.HashSet;

public class Prison_Cells {
	public static void main(String[] args) {

		int cells[] = { 0, 1, 0, 1, 1, 0, 0, 1 };
		System.out.println(Arrays.toString(prisonAfterNDays(cells, 7)));
	}

	public static int[] prisonAfterNDays(int[] cells, int N) {

		if (cells == null || cells.length == 0 || N < 1)
			return cells;
		HashSet<String> hs = new HashSet<>();
		int c = 0;
		boolean cycle = false;
		for (int i = 0; i < N; i++) {
			int temp[] = next(cells);
			String key = Arrays.toString(temp);
			if (!hs.contains(key)) {
				hs.add(key);
				c++;
			}
			else
			{
				cycle=true;
				break;
			}
			cells=temp;
		}
		if(cycle==true)
		{
			N=N%c;
			for(int i=0;i<N;i++)
				cells=next(cells);
		}
		

		return cells;
	}

	public static int[] next(int[] cells) {

		int temp[] = new int[cells.length];

		for (int i = 1; i < cells.length - 1; i++) {
			temp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
		}
		return temp;
	}

}




//
//
//
////The solution above assuming that the cycel always index 1 (index 0 might not be part of the cycle). However, we are sure that there will be a cycel if N is super large, but we are not sure where the cycle starts.
//public int[] prisonAfterNDays(int[] cells, int N) {
//    Map<Integer, Integer> map = new HashMap<>();
//    int cycle = 0;
//    int i = 0;
//    int remaining = 0;
//    while(i<N)
//    {
//        int key = toNum(cells);
//        if(map.containsKey(key))
//        {
//            cycle = i - map.get(key);
//            remaining = (N-i)%cycle;
//            break;
//        }
//        map.put(key, i);
//        cells = getNext(cells);
//        i++;
//    }
//    
//    int j = 0;
//    while(j<remaining)
//    {
//        cells = getNext(cells);
//        j++;
//    }
//    return cells;   
//}
//
//public int[] getNext(int[] cells)
//{
//    int[] ans = new int[cells.length];
//    for(int i=1; i<ans.length-1; i++)
//    {
//        if((cells[i-1]==1&&cells[i+1]==1)||(cells[i-1]==0&&cells[i+1]==0))
//            ans[i] = 1;   
//    }
//    return ans;
//}
//
//public int toNum(int[] cells)
//{
//    int ans = 0;
//    int mask = 1;
//    for(int i=cells.length-1; i>=0; i--)
//    {
//        ans+=cells[i]*(mask<<(cells.length-1-i));
//    }
//    return ans;
//}