package hu.evosoft.javasetraining.solid;

public class Book {

	private String name;
	private String author;
	private String text;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	 // methods that directly relate to the book properties
    public String replaceWordInText(String word){
        return text.replaceAll(word, text);
    }
 
    public boolean isWordInText(String word){
        return text.contains(word);
    }
    
    void printTextToConsole(){
        // our code for formatting and printing the text
    }
}