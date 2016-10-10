import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class chess {

	public enum Chessmen {
		WHITE_KING, WHITE_QUEEN, WHITE_ROOK, WHITE_BISHOP, WHITE_KNIGHT, WHITE_PAWN, BLACK_KING, BLACK_QUEEN, BLACK_ROOK, BLACK_BISHOP, BLACK_KNIGHT, BLACK_PAWN, EMPTY
	}

	public static void printBoard(Chessmen[][] chessboard) {
		for (int i = 0; i < 9; i++) {
			if (i == 0) {
				System.out.print("\t" + "a" + "\t" + "b" + "\t" + "c" + "\t" + "d" + "\t" + "e" + "\t" + "f" + "\t"
						+ "g" + "\t" + "h");
			}
			for (int j = 0; j < 9; j++) {

				if (i == 0 && j == 0) {
					System.out.print("\t");
				}

				if (j == 0 && i >= 1) {
					System.out.print(9 - i + "." + "\t");
				}

				if (i >= 1 && j >= 1) {

					switch (chessboard[i - 1][j - 1]) {

					case WHITE_KING:
						System.out.print("\u2654" + "\t");
						break;

					case WHITE_QUEEN:
						System.out.print("\u2655" + "\t");
						break;

					case WHITE_ROOK:
						System.out.print("\u2656" + "\t");
						break;

					case WHITE_BISHOP:
						System.out.print("\u2657" + "\t");
						break;

					case WHITE_KNIGHT:
						System.out.print("\u2658" + "\t");
						break;

					case WHITE_PAWN:
						System.out.print("\u2659" + "\t");
						break;

					case BLACK_KING:
						System.out.print("\u265A" + "\t");
						break;

					case BLACK_QUEEN:
						System.out.print("\u265B" + "\t");
						break;

					case BLACK_ROOK:
						System.out.print("\u265C" + "\t");
						break;

					case BLACK_BISHOP:
						System.out.print("\u265D" + "\t");
						break;

					case BLACK_KNIGHT:
						System.out.print("\u265E" + "\t");
						break;

					case BLACK_PAWN:
						System.out.print("\u265F" + "\t");
						break;

					case EMPTY:
						System.out.print(" \t");
						break;
					}

				}
			}

			// print new line
			System.out.println("");
		}

	}

	public static void move(Chessmen[][] chessboard, String move) {
		String[] position = move.split(" ");

		int vert1 = (int) position[0].charAt(0) - 97;// ASCII

		int row1 = 8 - ((int) position[0].charAt(1) - 48);

		int vert2 = (int) position[2].charAt(0) - 97;

		int row2 = 8 - ((int) position[2].charAt(1) - 48);

		if (isValid(chessboard, row1, vert1, row2, vert2)) {
			chessboard[row2][vert2] = chessboard[row1][vert1];
			chessboard[row1][vert1] = Chessmen.EMPTY;
		} else {
			System.out.println("");
			System.err.println("invalid move, please input again");
			System.out.println("");
		}

	}

	public static Boolean isValid(Chessmen[][] chessboard, int oldI, int oldJ, int newI, int newJ) {

		switch (chessboard[oldI][oldJ]) {

		case WHITE_KING:

			if (newI >= 0 || newJ <= 7) {
				if ((chessboard[newI][newJ] == Chessmen.EMPTY || chessboard[newI][newJ] == Chessmen.BLACK_BISHOP
						|| chessboard[newI][newJ] == Chessmen.BLACK_KING
						|| chessboard[newI][newJ] == Chessmen.BLACK_KNIGHT
						|| chessboard[newI][newJ] == Chessmen.BLACK_PAWN
						|| chessboard[newI][newJ] == Chessmen.BLACK_QUEEN
						|| chessboard[newI][newJ] == Chessmen.BLACK_ROOK)
						&& ((oldI == newI && (oldJ == newJ + 1 || oldJ == newJ || oldJ == newJ - 1))
								|| (oldI == newI + 1 && (oldJ == newJ + 1 || oldJ == newJ || oldJ == newJ - 1))
								|| (oldI == newI - 1 && (oldJ == newJ + 1 || oldJ == newJ || oldJ == newJ - 1)))) {

					return true;

				} else {
					break;
				}
			}
			break;

		case WHITE_QUEEN:

			if (newI >= 0 || newJ <= 7) {
				for (int i = 0; i <= 7; i++) {
					if ((chessboard[newI][newJ] == Chessmen.EMPTY || chessboard[newI][newJ] == Chessmen.BLACK_BISHOP
							|| chessboard[newI][newJ] == Chessmen.BLACK_KING
							|| chessboard[newI][newJ] == Chessmen.BLACK_KNIGHT
							|| chessboard[newI][newJ] == Chessmen.BLACK_PAWN
							|| chessboard[newI][newJ] == Chessmen.BLACK_QUEEN
							|| chessboard[newI][newJ] == Chessmen.BLACK_ROOK) && newI == oldI && newJ == i) {
						return true;
					}
				}
				for (int i = 0; i <= 7; i++) {
					if ((chessboard[newI][newJ] == Chessmen.EMPTY || chessboard[newI][newJ] == Chessmen.BLACK_BISHOP
							|| chessboard[newI][newJ] == Chessmen.BLACK_KING
							|| chessboard[newI][newJ] == Chessmen.BLACK_KNIGHT
							|| chessboard[newI][newJ] == Chessmen.BLACK_PAWN
							|| chessboard[newI][newJ] == Chessmen.BLACK_QUEEN
							|| chessboard[newI][newJ] == Chessmen.BLACK_ROOK) && newJ == oldJ && newI == i) {
						return true;
					}
				}
			}

			for (int i = 0; i <= 7; i++) {
				if ((chessboard[newI][newJ] == Chessmen.EMPTY || chessboard[newI][newJ] == Chessmen.BLACK_BISHOP
						|| chessboard[newI][newJ] == Chessmen.BLACK_KING
						|| chessboard[newI][newJ] == Chessmen.BLACK_KNIGHT
						|| chessboard[newI][newJ] == Chessmen.BLACK_PAWN
						|| chessboard[newI][newJ] == Chessmen.BLACK_QUEEN
						|| chessboard[newI][newJ] == Chessmen.BLACK_ROOK)
						&& (((newI == oldI + i) && (newJ == oldJ + i)) || ((newI == oldI - i) && (newJ == oldJ + i))
								|| ((newI == oldI - i) && (newJ == oldJ - i))
								|| ((newI == oldI + i) && (newJ == oldJ - i)))) {
					return true;
				}
			}

			break;

		case WHITE_ROOK:

			for (int i = 0; i <= 7; i++) {
				if ((chessboard[newI][newJ] == Chessmen.EMPTY || chessboard[newI][newJ] == Chessmen.BLACK_BISHOP
						|| chessboard[newI][newJ] == Chessmen.BLACK_KING
						|| chessboard[newI][newJ] == Chessmen.BLACK_KNIGHT
						|| chessboard[newI][newJ] == Chessmen.BLACK_PAWN
						|| chessboard[newI][newJ] == Chessmen.BLACK_QUEEN
						|| chessboard[newI][newJ] == Chessmen.BLACK_ROOK) && newI == oldI && newJ == i) {
					return true;
				}
			}
			for (int i = 0; i <= 7; i++) {
				if ((chessboard[newI][newJ] == Chessmen.EMPTY || chessboard[newI][newJ] == Chessmen.BLACK_BISHOP
						|| chessboard[newI][newJ] == Chessmen.BLACK_KING
						|| chessboard[newI][newJ] == Chessmen.BLACK_KNIGHT
						|| chessboard[newI][newJ] == Chessmen.BLACK_PAWN
						|| chessboard[newI][newJ] == Chessmen.BLACK_QUEEN
						|| chessboard[newI][newJ] == Chessmen.BLACK_ROOK) && newJ == oldJ && newI == i) {
					return true;
				}
			}

			break;

		case WHITE_BISHOP:
			for (int i = 0; i <= 7; i++) {
				if ((chessboard[newI][newJ] == Chessmen.EMPTY || chessboard[newI][newJ] == Chessmen.BLACK_BISHOP
						|| chessboard[newI][newJ] == Chessmen.BLACK_KING
						|| chessboard[newI][newJ] == Chessmen.BLACK_KNIGHT
						|| chessboard[newI][newJ] == Chessmen.BLACK_PAWN
						|| chessboard[newI][newJ] == Chessmen.BLACK_QUEEN
						|| chessboard[newI][newJ] == Chessmen.BLACK_ROOK)
						&& (((newI == oldI + i) && (newJ == oldJ + i)) || ((newI == oldI - i) && (newJ == oldJ + i))
								|| ((newI == oldI - i) && (newJ == oldJ - i))
								|| ((newI == oldI + i) && (newJ == oldJ - i)))) {
					return true;
				}
			}

			break;

		case WHITE_KNIGHT:

			if (newI >= 0 || newJ <= 7) {
				if ((chessboard[newI][newJ] == Chessmen.EMPTY || chessboard[newI][newJ] == Chessmen.BLACK_BISHOP
						|| chessboard[newI][newJ] == Chessmen.BLACK_KING
						|| chessboard[newI][newJ] == Chessmen.BLACK_KNIGHT
						|| chessboard[newI][newJ] == Chessmen.BLACK_PAWN
						|| chessboard[newI][newJ] == Chessmen.BLACK_QUEEN
						|| chessboard[newI][newJ] == Chessmen.BLACK_ROOK)
						&& ((oldI == newI + 2 && oldJ == newJ + 1) || (oldI == newI + 1 && oldJ == newJ + 2)
								|| (oldI == newI - 2 && oldJ == newJ + 1) || (oldI == newI - 1 && oldJ == newJ + 2)
								|| (oldI == newI - 2 && oldJ == newJ - 1) || (oldI == newI - 1 && oldJ == newJ - 2)
								|| (oldI == newI + 2 && oldJ == newJ - 1) || (oldI == newI + 1 && oldJ == newJ - 2))) {

					return true;

				}
			}
			break;

		case WHITE_PAWN:
			if ((chessboard[newI][newJ] == Chessmen.EMPTY || chessboard[newI][newJ] == Chessmen.BLACK_BISHOP
					|| chessboard[newI][newJ] == Chessmen.BLACK_KING || chessboard[newI][newJ] == Chessmen.BLACK_KNIGHT
					|| chessboard[newI][newJ] == Chessmen.BLACK_PAWN || chessboard[newI][newJ] == Chessmen.BLACK_QUEEN
					|| chessboard[newI][newJ] == Chessmen.BLACK_ROOK)
					&& ((newI == oldI - 1 && newJ == oldJ) || (newI == oldI - 2 && newJ == oldJ))) {
				return true;
			}
			break;

		case BLACK_KING:
			if (newI >= 0 || newJ <= 7) {
				if ((chessboard[newI][newJ] == Chessmen.EMPTY || chessboard[newI][newJ] == Chessmen.WHITE_BISHOP
						|| chessboard[newI][newJ] == Chessmen.WHITE_KING
						|| chessboard[newI][newJ] == Chessmen.WHITE_KNIGHT
						|| chessboard[newI][newJ] == Chessmen.WHITE_PAWN
						|| chessboard[newI][newJ] == Chessmen.WHITE_QUEEN
						|| chessboard[newI][newJ] == Chessmen.WHITE_ROOK)
						&& ((oldI == newI && (oldJ == newJ + 1 || oldJ == newJ || oldJ == newJ - 1))
								|| (oldI == newI + 1 && (oldJ == newJ + 1 || oldJ == newJ || oldJ == newJ - 1))
								|| (oldI == newI - 1 && (oldJ == newJ + 1 || oldJ == newJ || oldJ == newJ - 1)))) {

					return true;

				} else {
					break;
				}
			}
			break;

		case BLACK_QUEEN:
			if (newI >= 0 || newJ <= 7) {
				for (int i = 0; i <= 7; i++) {
					if ((chessboard[newI][newJ] == Chessmen.EMPTY || chessboard[newI][newJ] == Chessmen.WHITE_BISHOP
							|| chessboard[newI][newJ] == Chessmen.WHITE_KING
							|| chessboard[newI][newJ] == Chessmen.WHITE_KNIGHT
							|| chessboard[newI][newJ] == Chessmen.WHITE_PAWN
							|| chessboard[newI][newJ] == Chessmen.WHITE_QUEEN
							|| chessboard[newI][newJ] == Chessmen.WHITE_ROOK) && newI == oldI && newJ == i) {
						return true;
					}
				}
				for (int i = 0; i <= 7; i++) {
					if ((chessboard[newI][newJ] == Chessmen.EMPTY || chessboard[newI][newJ] == Chessmen.WHITE_BISHOP
							|| chessboard[newI][newJ] == Chessmen.WHITE_KING
							|| chessboard[newI][newJ] == Chessmen.WHITE_KNIGHT
							|| chessboard[newI][newJ] == Chessmen.WHITE_PAWN
							|| chessboard[newI][newJ] == Chessmen.WHITE_QUEEN
							|| chessboard[newI][newJ] == Chessmen.WHITE_ROOK) && newJ == oldJ && newI == i) {
						return true;
					}
				}
			}

			for (int i = 0; i <= 7; i++) {
				if ((chessboard[newI][newJ] == Chessmen.EMPTY || chessboard[newI][newJ] == Chessmen.WHITE_BISHOP
						|| chessboard[newI][newJ] == Chessmen.WHITE_KING
						|| chessboard[newI][newJ] == Chessmen.WHITE_KNIGHT
						|| chessboard[newI][newJ] == Chessmen.WHITE_PAWN
						|| chessboard[newI][newJ] == Chessmen.WHITE_QUEEN
						|| chessboard[newI][newJ] == Chessmen.WHITE_ROOK)
						&& (((newI == oldI + i) && (newJ == oldJ + i)) || ((newI == oldI - i) && (newJ == oldJ + i))
								|| ((newI == oldI - i) && (newJ == oldJ - i))
								|| ((newI == oldI + i) && (newJ == oldJ - i)))) {
					return true;
				}
			}

			break;

		case BLACK_ROOK:

			if (newI >= 0 || newJ <= 7) {
				for (int i = 0; i <= 7; i++) {
					if ((chessboard[newI][newJ] == Chessmen.EMPTY || chessboard[newI][newJ] == Chessmen.WHITE_BISHOP
							|| chessboard[newI][newJ] == Chessmen.WHITE_KING
							|| chessboard[newI][newJ] == Chessmen.WHITE_KNIGHT
							|| chessboard[newI][newJ] == Chessmen.WHITE_PAWN
							|| chessboard[newI][newJ] == Chessmen.WHITE_QUEEN
							|| chessboard[newI][newJ] == Chessmen.WHITE_ROOK) && newI == oldI && newJ == i) {
						return true;
					}
				}
				for (int i = 0; i <= 7; i++) {
					if ((chessboard[newI][newJ] == Chessmen.EMPTY || chessboard[newI][newJ] == Chessmen.WHITE_BISHOP
							|| chessboard[newI][newJ] == Chessmen.WHITE_KING
							|| chessboard[newI][newJ] == Chessmen.WHITE_KNIGHT
							|| chessboard[newI][newJ] == Chessmen.WHITE_PAWN
							|| chessboard[newI][newJ] == Chessmen.WHITE_QUEEN
							|| chessboard[newI][newJ] == Chessmen.WHITE_ROOK) && newJ == oldJ && newI == i) {
						return true;
					}
				}
			}

			break;

		case BLACK_BISHOP:

			for (int i = 0; i <= 7; i++) {
				if ((chessboard[newI][newJ] == Chessmen.EMPTY || chessboard[newI][newJ] == Chessmen.WHITE_BISHOP
						|| chessboard[newI][newJ] == Chessmen.WHITE_KING
						|| chessboard[newI][newJ] == Chessmen.WHITE_KNIGHT
						|| chessboard[newI][newJ] == Chessmen.WHITE_PAWN
						|| chessboard[newI][newJ] == Chessmen.WHITE_QUEEN
						|| chessboard[newI][newJ] == Chessmen.WHITE_ROOK)
						&& (((newI == oldI + i) && (newJ == oldJ + i)) || ((newI == oldI - i) && (newJ == oldJ + i))
								|| ((newI == oldI - i) && (newJ == oldJ - i))
								|| ((newI == oldI + i) && (newJ == oldJ - i)))) {
					return true;
				}
			}

			break;

		case BLACK_KNIGHT:

			if (newI >= 0 || newJ <= 7) {
				if ((chessboard[newI][newJ] == Chessmen.EMPTY || chessboard[newI][newJ] == Chessmen.WHITE_BISHOP
						|| chessboard[newI][newJ] == Chessmen.WHITE_KING
						|| chessboard[newI][newJ] == Chessmen.WHITE_KNIGHT
						|| chessboard[newI][newJ] == Chessmen.WHITE_PAWN
						|| chessboard[newI][newJ] == Chessmen.WHITE_QUEEN
						|| chessboard[newI][newJ] == Chessmen.WHITE_ROOK)
						&& ((oldI == newI + 2 && oldJ == newJ + 1) || (oldI == newI + 1 && oldJ == newJ + 2)
								|| (oldI == newI - 2 && oldJ == newJ + 1) || (oldI == newI - 1 && oldJ == newJ + 2)
								|| (oldI == newI - 2 && oldJ == newJ - 1) || (oldI == newI - 1 && oldJ == newJ - 2)
								|| (oldI == newI + 2 && oldJ == newJ - 1) || (oldI == newI + 1 && oldJ == newJ - 2))) {

					return true;

				}
			}
			break;

		case BLACK_PAWN:
			if ((chessboard[newI][newJ] == Chessmen.EMPTY || chessboard[newI][newJ] == Chessmen.WHITE_BISHOP
					|| chessboard[newI][newJ] == Chessmen.WHITE_KING || chessboard[newI][newJ] == Chessmen.WHITE_KNIGHT
					|| chessboard[newI][newJ] == Chessmen.WHITE_PAWN || chessboard[newI][newJ] == Chessmen.WHITE_QUEEN
					|| chessboard[newI][newJ] == Chessmen.WHITE_ROOK)
					&& ((newI == oldI + 1 && newJ == oldJ) || (newI == oldI + 2 && newJ == oldJ))) {
				return true;
			}
			break;

		case EMPTY:
			break;
		}

		return false;

	}

	public static void main(String[] args) throws UnsupportedEncodingException {

		PrintStream out = new PrintStream(System.out, true, "UTF-8");

		Chessmen[][] chessboard = new Chessmen[8][8];
		chessboard[0][0] = Chessmen.BLACK_ROOK;
		chessboard[0][1] = Chessmen.BLACK_KNIGHT;
		chessboard[0][2] = Chessmen.BLACK_BISHOP;
		chessboard[0][3] = Chessmen.BLACK_QUEEN;
		chessboard[0][4] = Chessmen.BLACK_KING;
		chessboard[0][5] = Chessmen.BLACK_BISHOP;
		chessboard[0][6] = Chessmen.BLACK_KNIGHT;
		chessboard[0][7] = Chessmen.BLACK_ROOK;
		for (int i = 0; i < 8; i++) {
			chessboard[1][i] = Chessmen.BLACK_PAWN;
		}
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				chessboard[i][j] = Chessmen.EMPTY;
			}
		}
		for (int i = 0; i < 8; i++) {
			chessboard[6][i] = Chessmen.WHITE_PAWN;
		}
		chessboard[7][0] = Chessmen.WHITE_ROOK;
		chessboard[7][1] = Chessmen.WHITE_KNIGHT;
		chessboard[7][2] = Chessmen.WHITE_BISHOP;
		chessboard[7][3] = Chessmen.WHITE_QUEEN;
		chessboard[7][4] = Chessmen.WHITE_KING;
		chessboard[7][5] = Chessmen.WHITE_BISHOP;
		chessboard[7][6] = Chessmen.WHITE_KNIGHT;
		chessboard[7][7] = Chessmen.WHITE_ROOK;

		//

		Scanner sc = new Scanner(System.in);

		while (true) {
			printBoard(chessboard);

			System.out.println("Please input the move or exit: ");
			String userInput = sc.nextLine();
			move(chessboard, userInput);


			if (userInput.equals("exit")) {
				break;
			}
		}

	}

}
