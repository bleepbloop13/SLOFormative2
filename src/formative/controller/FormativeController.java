package formative.controller;

import java.util.Scanner;

public class FormativeController
{
	private Scanner myInput;
	private int wins, losses, ties;
	private String[] RPSArray;
	
	public FormativeController()
	{
		myInput = new Scanner(System.in);
		RPSArray = new String[] {"Rock", "Paper", "Scissors"};
		wins = 0;
		losses = 0;
		ties = 0;
	}
	
	
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
		else
		{
			System.out.println("Please try again with an appropriate word.");
			playGame();
		}
	}
	
	
	
	public void start()
	{
		playGame();
	}
}
