import java.io.*;
import java.util.*;

class tower_of_hanoi{
	public static void main(String args[])throws IOException{
		int number_of_disk;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of disk ->");
		number_of_disk = sc.nextInt();
		towerSolve(number_of_disk,'S','D','A');
		sc.close();
	}
	public static void towerSolve(int n,char source,char destination,char aux){
		if(n==0)
			System.out.println("Zero Disk");
		if(n==1){
			System.out.println("Move disk 1 from "+source+" to "+destination);
			return;
		}
		towerSolve(n-1,source,aux,destination);
		System.out.println("Move disk "+n+" from "+source+" to "+destination);
		towerSolve(n-1,aux,destination,source);
		
	}	
}
