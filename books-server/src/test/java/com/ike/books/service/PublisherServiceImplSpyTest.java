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

import com.ike.books.entity.Publisher;
import com.ike.books.repository.PublisherRepository;

public class PublisherServiceImplSpyTest {
	
	@Spy
	private PublisherServiceImpl publisherServiceSpy;
	
	@Mock
	private PublisherRepository publisherRespository;
	
	@Mock 
	private Publisher publisher;
	
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		publisherServiceSpy.setPublisherRepository(publisherRespository);
	}
	
	@Test
	public void testVeryWhenfindByIdIsCalled() throws Exception {
		Mockito.doReturn(publisher).when(publisherServiceSpy).findPublisherById(4);
		Publisher foundAuthor = publisherServiceSpy.findPublisherById(4);
		Mockito.verify(foundAuthor);
	}

	@Test
	public void testVerifyWhenCreateIsCalled() throws Exception {
		when(publisherServiceSpy.createPublisher(publisher)).thenReturn(publisher);
		Publisher savedPublisher = publisherServiceSpy.createPublisher(publisher);
		
		assertThat(savedPublisher, is(equalTo(publisher)));
	}

	@Test
	public void testWhenFindAllIsCalled() throws Exception {
		List<Publisher> publishers = Arrays.asList(createPublisher());
		when(publisherServiceSpy.findAllPublishers()).thenReturn(publishers);
		List<Publisher> lstPublishers = publisherServiceSpy.findAllPublishers();
		assertThat(lstPublishers, is(equalTo(publishers)));
	}
	
	@Test
	public void testWhenUpdateIsCalled() throws Exception {
		when(publisherServiceSpy.updatePublisher(publisher)).thenReturn(publisher);
		Publisher updatedPublisher = publisherServiceSpy.updatePublisher(publisher);
		
		assertThat(updatedPublisher, is(equalTo(publisher)));
	}
	
	@Test
	public void testDelete() throws Exception {
		when(publisherServiceSpy.deletePublisher(publisher.getPublihserid())).thenReturn(publisher);
    	Publisher publisher = createPublisher();

    	publisherServiceSpy.deletePublisher(publisher.getPublihserid());
		verify(publisherServiceSpy, times(1)).deletePublisher(publisher.getPublihserid());
	}
	

	private Publisher createPublisher() {
		return new Publisher(3,"PublisherName");
	}
}
