package com.capg.ticTacToegame;

import java.util.Scanner;

enum Turn{
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

		System.out.println("Enter your choice 'X' or 'O'");
		char playerChoice = sc.next().charAt(0);
		computerChoice(playerChoice);
		
		String firstChance = firstChance();
		System.out.println(firstChance + " Plays First");
		
		System.out.println("Enter the index location");
		int index = sc.nextInt();
		playerMove(index, playerChoice);
		printBoard();
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
	
	//UC6
	private static String firstChance() {
		int toss = (int)Math.floor((Math.random()*10)%2);
		if(toss == HEAD)
			return Turn.PLAYER.toString();
		else
			return Turn.COMPUTER.toString();
	}
}