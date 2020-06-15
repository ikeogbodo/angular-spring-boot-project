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
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import com.ike.books.entity.Author;
import com.ike.books.repository.AuthorRepository;

@RunWith(SpringRunner.class)
public class AuthorServiceImplMockTest {

	private AuthorServiceImpl authorService;

	@Mock
	private AuthorRepository authorRespository;

	@Mock
	private Author author;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		authorService = new AuthorServiceImpl();
		authorService.setAuthorRepository(authorRespository);
	}

	@Test
	public void testReturnBookWhenfindByIdIsCalled() throws Exception {
		when(authorRespository.findOne(3)).thenReturn(author);
		Author foundAuthor = authorService.findAuthorById(3);
		assertThat(foundAuthor, is(equalTo(author)));
	}

	@Test
	public void testDelete() throws Exception {
		doNothing().when(authorRespository).delete(author);
    	authorRespository.delete(author);
		verify(authorRespository, times(1)).delete(author);
	}

	@Test
	public void testReturnListWhenFindAllIsCalled() throws Exception {
		List<Author> authors = Arrays.asList(createAuthor());
		when(authorRespository.findAll()).thenReturn(authors);
		List<Author> lstAuthors = authorService.findAllAuthors();
		assertThat(lstAuthors, is(equalTo(authors)));
	}

	@Test
	public void testReturnBookWhenCreateIsCalled() throws Exception {
		when(authorRespository.save(author)).thenReturn(author);
		Author savedAuthor = authorService.createAuthor(author);
		
		assertThat(savedAuthor, is(equalTo(author)));
	}
	
	@Test
	public void testWhenUpdateIsCalled() throws Exception {
		when(authorRespository.save(author)).thenReturn(author);
    	Author updatedAuthor = authorService.updateAuthor(author);
		
		assertThat(updatedAuthor, is(equalTo(author)));
	}

	private Author createAuthor () {
		return new Author(3,"AuthoreName");
	}
}
