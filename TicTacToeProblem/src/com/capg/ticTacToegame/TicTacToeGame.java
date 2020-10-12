package com.capg.ticTacToegame;

import java.util.Scanner;

public class TicTacToeGame {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		createBoard();
	}
	
	public static char[] createBoard() {
		char[] ticTacBoard = new char[10];
		for (int i = 0; i < 10; i++) {
			ticTacBoard[i] = ' ';
		}
		return ticTacBoard;
	}
}