package gs;

class p2 {
	public int[][] solution(int board[][], int k, String[] rules) {
		int distance_vector[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 },
				{ -1, 0 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

		int temp_count_2D[][] = new int[board.length][board[0].length];

		for (int turn = 0; turn < k; turn++) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					
					
					int calculate_count = 0;
					for (int f = 0; f < 8; f++) {
						int row = i, col = j;
						row += distance_vector[f][0];
						col += distance_vector[f][1];
						
						
						
						if (row < board.length && row >= 0 &&  col >= 0
								&& col < board[0].length) {
							if (board[row][col] == 1) {
								calculate_count++;
							}
						}
					}
					temp_count_2D[i][j] = calculate_count;
				}
			}
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (rules[temp_count_2D[i][j]].equals("alive")) {
						board[i][j] = 1;
					} else {
						board[i][j] = 0;
					}
				}
			}

		}
		return board;
	}
}

//
//int board[][]=new int[grid.size()][grid.get(0).size()];
//for(int i=0;i<grid.size();i++){
//    for(int j=0;j<grid.get(0).size();j++){
//        board[i][j]=grid.get(i).get(j);
//    }
//}

List<List<Integer>> result = new ArrayList<List<Integer>>();
for(int i=0;i<board.length;i++){
    List<Integer> temp = new ArrayList<>();
    for(int j=0;j<board[0].length;j++){
        temp.add(board[i][j]);
    }
    result.add(temp);
}
 return result;