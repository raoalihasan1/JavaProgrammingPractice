public class Book{

	private String title;
	private int items;
	private Author author;

	Book(String BookTitle, Author authorOfBook, int Item){
		title = BookTitle;
		author = authorOfBook;
		items = Item;
	}

	public String getTitle(){
		return title;
	}

	public Author getAuthor(){
		return author;
	}

	public int getItems(){
		return items;
	}

	public void setTitle(String newTitle){
		title = newTitle;
	}

	public void setAuthor(Author authorDetails){
		author = authorDetails;
	}

	public void setItems(int Item){
		items = Item;
	}

}
