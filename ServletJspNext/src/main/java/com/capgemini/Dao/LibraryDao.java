/**
 * 
 */
package com.capgemini.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.model.Book;
import com.capgemini.model.Library;

/**
 * @author mahes
 *
 */
public class LibraryDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("my");
	EntityManager em = emf.createEntityManager();

	public void add(Library library) {
		System.out.println("hii");
		em.getTransaction().begin();
		em.persist(library);
		em.getTransaction().commit();
		em.close();
		emf.close();
	
	}
	
	
	  public Library findBook(String libraryId) { return
	  em.find(Library.class,libraryId); }
	 
	  public Book findBookID(String bookId) { return
			  em.find(Book.class,bookId); }
			 
	  
	  public void deleteBook(String libraryId) {
	  
	  em.getTransaction().begin(); Library l = findBook(libraryId); em.remove(l);
	  em.getTransaction().commit();
		
		
		
	}


	public Book updateBookDetails(String nbId, String nBName, String nBauthr, String nBpubshr) {
		// TODO Auto-generated method stub
		
		Book b = findBookID(nbId);
		em.getTransaction().begin();
	    b.setBookName(nBName);
		b.setAuthor(nBauthr);
		b.setPublisher(nBpubshr);
		em.getTransaction().commit();
		return b;
	}

}
