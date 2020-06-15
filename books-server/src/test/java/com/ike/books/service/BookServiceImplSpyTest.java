package com.ike.books.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import com.ike.books.entity.Author;
import com.ike.books.entity.Book;
import com.ike.books.entity.Publisher;
import com.ike.books.repository.BookRepository;

public class BookServiceImplSpyTest {
	
	@Spy
	private BookServiceImpl bookServiceSpy;
	
	@Mock
	private BookRepository bookRespository;
	
	@Mock 
	private Book book;
	
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		bookServiceSpy.setBookRepository(bookRespository);
	}
	

	@Test
	public void testVeryWhenfindByIdIsCalled() throws Exception {
		Mockito.doReturn(book).when(bookServiceSpy).findById(4);
		Book foundBook = bookServiceSpy.findById(4);
		Mockito.verify(foundBook);
	}

	@Test
	public void testVerifyWhenCreateIsCalled() throws Exception {
		when(bookServiceSpy.create(book)).thenReturn(book);
    	Publisher publisher = createPublisher();
    	Author author = createAuthor(); 

    	book.setPublishers(publisher);
    	book.setAuthors(author);		
		Book savedBook = bookServiceSpy.create(book);
		
		assertThat(savedBook, is(equalTo(book)));
	}


	@Test
	public void testWhenFindAllIsCalled() throws Exception {
		List<Book> books = Arrays.asList(createBook());
		when(bookServiceSpy.findAll()).thenReturn(books);
		List<Book> lstBooks = bookServiceSpy.findAll();
		assertThat(lstBooks, is(equalTo(books)));
	}

	
	@Test
	public void testWhenUpdateIsCalled() throws Exception {
		when(bookServiceSpy.update(book)).thenReturn(book);

		Publisher publisher = createPublisher();
    	Author author = createAuthor(); 
    	book.setPublishers(publisher);
    	book.setAuthors(author);	
    	
		Book updatedBook = bookServiceSpy.update(book);
		
		assertThat(updatedBook, is(equalTo(book)));
	}

	
	@Test
	public void testDelete() throws Exception {
		when(bookServiceSpy.delete(book.getBookid())).thenReturn(book);
		Book book = createBook();
    	Publisher publisher = createPublisher();
    	Author author = createAuthor(); 
    	book.setPublishers(publisher);
    	book.setAuthors(author);

    	bookServiceSpy.delete(book.getBookid());
		verify(bookServiceSpy, times(1)).delete(book.getBookid());
	}
	
	
	private Book createBook () {
		return new Book(4,"TitleName", new Author(), new Publisher(), new Date(), 150);
	}
	
	private Author createAuthor () {
		return new Author(2,"AuthoreName");
	}
	
	private Publisher createPublisher() {
		return new Publisher(3,"PublisherName");
	}
}
