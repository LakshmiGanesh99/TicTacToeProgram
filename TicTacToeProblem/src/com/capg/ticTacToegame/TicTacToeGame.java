package com.capg.ticTacToegame;

import java.util.Scanner;

enum Turn {
	PLAYER, COMPUTER
}

public class TicTacToeGame {

	static Scanner sc = new Scanner(System.in);

	private static final char CHARACTER_X = 'X';
	private static final char CHARACTER_O = 'O';
	private static final int HEAD = 0;

	// main
	public static void main(String[] args) {

		createBoard();
		System.out.println("Please select your choice(X/O):");
		char playerChoice = sc.next().charAt(0);
		char computerChoice = computerChoice(playerChoice);
		String whoPlays = firstChance();
		System.out.println("First Chance given to: " + whoPlays);
		String gameStatus = checkStatus(playerChoice);
		String showResult = "Game is on";
		while (gameStatus.equals("CHANGE")) {
			if (whoPlays.equals("PLAYER")) {
				System.out.println("Please select a position(1-9): ");
				int index = sc.nextInt();
				playerMove(index, playerChoice);
				gameStatus = checkStatus(playerChoice);
				if (gameStatus.equals("WIN")) {
					showResult = "Player Won!";
				} else if (gameStatus.equals("TIE")) {
					showResult = "Match Tie!";
				} else {
					whoPlays = "COMPUTER";
				}
				printBoard();
			} else {
				System.out.println("Please select a position(1-9) for Computer: ");
				int index = computerIndex(computerChoice);
				System.out.println(index);
				playerMove(index, computerChoice);
				gameStatus = checkStatus(computerChoice);
				if (gameStatus.equals("WIN")) {
					showResult = "Computer Won!";
				} else if (gameStatus.equals("TIE")) {
					showResult = "Match Tie!";
				} else {
					whoPlays = "PLAYER";
				}
				printBoard();
			}
		}
		System.out.println(showResult);
	}

	static char[] ticTacBoard;

	// UC1
	public static char[] createBoard() {
		ticTacBoard = new char[10];
		for (int i = 0; i < 10; i++) {
			ticTacBoard[i] = ' ';
		}
		return ticTacBoard;
	}

	// UC2
	public static char computerChoice(char playerChoice) {
		char computerChoice;
		if (playerChoice == CHARACTER_X) {
			computerChoice = CHARACTER_O;
		} else {
			computerChoice = CHARACTER_X;
		}
		return computerChoice;
	}

	// UC3
	public static void printBoard() {
		System.out.println(" " + ticTacBoard[1] + " | " + ticTacBoard[2] + " | " + ticTacBoard[3]);
		System.out.println("-----------");
		System.out.println(" " + ticTacBoard[4] + " | " + ticTacBoard[5] + " | " + ticTacBoard[6]);
		System.out.println("-----------");
		System.out.println(" " + ticTacBoard[7] + " | " + ticTacBoard[8] + " | " + ticTacBoard[9]);
	}

	// UC4
	public static int selectIndex(int index) {
		while (!(index > 0 && index < 10)) {
			System.out.println("Enter proper index value from 1-9");
			index = sc.nextInt();
		}

		return index;
	}

	public static int checkForFreeSpace(int index) {
		index = selectIndex(index);
		while (ticTacBoard[index] != ' ') {
			System.out.println("Your selection is not a free space. Enter new index.");
			index = sc.nextInt();
		}
		return index;
	}

	// UC5
	public static void playerMove(int index, char choice) {
		index = checkForFreeSpace(index);
		ticTacBoard[index] = choice;
	}

	// UC6
	public static String firstChance() {
		int toss = (int) Math.floor((Math.random() * 10) % 2);
		if (toss == HEAD)
			return Turn.PLAYER.toString();
		else
			return Turn.COMPUTER.toString();
	}

	// UC7
	public static boolean checkTie() {
		boolean tie = true;
		for (int i = 1; i < 10; i++) {
			if (ticTacBoard[i] == ' ') {
				tie = false;
			}
		}
		return tie;
	}

	public static String checkStatus(char selectdCharacter) {
		String status;
		if ((ticTacBoard[1] == selectdCharacter && ticTacBoard[2] == selectdCharacter
				&& ticTacBoard[3] == selectdCharacter)
				|| (ticTacBoard[4] == selectdCharacter && ticTacBoard[5] == selectdCharacter
						&& ticTacBoard[6] == selectdCharacter)
				|| (ticTacBoard[7] == selectdCharacter && ticTacBoard[8] == selectdCharacter
						&& ticTacBoard[9] == selectdCharacter)
				|| (ticTacBoard[1] == selectdCharacter && ticTacBoard[4] == selectdCharacter
						&& ticTacBoard[7] == selectdCharacter)
				|| (ticTacBoard[2] == selectdCharacter && ticTacBoard[5] == selectdCharacter
						&& ticTacBoard[8] == selectdCharacter)
				|| (ticTacBoard[3] == selectdCharacter && ticTacBoard[6] == selectdCharacter
						&& ticTacBoard[9] == selectdCharacter)
				|| (ticTacBoard[1] == selectdCharacter && ticTacBoard[5] == selectdCharacter
						&& ticTacBoard[9] == selectdCharacter)
				|| (ticTacBoard[3] == selectdCharacter && ticTacBoard[5] == selectdCharacter
						&& ticTacBoard[7] == selectdCharacter)) {
			status = "WIN";
		} else if (checkTie()) {
			status = "TIE";
		} else {
			status = "CHANGE";
		}
		return status;
	}

	// UC8
	public static int computerIndex(char choice) {
		char[] copyBoard = new char[10];
		for (int i = 0; i < 10; i++) {
			copyBoard[i] = ticTacBoard[i];
		}
		int index = 0;
		for (int i = 1; i < 10; i++) {
			if (copyBoard[i] == ' ') {
				copyBoard[i] = choice;
				String status = checkStatus(choice);
				if (status.equals("WIN")) {
					index = i;
				}
				copyBoard[i] = ' ';
			}
		}
		if (index == 0) {
			for (int j = 1; j < 10; j++) {
				if (copyBoard[j] == ' ') {
					index = j;
				}
			}
		}
		return index;
	}
}