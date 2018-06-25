import java.util.Scanner;

public class Main {
	
	private static Scanner read = new Scanner(System.in);

	public static void playGame(Hangman hangman) {
		char c;
		
		while(!hangman.theEnd()) {
			System.out.println(hangman.toString());
			System.out.print("Enter a character: ");
			c = read.next().charAt(0);
			if (hangman.checkCharacter(c) == false) {
				hangman.guess(c);
			}else {
				System.out.println("This character is already in the guessed characters");
			}
		}
	}
	
	public static void createHangman(int option) {
		Hangman hangman;
		
		if(option == 1) {
			hangman = new Hangman();
			playGame(hangman);
		}else {
			hangman = settings(); 
			playGame(hangman);
		}
	}
	
	public static Hangman settings() {
		int option, guesses;
		WordList wordList;
		String fileName;
		
		while(true) {
			System.out.println("\n*****************Settings*****************");
			System.out.println("Please choose an option: ");
			System.out.println("1. Change file");
			System.out.println("2. Change guesses number");
			System.out.println("3. Change both");
			System.out.println("0. To exit");
			System.out.print("Introduce an option: ");
			option = read.nextInt();
			read.nextLine();
			if (option == 0) {
				System.out.println("\n");
				menu();
			}
			else if(option == 1) {
				System.out.print("Introduce a file name with the format 'filename.txt': ");
				fileName = read.nextLine();
				wordList = new WordList(fileName);
				return new Hangman(wordList);
			}else if(option == 2) {
				System.out.print("Introduce number of guesses: ");
				guesses = read.nextInt();
				read.nextLine();
				return new Hangman(guesses);
			}else if(option == 3) {
				System.out.print("Introduce a file name with the format 'filename.txt': ");
				fileName = read.nextLine();
				wordList = new WordList(fileName);
				System.out.print("Introduce number of guesses: ");
				guesses = read.nextInt();
				read.nextLine();
				return new Hangman(wordList, guesses);
			}else {
				System.out.println("Your option is not valid. Please try it again!\n");
			}
		}
	}
	
	public static void menu() {
		int option;
		
		while(true) {
			System.out.println("*****************Hangman Game*****************");
			System.out.println("Please choose an option: ");
			System.out.println("1. Play game");
			System.out.println("2. Settings");
			System.out.println("0. To exit");
			System.out.print("Introduce an option: ");
			option = read.nextInt();
			read.nextLine();
			switch(option) {
			case 0: 
				return;
			case 1:
			case 2: 
				createHangman(option);
				break;
			default:
				System.out.println("Your option is not valid. Please try it again!\n");
			}
		}
	}
	
	public static void main(String[] args) {
		menu();
	}

}
