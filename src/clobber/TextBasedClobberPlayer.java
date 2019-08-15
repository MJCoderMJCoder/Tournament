/* Copyright (C) Mike Zmuda - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Mike Zmuda <zmudam@miamioh.edu>, 2010-2015
 */

package clobber;
import game.*;

import java.util.*;


public class TextBasedClobberPlayer extends GamePlayer {
	public Scanner input = new Scanner(System.in);
	
	public TextBasedClobberPlayer(String n) 
	{
		super(n, "Clobber");
	}
	public GameMove getMove(GameState state, String lastMove)
	{
		ClobberMove theMove = new ClobberMove();
		System.out.println("Current board:");
		System.out.println(state);
		while (true) {
			System.out.printf("Enter your move as row1 col1 row2 col2%n");
			System.out.printf("You are currently playing %s%n", state.who);
			String moveText = input.nextLine();
			theMove.parseMove(moveText);
			if (state.moveOK(theMove)) {
				break;
			} else {
				System.out.println("Illegal move, try again");
			}
		}
		return theMove;
	}
	public static void main(String [] args)
	{
		GamePlayer p = new TextBasedClobberPlayer("Text Clobber");
		p.compete(args, 1);
	}
}
