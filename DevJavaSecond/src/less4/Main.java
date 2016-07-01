package less4;

import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] battle = new int[3][3];
		boolean isRun = true;
		while(isRun){
			cpuShot(battle);
			print(battle);
			userShot(battle, sc);
			print(battle);
			isRun = isSomeOneWin(battle);
			if(!isRun){
				System.out.println("Winner");
			}
		}
		sc.close();
	}
	
	static boolean isSomeOneWin(int[][] battle){
		if(battle[0][0]>0&&battle[0][1]>0&&battle[0][2]>0){
			return false;
		}else if(battle[1][0]>0&&battle[1][1]>0&&battle[1][2]>0){
			return false;
		}else if(battle[2][0]>0&&battle[2][1]>0&&battle[2][2]>0){
			return false;
		}else if (battle[0][0]>0&&battle[1][0]>0&&battle[2][0]>0){
			return false;
		}else if(battle[0][1]>0&&battle[1][1]>0&&battle[2][1]>0){
			return false;
		}else if(battle[0][2]>0&&battle[1][2]>0&&battle[2][2]>0){
			return false;
		}else if(battle[0][0]>0&&battle[1][1]>0&&battle[2][2]>0){
			return false;
		}else if(battle[2][0]>0&&battle[1][1]>0&&battle[0][2]>0){
			return false;
		}
		return isAllFieldFull(battle);
	}
	
	static boolean isAllFieldFull(int[][] battle){
		for (int i = 0; i < battle.length; i++) {
			for (int j = 0; j < battle[i].length; j++) {
				if(battle[i][j]==0) return true;
			}
		}
		return false;
	}
	
	static void userShot(int[][] battle, Scanner sc) {
		System.out.println("Enter from 1 to 3 by x coordinate");
		int y = read(sc) - 1;
		System.out.println("Enter from 1 to 3 by y coordinate");
		int x = read(sc) - 1;
		battle[x][y]=2;
	}

	static void cpuShot(int[][] battle){
		boolean isShoted = true;
		while(isShoted){
			int x = random(0, 2);
			int y = random(0, 2);
			if(battle[x][y]==0){
				isShoted = false;
				battle[x][y]=1;
			}
		}
	}
	
	static void print(int[][] battle){
		System.out.println("--------------------------");
		for (int i = 0; i < battle.length; i++) {
			for (int j = 0; j < battle[i].length; j++) {
				if(battle[i][j]==0){
					System.out.print("  ");
				}else if (battle[i][j]==1){
					System.out.print("x ");
				}else{
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}
	
	static int random(int from, int to) {
		int r = (int) Math.round(Math.random() * (to - from) + from);
		return r;
	}
	
	static int read(Scanner sc) {
		if (sc.hasNextInt()) {
			return sc.nextInt();
		}
		return 0;
	}
}
