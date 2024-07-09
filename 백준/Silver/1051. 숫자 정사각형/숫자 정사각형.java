import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		sc.nextLine();
		
		int[][] arr=new int[n][m];
		String[][] board=new String[n][m];
		for(int i=0;i<n;i++) {
			String tmp=sc.nextLine();
			for(int j=0;j<m;j++) {
				board[i][j]=String.valueOf(tmp.charAt(j));
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(board[i][j]);
			}
		}
		
		
		int under=Math.min(n, m);
		
		int ans=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				for(int k=0;k<under;k++) {
					if(i+k<n && j+k<m) {
						if (arr[i][j] == arr[i][j+k] &&arr[i][j] == arr[i+k][j] &&
								arr[i][j] == arr[i+k][j+k]) {
							ans=Math.max(ans, k+1);
						}
					}
				}
			}
		}
		System.out.println(ans*ans);
		sc.close();
	}
}