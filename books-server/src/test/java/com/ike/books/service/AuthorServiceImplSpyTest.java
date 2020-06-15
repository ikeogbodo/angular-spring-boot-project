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
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import com.ike.books.entity.Author;
import com.ike.books.repository.AuthorRepository;

public class AuthorServiceImplSpyTest {
	
	@Spy
	private AuthorServiceImpl authorServiceSpy;
	
	@Mock
	private AuthorRepository authorRespository;
	
	@Mock 
	private Author author;
	
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		authorServiceSpy.setAuthorRepository(authorRespository);
	}
	
	@Test
	public void testVeryWhenfindByIdIsCalled() throws Exception {
		Mockito.doReturn(author).when(authorServiceSpy).findAuthorById(4);
		Author foundAuthor = authorServiceSpy.findAuthorById(4);
		Mockito.verify(foundAuthor);
	}

	@Test
	public void testVerifyWhenCreateIsCalled() throws Exception {
		when(authorServiceSpy.createAuthor(author)).thenReturn(author);
		Author savedAuthor = authorServiceSpy.createAuthor(author);
		
		assertThat(savedAuthor, is(equalTo(author)));
	}

	@Test
	public void testWhenFindAllIsCalled() throws Exception {
		List<Author> authors = Arrays.asList(createAuthor());
		when(authorServiceSpy.findAllAuthors()).thenReturn(authors);
		List<Author> lstAuthors = authorServiceSpy.findAllAuthors();
		assertThat(lstAuthors, is(equalTo(authors)));
	}
	
	@Test
	public void testWhenUpdateIsCalled() throws Exception {
		when(authorServiceSpy.updateAuthor(author)).thenReturn(author);
		Author updatedAuthor = authorServiceSpy.updateAuthor(author);
		
		assertThat(updatedAuthor, is(equalTo(author)));
	}
	
	@Test
	public void testDelete() throws Exception {
		when(authorServiceSpy.deleteAuthor(author.getAuthorid())).thenReturn(author);
		Author author = createAuthor();

    	authorServiceSpy.deleteAuthor(author.getAuthorid());
		verify(authorServiceSpy, times(1)).deleteAuthor(author.getAuthorid());
	}
	

	private Author createAuthor () {
		return new Author(2,"AuthoreName");
	}

}
