package week2.day13;

public class WinCheck {

	public static boolean checkWinner(char[][] board) {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
				return true;
			}
		}
	
		for (int j = 0; j < 3; j++) {
			if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != ' ') {
				return true;
			}
		}
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
				return true;
		}
		if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
	char[][] board = {
			{'X', 'O', 'X'},
			{'O', 'X', 'O'},
			{' ', 'O', 'X'}
	};
	boolean result = checkWinner(board);
	if (result) {
		System.out.println("X wins");
	}
	}
}
