import java.util.ArrayList;
import java.util.List;

public class Hangman {
	
	private WordList wordList;
	private int guesses;
	private String word;
	private List<Character> guessedWordList;
	private String hiddenWord;
	
	public Hangman() {
		this.wordList = new WordList();
		this.guesses = 10;
		this.word = this.wordList.selectRandomWordFromWordList();
		this.guessedWordList = new ArrayList<Character>();
		this.hiddenWord = this.createHiddenWord();
	}
	
	public Hangman(int guesses) {
		this.wordList = new WordList();
		this.guesses = guesses;
		this.word = this.wordList.selectRandomWordFromWordList();
		this.guessedWordList = new ArrayList<Character>();
		this.hiddenWord = this.createHiddenWord();
	}
	
	public Hangman(WordList wordList) {
		this.wordList = wordList;
		this.guesses = 10;
		this.word = this.wordList.selectRandomWordFromWordList();
		this.guessedWordList = new ArrayList<Character>();
		this.hiddenWord = this.createHiddenWord();
		//System.out.println(this.toString());
	}
	
	public Hangman(WordList wordList, int guesses) {
		this.wordList = wordList;
		this.guesses = guesses;
		this.word = this.wordList.selectRandomWordFromWordList();
		this.guessedWordList = new ArrayList<Character>();
		this.hiddenWord = this.createHiddenWord();
		//System.out.println(this.toString());
	}
	
	public WordList getWordList() {
		return this.wordList;
	}
	
	public int getGuesses() {
		return this.guesses;
	}
	
	public String getWord() {
		return this.word;
	}
	
	public List<Character> getGuessedWordList() {
		return this.guessedWordList;
	}
	
	public void setWordList(WordList wordList) {
		this.wordList = wordList;
	}
	
	public void setGuesses(int guesses) {
		this.guesses = guesses;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public void setGuessedWordList(List<Character> guessedWordList) {
		this.guessedWordList = guessedWordList;
	}
	
	public boolean guess(Character character) {
		boolean found = false;
		String[] word = this.word.split("");
		
		int count = this.word.length() - this.word.replaceAll(Character.toString(Character.toLowerCase(character)),"").length();

		if (count == 1) {
			int index = this.word.indexOf(Character.toLowerCase(character));
			this.hiddenWord = modifyHiddenWord(character, index);
			found = true;
		}else if (count > 1) {
			for(int i = 0; i < this.word.length(); i++) {
				if(Character.toString(character).equalsIgnoreCase(word[i])) {
					this.hiddenWord = modifyHiddenWord(character, i);
					found = true;
				}
			}
		}else {
			found = false;
			this.guesses--;
		}
		this.guessedWordList.add(character);
		
		return found;
	}
	
	public int guessesLeft() {
		return this.guesses;
	}
	
	public String word() {
		return this.word;
	}
	
	public List <Character> guesses() {
		return this.guessedWordList;
	}
	
	public String createHiddenWord() {
		String hiddenWord = "";
		
		for(int i = 0; i < this.word.length(); i++) {
			hiddenWord = hiddenWord + "_";
		}
		
		return hiddenWord;
	}
	
	public String modifyHiddenWord(Character character, int index) {
		String n;
		
		n = this.hiddenWord.substring(0,index) + character + this.hiddenWord.substring(index + 1);
		
		return n;
	}
	
	public boolean theEnd() {
		boolean end;
		
		if (this.guesses == 0) {
			end = true;
			System.out.println("The word was: " + this.word + "\nYOU LOSE :(\n");
		}else if (this.hiddenWord.equalsIgnoreCase(word)){
			end = true;
			System.out.println("The word was: " + this.word + "\nYOU WIN ;)\n");
		}else {
			end = false;
		}
		return end;
	}
	
	public String guessedList() {
		int i = 0;
		String guessedList = "";
		
		while(i < this.guessedWordList.size()) {
			guessedList = guessedList + this.guessedWordList.get(i) + " ";
			i++;
		}
		return guessedList;
	}
	
	public boolean checkCharacter(Character character) {
		boolean contains = false;
		
		if (this.getGuessedWordList().contains(character)) {
			contains = true;
		}
		
		return contains; 
	}
	
	public String toString() {
		return "\nThe hidden word has: " + this.word.length() + " characters\tGuesses left: " + this.guesses  + "\nGuessed characters: "+ this.guessedList() + "\n" + this.hiddenWord;
	}
}
