package com.chapter5;

public class EatWhit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EatWhit e = new EatWhit();
		char [][]a = {
				"XOXOXO".toCharArray(),
				"OXOXOX".toCharArray(),
				"XOXOXO".toCharArray(),
				"OXOXOX".toCharArray()
		};
		e.solve(a);
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length ; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
    public void solve(char[][] board) {
        int kuan = board.length;
        if(kuan == 0) return;
        int chang = board[0].length;
        eat(board, chang, kuan);
    }
	
	public void eat(char[][] a, int chang, int kuan) {
		boolean b = false;
		for(int i = 0; i < kuan; i++) {
			for(int j = 0; j < chang; j++) {
				if(a[i][j] == 'O') {
					b = isSurrenden(i, j, a, kuan, chang);					
					}
				}
			}
		
		for(int i = 0; i < kuan; i++) {
			for(int j = 0; j < chang; j++) {
				if(a[i][j] == 'y') {
					a[i][j] = 'O';				
					}
				}
			}
		
	}
	
	public boolean isSurrenden(int i, int j, char [][] a, int chang, int kuan) {
		boolean left = false;
		boolean right = false;
		boolean up = false;
		boolean down = false;
		a[i][j] = 'X';	
		if(j < kuan - 1 && a[i][j + 1] == 'O') {
			right = isSurrenden(i, j + 1, a, chang, kuan);
		} else if(j >= kuan - 1) {
			a[i][j] = 'y';
			return false;
		} else {
			right = true;
		}
		
		if(j > 0 && a[i][j - 1] == 'O') {
			left = isSurrenden(i, j - 1, a, chang, kuan);
		} else if (j <= 0) {
			a[i][j] = 'y';
			return false;
		} else {
			left = true;
		}
		
		if(i < chang - 1 && a[i + 1][j] == 'O') {
			up = isSurrenden(i + 1, j, a, chang, kuan);
		} else if (i >= chang - 1) {
			a[i][j] = 'y';
			return false;
		} else {
			up = true;
		}
		
		if(i > 0 && a[i - 1][j] == 'O') {
			down = isSurrenden(i - 1, j, a, chang, kuan);
		} else if (i <= 0) {
			a[i][j] = 'y';
			return false;
		} else {
			down = true;
		}
		if(left && right && up && down)  {
			;
		} else {
			a[i][j] = 'y';
		}
		return left & right & up & down;
	}

}
