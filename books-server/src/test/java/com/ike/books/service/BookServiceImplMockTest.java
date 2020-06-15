package com.ike.books.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

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

@RunWith(SpringRunner.class)
public class BookServiceImplMockTest {

	private BookServiceImpl bookService;

	@Mock
	private BookRepository bookRespository;

	@Mock
	private Book book;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		bookService = new BookServiceImpl();
		bookService.setBookRepository(bookRespository);
	}

	@Test
	public void testReturnBookWhenfindByIdIsCalled() throws Exception {
		when(bookRespository.findOne(4)).thenReturn(book);
		Book foundBook = bookService.findById(4);
		assertThat(foundBook, is(equalTo(book)));
	}

	@Test
	public void testDelete() throws Exception {
		doNothing().when(bookRespository).delete(book);
		
		Book book = createBook();
    	Publisher publisher = createPublisher();
    	Author author = createAuthor(); 
    	book.setPublishers(publisher);
    	book.setAuthors(author);
    	
    	bookRespository.delete(book);
		verify(bookRespository, times(1)).delete(book);
	}

	@Test
	public void testReturnListWhenFindAllIsCalled() throws Exception {
		List<Book> books = Arrays.asList(createBook());
		when(bookRespository.findAll()).thenReturn(books);
		List<Book> lstBooks = bookService.findAll();
		assertThat(lstBooks, is(equalTo(books)));
	}

	@Test
	public void testReturnBookWhenCreateIsCalled() throws Exception {
		when(bookRespository.save(book)).thenReturn(book);
    	Publisher publisher = createPublisher();
    	Author author = createAuthor(); 

    	book.setPublishers(publisher);
    	book.setAuthors(author);		
		Book savedBook = bookService.create(book);
		
		assertThat(savedBook, is(equalTo(book)));
	}
	
	@Test
	public void testWhenUpdateIsCalled() throws Exception {
		when(bookRespository.save(book)).thenReturn(book);

		Publisher publisher = createPublisher();
    	Author author = createAuthor(); 
    	book.setPublishers(publisher);
    	book.setAuthors(author);	
    	
		Book updatedBook = bookService.update(book);
		
		assertThat(updatedBook, is(equalTo(book)));
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
