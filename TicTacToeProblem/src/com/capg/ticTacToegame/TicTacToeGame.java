package com.capg.ticTacToegame;

import java.util.Scanner;

public class TicTacToeGame {
	static Scanner sc = new Scanner(System.in);

	private static final char Character_X = 'X';
	private static final char Character_Y = 'O';

	public static void main(String[] args) {
		createBoard();
		System.out.println("Enter your choice 'X' or 'O'");
		playerChoice(sc.next().charAt(0));
	}

	public static char[] createBoard() {
		char[] ticTacBoard = new char[10];
		for (int i = 1; i < 10; i++) {
			ticTacBoard[i] = ' ';
		}
		return ticTacBoard;
	}

	public static char playerChoice(char playerChoice) {
		char computerChoice;
		if (playerChoice == Character_X) {
			computerChoice = Character_Y;
		} else {
			computerChoice = Character_Y;
		}
		return computerChoice;
	}
}
