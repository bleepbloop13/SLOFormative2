package formative.controller;

import java.util.Scanner;
/**
 * A program the plays Rock, Paper, Scissors with the user.
 * @author Rory Baker
 * @version 1.0 3/23/16
 */
public class FormativeController
{
	private Scanner myInput;
	private int wins, losses, ties;
	private String[] RPSArray;
	
	/**
	 * Constructor, instantiates all objects and primitives.
	 */
	public FormativeController()
	{
		myInput = new Scanner(System.in);
		RPSArray = new String[] {"Rock", "Paper", "Scissors"};
		wins = 0;
		losses = 0;
		ties = 0;
	}
	
	/**
	 * Using Scanner, takes a user's input, and tests to make sure it is one of the appropriate answers.
	 * If the input is Rock, Paper, or Scissors, the computer chooses one at random, and the answers are compared.
	 * Rock beats Scissors, Scissors beats Paper, and Paper beats Rock.
	 * If the user inputs Quit. The System outputs the players wins, losses, and ties, then the program terminates.
	 */
	private void playGame()
	{
		System.out.println("Welcome to Rock, Paper, Scissors. Enter either Rock, Paper, or Scissors to play! Enter Quit to stop playing.");
		String input = myInput.nextLine();
		if(input.equalsIgnoreCase("Rock") || input.equalsIgnoreCase("Paper") || input.equalsIgnoreCase("Scissors") || input.equalsIgnoreCase("Quit"))
		{
			if(input.equalsIgnoreCase("Quit"))
			{
				System.out.println("Thank You for playing. You had " + wins + " wins, " + losses + " losses, and " + ties + " ties.");
			}
			else
			{
				int randomValue = (int) (Math.random() * 2);
				String computerAnswer = RPSArray[randomValue];
				System.out.println("You entered: " + input + ", and the computer entered: " + computerAnswer + ".");
				if(input.equalsIgnoreCase(computerAnswer))
				{
					System.out.println("You and the computer have tied");
					ties++;
				}
				if(input.equalsIgnoreCase("Rock") && computerAnswer.equalsIgnoreCase("Paper"))
				{
					System.out.println("You have lost this round.");
					losses++;
				}
				if(input.equalsIgnoreCase("Paper") && computerAnswer.equalsIgnoreCase("Scissors"))
				{
					System.out.println("You have lost this round.");
					losses++;
				}
				if(input.equalsIgnoreCase("Scissors") && computerAnswer.equalsIgnoreCase("Rock"))
				{
					System.out.println("You have lost this round.");
					losses++;
				}
				if(input.equalsIgnoreCase("Paper") && computerAnswer.equalsIgnoreCase("Rock"))
				{
					System.out.println("You have won this round.");
					wins++;
				}
				if(input.equalsIgnoreCase("Scissors") && computerAnswer.equalsIgnoreCase("Paper"))
				{
					System.out.println("You have won this round.");
					wins++;
				}
				if(input.equalsIgnoreCase("Rock") && computerAnswer.equalsIgnoreCase("Scissors"))
				{
					System.out.println("You have won this round.");
					wins++;
				}
				playGame();
			}
		}
		//If the input is an inappropriate word, restarts the method.
		else
		{
			System.out.println("Please try again with an appropriate word.");
			playGame();
		}
	}
	
	
	/**
	 * Launches the program.
	 */
	public void start()
	{
		playGame();
	}
}
