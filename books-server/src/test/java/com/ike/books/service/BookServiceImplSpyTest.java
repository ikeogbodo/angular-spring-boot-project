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
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.springframework.beans.factory.annotation.Autowired;

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
		bookServiceSpy = new BookServiceImpl();
		bookServiceSpy.setBookRepository(bookRespository);
	}
	

	@Test
	public void testVeryWhenfindByIdIsCalled() throws Exception {
		Mockito.doReturn(book).when(bookRespository).findOne(4);
		Book foundBook = bookServiceSpy.findById(4);
		Mockito.verify(foundBook);
	}

	@Test
	public void testVerifyWhenCreateIsCalled() throws Exception {
		when(bookRespository.save(book)).thenReturn(book);
    	Publisher publisher = createPublisher();
    	Author author = createAuthor(); 

    	book.setPublishers(publisher);
    	book.setAuthors(author);		
		Book savedBook = bookServiceSpy.create(book);
		
		assertThat(savedBook, is(equalTo(book)));
	}
	
	private Author createAuthor () {
		return new Author(2,"AuthoreName");
	}
	
	private Publisher createPublisher() {
		return new Publisher(3,"PublisherName");
	}
}
