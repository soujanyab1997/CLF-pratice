package com.capg.Dao;

import com.capg.model.Book;
import com.capg.model.Library;

public interface LibraryDaoInterface {
	public void add(Library library);
	public Library findBook(String libraryId);
	public Book findBookID(String bookId);
	public void deleteLibrary(String libraryId);
	public void deleteBook(String bookId);
	public Book updateBookDetails(String nbId, String nBName, 
			String nBauthr, String nBpubshr);
		

}
