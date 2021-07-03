package game;
/*
 * Name: Taim Alsaaid
 * Date: 27/May/2021
 * Description: A game of hangman.
 */
import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class Hangman {
	
	static Scanner number = new Scanner(System.in);// create numbers scanner
	static Scanner word = new Scanner(System.in);// create words scanner	

	
	/**
	 * Choose a random word
	 * @param words
	 * @return current word
	 */
	public static String wordPick(String words[]) {
		
		Random rand = new Random();// create randomizer
		
		int randNum = rand.nextInt((words.length - 1) + 1) + 1;// assign random number to randNum
		String current = "";// create variable for current word
		
		// check for the index number that equals rundNum, then assign the word in the array "word" with that index to current.
		for (int i = 0; i < words.length - 1; i++) {
			
			if (i == randNum) {
				
				current = words[i];
				break;
			}
		}
		
		current = current.toLowerCase();// make the word lower case as to avoid case related problems when guessing
		
		return current;// return the word that will be used
	}
	
	
	
	/**
	 * Main Menu
	 * @return option chosen
	 */
	public static void mainMenu() {

		System.out.println("\n********************************");
		System.out.println("Press (R) to view instructions <--- Recommended");
		
	  System.out.println("\n     **** Main Menu ****   ");
		System.out.println("           Play (1)        ");
		System.out.println("       Custom Words (2)    ");
		System.out.println("        Difficulty (3)     ");
		System.out.println("           Quit (4)        ");

		System.out.println("********************************");
				
	}

	
	
	/**
	 * Print out instructions
	 */
	public static void instructions() {

		System.out.println("********************************");
		System.out.println("Instructions:");
		System.out.println("When starting the game, you'll be presented with dashed lines that represent the letters in the unguessed word.");
		System.out.println("You will also view how many lives you have left, alongside the letters you've used already");

		System.out.println("You have to start guessing letters until you form a word.");
		System.out.println("You can also type out the word if you know it");
		System.out.println("");
		
		System.out.println("Back (0)");

	}
	
	
	
	/**
	 * Custom Words
	 */
	public static String customWords() throws Exception {

		String option = "";
		String back = "";
		
		System.out.println("********************************");
		System.out.println("Would you like to add custom words?");
		System.out.println("Yes (1), No (2)");
		
		do {// repeat if user doesn't enter 1 or 2
			
			option = word.nextLine(); // ask for input
		} while (!option.equals("1") && !option.equals("2"));
		
		// check custom words option chosen
		if (option.equals("1")) {
			
			System.out.println("");
			String custom;// create string that will hold custom word input
			System.out.println("Please type in the words you want to use. (Press enter after each word)");
			System.out.println("Type (0) to stop");
			
			PrintWriter output = new PrintWriter(new FileWriter("hangman.txt", true));// create printWriter and assign to the file with words.
			
			do { // do while loop for custom words user input
				
				custom = word.nextLine();// get user input
				
				// if the user types "0", then stop input (break the loop)
				if (!custom.equals("0")) {
					
					output.println(custom);
				} else {
					
					break;
				}
				
			} while (!custom.equals("0"));
			
			output.close();// close print writer
			
			System.out.println("********************************");
			
			back = "0";// set back to 0
			
		}else if (option.equals("2")) { // if back equals 0 then go back to menu
			
			back = "0";
		}
		
		
		return back;
	}
	
	
	/**
	 * Print out difficulty
	 */
	public static void difficulty() {
		
		System.out.println("********************************");
		System.out.println("Please choose your difficulty");

		System.out.println("Easy (1): If you get letter wrong -1 life, if you get word wrong -2 lives.");
		System.out.println("Medium (2): If you get letter wrong -2 life, if you get word wrong -4 lives.");
		System.out.println("Hard (3): If you get letter wrong -4 life, if you get word wrong -8 lives.");
		System.out.println("Extreme (4): No room for errors, 1 mistake and you're gonna have to retake");
		System.out.println("Unholy (5): No guessing, No chances, if you don't guess the word on first try, you lose.");

	}
	
	/**
	 * Main Method
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		
		// Variables to be used later in the program
		String diff = "Easy";// difficulty (default of easy)
		int lifeLoss = 1;// how many lives lost per mistake (depends on difficulty)
		
		
		
		// Variables used for menu and instructions:
		String option = ""; // will be filled with user input to decide from menu
		String back = "";// will be used to go back to main menu
		boolean newWord; // will be used to play a new word
		
		// Greetings, instructions, and menu
		System.out.println("                           |/|");
		System.out.println("       _____               | |");
		System.out.println("      |    \\|              |/|");
		System.out.println("     (x)    |             (___)");
		System.out.println("     \\|/    |             (___)");
		System.out.println("      |     |             (___)");
		System.out.println("     / \\    |             (___)");
		System.out.println("     _______|___          // \\\\");
		System.out.println("                         //   \\\\");
		System.out.println("                        ||     ||");
		System.out.println("                        ||     ||");
		System.out.println("                         \\\\___//");
		System.out.println("                          ----- ");

		System.out.println("\nHello user! Welcome to hangman, a fun, easy, and quick game where you try to guess the word!");
		

		
		do {// repeat for game
			do {// repeat for difficulty
				do {// repeat for custom words
					do {// repeat for instructions
						
						mainMenu();// call main menu
						
						do {// repeat input if user inputs nothing
						
						back = "";// will be used to go back to main menu
						option = word.nextLine(); // ask for option input
						} while (!option.equalsIgnoreCase("r") && !option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4"));
						
						//check option chosen from Main Menu
						
						if (option.equalsIgnoreCase("R")) { //Instructions
							
							instructions();// call instructions method
							
							do {// repeat input if user inputs nothing
								
								back = word.nextLine();
							} while (!back.equals("0"));

							System.out.println("********************************");
						}
					} while (back.equals("0"));
			
					
					
					
					
						if (option.equals("2")) { // custom words
							
							back = customWords();
						}
				} while(back.equals("0"));
					
					
				
					
				if (option.equals("3")) {// difficulty
					
					difficulty();
					
					option = word.nextLine();
					
					// check for difficulty choice
					if (option.equals("1")) {
						
						lifeLoss = 1;
						diff = "Easy :)";
					} else if (option.equals("2")) {
						
						lifeLoss = 2;
						diff = "Medium :/";
					}else if (option.equals("3")) {
						
						lifeLoss = 4;
						diff = "Hard :(";
					}else if (option.equals("4")) {
						
						lifeLoss = 10;
						diff = "EXTREME >:{";
					} else if (option.equals("5")) {
						
						lifeLoss = 10;
						diff = "Unholy æ–‡å—åŒ–ã"; 
					}
					
					System.out.println("Difficulty chosen: " + diff);
					System.out.println("********************************");
					
					back = "0";// set back to 0
				}
			} while (back.equals("0"));
				
				
				
			
			
			
				if (option.equals("1")) {// PLAY HANGMAN
					
					System.out.println("********************************");
					System.out.println("    ***** Goodluck! *****       ");
					
					// Get words from file
					File wordsFile = new File("hangman.txt");// import file
					Scanner count = new Scanner(wordsFile);// create file scanner to find number of words
					Scanner file = new Scanner(wordsFile);// create file scanner to input words
		
					
					int counter = 0;// create counter to set size for words array
					
					// find out how many words are in the file
					while (count.hasNext()) {
						counter++;// increase counter
						@SuppressWarnings("unused")
						String decoyWord = count.next();// create decoy String to move the scanner to the new word
						
					}
					
					String[] words = new String[counter];// create array to hold words
					
					//import the words into the array
					counter = 0;// reset counter
					while (file.hasNext()) {
						
						words[counter] = file.next();// assign word being scanned to array
						counter++;// increase counter
					}
					
					
					do { // do while loop to play a new word
					
						String current = wordPick(words);// assign random word to current words variable (METHOD)
						
						int lives = 10;// create variable that will represent lives
						
						String[] alpha = new String[1000];// create array to hold letters user enters
						int alphaIndex = 0;// used to increase the index of alpha after each letter
						
						String fullEmpty = "-".repeat(current.length());// create and fill in a string with dashes respecting the length of the current word
						char[] emptyChar = new char[fullEmpty.length()];// create character array and set its size to fullEmpty's size.
						
						// fill in emptyChar with components of fullEmpty
						for (int i = 0; i < emptyChar.length; i++) {
							
							emptyChar[i] = fullEmpty.charAt(i);
							
						}
					
						boolean done = false; // will be used if lives are drained or word is guessed
						
						do { //do while loop to repeat word guessing from user
							
							System.out.println("\n ");
							System.out.println("********************************");
							System.out.println("Difficulty: " + diff);
							System.out.println(" ");
							System.out.println("You have " + lives + " lives left");// inform of how many lives the user has left
							
							// fill in any null spaces in alpha, with empty space (as to not get ignored in sorting process)
							for (int i = 0; i < alpha.length; i++) {
								
								if (alpha[i] == null) {
									
									alpha[i] = "";
								}
								
							}
							
							//bubble sort alphabet array
							for (int i = 0; i < alpha.length - 1; i++) {
								for (int j = 0; j < alpha.length - 1 - i; j++) {
									
									if (alpha[j] != null && alpha[j+1] != null) {
										if (alpha[j].compareTo(alpha[j+1]) > 0) {
										
											String temp = alpha[j];
											alpha[j] = alpha[j + 1];
											alpha[j + 1] = temp;
										}
									}
								}
							}
							
							System.out.println(" ");
							System.out.println("The letters you've used: ");
							
							// print out letters in alpha (letters used)
							for (int i = 0; i < alpha.length; i++) {
								
								if (alpha[i] != "") {
									System.out.print(alpha[i] + " | ");
								}
							}
							
							System.out.println(" ");
							System.out.println(" ");
							System.out.println("The word: ");
							
							// print out dashed lines in emptyChar
							for (int i = 0; i < emptyChar.length; i++) {
								
								System.out.print(emptyChar[i]);
							}
							
							String input;// used to store user input
							boolean asses = false;// used to asses if the user got a letter correct or no, to decide to drain lives or not
							boolean letter = true;// used to asses if a letter or word was input to decide on life loss
							
							System.out.print("\nEnter a letter or guess the word: ");
							input = word.nextLine();// user input
							System.out.println("********************************");
							
							// check input
							if (input.length() == 1) {// if a letter is entered
								
								letter = true;// assign to to the letter variable
								
								for (int i = 0; i < current.length(); i++) {// repeat as many times as the length of the current word
									
									if (current.charAt(i) == input.charAt(0)) {// if equal, then change the dashed lines
										
										emptyChar[i] = input.charAt(0);	
										asses = true;
									}	
										
								}
								
								boolean intoAlpha = true;// boolean to decide weather to put letter in alpha array or not
								for (int i = 0; i < alpha.length; i++) {// check if letter is already in array
									
									if (alpha[i].equals(input)) {
									
										intoAlpha = false;
										break;
									}
								}
								
								if (intoAlpha == true) {// if the letter isnt already inn array then put it in
									
									alpha[alphaIndex] = input;// get letter into the alphabet array
								}
								alphaIndex++;// increase index of alpha variable, to move on to next index
								
								
								
							} else if (input.length() >= 2) {// if a word is entered (aka 2+ letters)
								
								letter = false; // assign false to the letter variable
								
								for (int i = 0; i < current.length(); i++) {// repeat as many times as the length of the current word
									
									if (current.equals(input)) {// if equal, then change the dashed lines
										
										emptyChar[i] = input.charAt(i);	
										asses = true;
									}	
								}	
							}
							
							
							
							// take away lives, if the word/letter is wrong.
							if (asses == false) {// if the guess is wrong
								
								if (letter == true) {// if it was a letter -lifeloss (depends on difficulty)

									lives = lives - lifeLoss;
								} else if (letter == false) {// if it was a word -lifeloss*2 (depends on difficulty)
									
									lives = lives - lifeLoss*2;
								}
							}
							
							// if difficulty equals unholy, and the word was wrong, then deplete lives
							if (diff.equals("Unholy æ–‡å—åŒ–ã") && letter == true) {
								
								lives = 0;
							}
							
							alphaIndex++;// increase the index of the alpha array as to move to the next letter
							
							String emptyFull;// used to asses if the word up until now has been guessed
								
							emptyFull = String.valueOf(emptyChar);// assign empty full emptyChar as 1 word
							
							// Check if the letters guessed form the word in current up until now (decides to end game)
							// Or if lives are drained
							if (current.equals(emptyFull) || lives <= 0) {
								
								done = true;
							} else if (!current.equals(emptyFull)) {
								
								done = false;
							}
							
							
						} while (done == false);
						
						System.out.println("The word: \n" + current);// output the word after game is over
						
						// endgame message
						if (lives <= 0) {
							System.out.println(" ");
							System.out.println("*** GAME OVER ***");
						} else {
							System.out.println(" ");
							System.out.println("*** CONGRATULATIONS, YOU WON! ***");
						}
				
						newWord = false;// initialize variable responsible for getting new word
						
						//get user input if back to menu or new word
						System.out.println("\n\nMain Menu (0)");
						System.out.println("New word (1)");
						System.out.println("Quit (2)");
						
						do {// repeat if input want an option
							
							option = word.nextLine();
						} while(!option.equals("0") && !option.equals("1") && !option.equals("2"));

						
						
						if (option.equals("0")) {
							
							newWord = false;
							back = "0";
						} else if (option.equals("1")) { 
							
							newWord = true;
							back = "1";
						} else if (option.equals("2")) { 
							
							newWord = false;
							back = "1";
							option = "4";
						} 
				
				} while (newWord == true);
				
					//close file scanners.
					count.close();
					file.close();
					
			}
				
		} while (back.equals("0"));
		
		if (option.equals("4")) {
			
			System.out.println("\n********************************");
			System.out.println("Goodbye!");
			
		}
		

	}
}
