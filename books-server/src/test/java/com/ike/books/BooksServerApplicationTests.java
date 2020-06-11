package com.ike.books;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ike.books.entity.Book;
import com.ike.books.repository.BookRepository;
import com.ike.books.service.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BooksServerApplicationTests {

    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;
    
	/*
	 * @Test public void createBookTest(){ Book book = new Book("Cool Book",
	 * "Jessy Brown", "TestPublisher", 400);
	 * when(bookRepository.save(book)).thenReturn(book); assertEquals(book,
	 * bookService.create(book)); }
	 * 
	 * @Test public void findByIdTest() { int id = 2;
	 * when(bookRepository.findOne(id)) //.thenReturn((Book) Stream.of(new
	 * Book("Test", "Testing", "publisher", 200)).collect(Collectors.toList()));
	 * .thenReturn(new Book("Test", "Testing", "publisher", 200));
	 * assertEquals("Test", bookService.findById(id).getTitle()); }
	 * 
	 * @Test public void findAllTest(){
	 * when(bookRepository.findAll()).thenReturn(Stream .of(new Book("Test",
	 * "Testing", "publisher", 200), new Book("Another Test", "John Doe",
	 * "TestPublisher", 100)).collect(Collectors.toList())); assertEquals(2,
	 * bookService.findAll().size());
	 * 
	 * }
	 * 
	 * @Test public void deleteBook() { Book book = new Book("Another Test",
	 * "John Doe", "TestPublisher", 100); bookRepository.delete(book);
	 * verify(bookRepository).delete(book); }
	 */
    
    
}