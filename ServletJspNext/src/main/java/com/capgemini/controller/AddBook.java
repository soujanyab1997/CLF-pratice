package com.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.Dao.LibraryDao;
import com.capgemini.model.Book;
import com.capgemini.model.Library;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    LibraryDao dao=new LibraryDao();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String libraryId=request.getParameter("lid");
    	String libraryName=request.getParameter("lname");
    	String bookId=request.getParameter("bid");
		String bookName=request.getParameter("bname");
		String author=request.getParameter("author");
		String publisher=request.getParameter("pub");
		
		String bookId2=request.getParameter("bid2");
		String bookName2=request.getParameter("bname2");
		String author2=request.getParameter("author2");
		String publisher2=request.getParameter("pub2");
				
		
		
		
		PrintWriter out=response.getWriter();
		out.println(libraryId);
		out.println(libraryName);
		out.println(bookId);
		out.println(bookName);
		out.println(author);
		out.println(publisher);
		
		out.println(bookId2);
		out.println(bookName2);
		out.println(author2);
		out.println(publisher2);
		
		
		Library library=new Library();
	
		library.setLibraryId(libraryId);
		library.setLibraryName(libraryName);
		
		
		Book books=new Book();
		books.setBookId(bookId);
		books.setBookName(bookName);
		books.setAuthor(author);
		books.setPublisher(publisher);
		books.setLibrary(library);
		library.getBook().add(books);
		
		
		Book books2=new Book();
		books2.setBookId(bookId2);
		books2.setBookName(bookName2);
		books2.setAuthor(author2);
		books2.setPublisher(publisher2);
		books2.setLibrary(library);
		library.getBook().add(books2);
		
		
		dao.add(library);

	}

}
