import java.io.*;
import java.util.*;

class nqueen{
	public static void main(String args[])throws IOException{;
		System.out.println("Enter row and column");
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int matrix[][] = new int[row][col];
		List<List<Cell>> answer = new ArrayList<>();
		List<Cell> temp = new ArrayList<>();
		int curr_row = 0;
		int curr_col = 0;
		solve_nq(row,col,answer,temp,curr_row,curr_col);
		System.out.println(answer);
	}
	public static void solve_nq(int row,int col,List<List<Cell>> answer,List<Cell> temp,int curr_row,int curr_col){
	System.out.println(temp);		
	if(curr_row==row){
		answer.add(new ArrayList<>(temp));
	}
    else{
	for(int i=0;i<col;i++){
		temp.add(new Cell(curr_row,i));
		if(isSafe(temp,curr_row,i)){
			solve_nq(row,col,answer,temp,curr_row+1,curr_col);	
		}	
		temp.remove(temp.size()-1);
	}
	}
	}
	public static boolean isSafe(List<Cell> temp,int row, int col){
	
	int n = temp.size();
	n=n-1;
	for(int i=0;i<n;i++){
		int prev_row = temp.get(i).row;
		int prev_col = temp.get(i).col;
		if(Math.abs(prev_col-col)==0) return false;
		if(Math.abs(prev_row-row)-Math.abs(prev_col-col)==0) return false;
	}
	return true;
	}
}
class Cell{
	int row;
	int col;
	Cell(int r,int c){
		row = r;
		col = c;
	}
	public String toString(){
		return "("+row+"-"+col+")";
	}
}
