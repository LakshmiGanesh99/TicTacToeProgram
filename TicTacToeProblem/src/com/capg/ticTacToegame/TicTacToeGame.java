package com.capg.ticTacToegame;

import java.util.Scanner;

public class TicTacToeGame {

	static Scanner sc = new Scanner(System.in);

	private static final char CHARACTER_X = 'X';
	private static final char CHARACTER_Y = 'Y';

	public static void main(String[] args) {

		createBoard();
		System.out.println("Enter your choice 'X' or 'O'");
		playerChoice(sc.next().charAt(0));
	}

	public static char[] createBoard() {
		char[] ticTacBoard = new char[10];
		for (int i = 0; i < 10; i++) {
			ticTacBoard[i] = ' ';
		}
		return ticTacBoard;
	}

	public static char playerChoice(char playerChoice) {
		char computerChoice;
		if (playerChoice == CHARACTER_X) {
			computerChoice = CHARACTER_Y;
		} else {
			computerChoice = CHARACTER_X;
		}
		return computerChoice;
	}
}