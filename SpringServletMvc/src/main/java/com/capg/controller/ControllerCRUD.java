package com.capg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capg.Dao.LibraryDao;
import com.capg.Dao.LibraryDaoInterface;
import com.capg.model.Book;
import com.capg.model.Library;
@Controller
public class ControllerCRUD {
LibraryDaoInterface dao=new LibraryDao();
	
	@RequestMapping("/addBook")
	public void addBook(HttpServletRequest request,HttpServletResponse response) throws IOException 
	{
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
	
	
	@RequestMapping("/deleteLibrary")
	public void deleteLibrary(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		LibraryDaoInterface dao = new LibraryDao();
		dao.deleteBook(request.getParameter("did"));
		out.println("Library ID "+request.getParameter("did")+" deleted. ");
	}
	@RequestMapping("/deleteBook")
	public void deleteBook(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		LibraryDaoInterface dao = new LibraryDao();
		dao.deleteBook(request.getParameter("bdid"));
		out.println("Book ID "+request.getParameter("bdid")+" deleted.");
	}
	
	@RequestMapping("/searchBook")
	public void searchBook(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Library l = dao.findBook(request.getParameter("sid"));
		
		if(l!=null)
		{
			out.println("Library Id:"+l.getLibraryId());out.print("<br>");
			out.println("Library Name:"+l.getLibraryName());
			
		}

		Book b = dao.findBookID(request.getParameter("sbid"));
		
		  out.print("<br>");
		  if(b!=null) { out.println("Book Id : "+b.getBookId());out.print("<br>");
		  out.println("Book Name : "+b.getBookName());out.print("<br>");
		  out.println("Author of Book : "+b.getAuthor());out.print("<br>");
		  out.println("Publisher of Book : "+b.getPublisher()); }else {
		  out.println("Enter the correct BookId"); }

	}
	
	
	@RequestMapping("/updateBook")
	public void updateBook(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		
		String nbId = request.getParameter("buid");
		String nBName = request.getParameter("buname");
		String nBauthr = request.getParameter("uauthor");
		String nBpubshr = request.getParameter("upub");
		
		Book book = dao.findBookID(nbId);

		Book upbook = dao.updateBookDetails(nbId,nBName,nBauthr,nBpubshr);
		 	
	  	out.println("After Updating");out.print("<br>");
		out.println("Book Name : " +upbook.getBookName());out.print("<br>");
		out.println("Book Author : "+upbook.getAuthor());out.print("<br>");
		out.println("Book Publisher Name : "+upbook.getPublisher());out.print("<br>");

	}


}
