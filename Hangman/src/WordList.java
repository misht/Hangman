import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordList {

	private List<String> wordList;
	private String fileName;
	
	public WordList() {
		this.fileName = "WordList.txt";
		this.wordList = this.giveWords();
	}
	
	public WordList(String fileName) {
		this.fileName = fileName;
		this.wordList = this.giveWords();
	}
	
	public List<String> getWordList() {
		return this.wordList;
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	public int getSize() {
		return this.wordList.size();
	}
	
	public String getWordIndex(int index) {
		return this.wordList.get(index);
	}
	
	public void setWordList(List<String> wordList) {
		this.wordList = wordList;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public List<String> giveWords() {
		String word = null;
		List<String> wordList = new ArrayList<String>(); 
		
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(this.fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((word = bufferedReader.readLine()) != null) {
            	wordList.add(word);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + this.fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + this.fileName + "'");
        }
        return wordList;
	}
	
	public String selectRandomWordFromWordList() {
		Random random = new Random();
		int index;
		String word;
		
		index = random.nextInt(this.wordList.size());
		word = this.wordList.get(index);
		
		return word;
	}
	
	public String toString() {
		return "File name: " + this.fileName;
	}
}
