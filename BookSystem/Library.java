public class Library{

	private int currentNumberOfUniqueBooks;
	private static Book[] bookList;

	Library(int NoUniqueBooks){
		currentNumberOfUniqueBooks = NoUniqueBooks;
		bookList = new Book[currentNumberOfUniqueBooks];
	}

	public void addBook(Book newBook){
		for(int x = 0; x < bookList.length; x++){
			if(bookList[x] == null){
				bookList[x] = newBook;
				break;
			}
		}
	}

	public void whichBooks(){
		System.out.println("This Is The List Of Books:");
		for(int x = 0; x < bookList.length; x++){
			if(bookList[x] == null){
				break;
			}
			System.out.println(" - " + bookList[x].getTitle());
		}
		System.out.println("");
	}
	
	public void whichAuthors(){
		System.out.println("This Is The List Of Authors:");
		for(int x = 0; x < bookList.length; x++){
			if(bookList[x] == null){
				break;
			}
			System.out.println(" - " + bookList[x].getAuthor().getAuthorName());
		}
		System.out.println("");
	}
	
	public void borrowBook(Book bookBorrowed){
		for(int x = 0; x < bookList.length; x++){
			if(bookList[x] == null){
				break;
			} 
			else if(bookBorrowed.getTitle() == bookList[x].getTitle()){
				if(bookList[x].getItems() > 0){
					bookList[x].setItems(bookList[x].getItems() - 1);
					System.out.println(bookBorrowed.getTitle() + " Has Been Booked For You\n");
				} else {
					System.out.println(bookBorrowed.getTitle() + " Is Not Available\n");
				}
			}
		}
	}
	
	public void returnBook(Book bookReturned){
		for(int x = 0; x < bookList.length; x++){
			if(bookList[x] == null){
				break;
			} else if(bookReturned.getTitle() == bookList[x].getTitle()){
				bookList[x].setItems(bookList[x].getItems() + 1);
				System.out.println(bookReturned.getTitle() + " Was Succesfully Returned\n");
			}
		}
	}

	public static void main(String[] args){
		System.out.println("Starting My New Library\n");
		//1. Create library
		Library l= new Library(100);
		//2. Populate library
		//Add 'Oscar Wilde' as a new author
		Author a1 = new Author("Oscar Wilde", 1889);
		//Add three items of 'The Importance of Being Earnest' to the library
		Book b1 = new Book("The Importance of Being Earnest", a1, 3);
		l.addBook(b1);
		//Add two items of 'The Picture of Dorian Gray' to the library
		Book b2 = new Book("The Picture of Dorian Gray", a1, 2);
		l.addBook(b2);
		//Add 'Charles Dickens' as a new author
		Author a2 = new Author("Charles Dickens", 1812);
		//Add three items of 'The Picture of Oliver Twist' to the library
		Book b3 = new Book("Oliver Twist", a2, 3);
		l.addBook(b3);
		//3. Explore library
		l.whichBooks();
		l.whichAuthors();
		//4. Interact with the library
		//Borrow Oliver Twist
		l.borrowBook(b3);
		//Return Oliver Twist
		l.returnBook(b3);
		//Borrow more than available
		l.borrowBook(b2);
		l.borrowBook(b2);
		l.borrowBook(b2);
	}

}
