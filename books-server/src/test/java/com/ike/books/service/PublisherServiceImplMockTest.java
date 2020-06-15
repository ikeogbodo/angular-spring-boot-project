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

import com.ike.books.entity.Publisher;
import com.ike.books.repository.PublisherRepository;

@RunWith(SpringRunner.class)
public class PublisherServiceImplMockTest {

	private PublisherServiceImpl publisherService;

	@Mock
	private PublisherRepository publisherRespository;

	@Mock
	private Publisher publisher;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		publisherService = new PublisherServiceImpl();
		publisherService.setPublisherRepository(publisherRespository);
	}

	@Test
	public void testReturnBookWhenfindByIdIsCalled() throws Exception {
		when(publisherRespository.findOne(3)).thenReturn(publisher);
		Publisher foundPublisher = publisherService.findPublisherById(3);
		assertThat(foundPublisher, is(equalTo(publisher)));
	}

	@Test
	public void testDelete() throws Exception {
		doNothing().when(publisherRespository).delete(publisher);
		publisherRespository.delete(publisher);
		verify(publisherRespository, times(1)).delete(publisher);
	}

	@Test
	public void testReturnListWhenFindAllIsCalled() throws Exception {
		List<Publisher> publishers = Arrays.asList(createPublisher());
		when(publisherRespository.findAll()).thenReturn(publishers);
		List<Publisher> lstPublishers = publisherService.findAllPublishers();
		assertThat(lstPublishers, is(equalTo(publishers)));
	}

	@Test
	public void testReturnBookWhenCreateIsCalled() throws Exception {
		when(publisherRespository.save(publisher)).thenReturn(publisher);
		Publisher createdPublisher = publisherService.createPublisher(publisher);
		
		assertThat(createdPublisher, is(equalTo(publisher)));
	}
	
	@Test
	public void testWhenUpdateIsCalled() throws Exception {
		when(publisherRespository.save(publisher)).thenReturn(publisher);
		Publisher updatedPublisher = publisherService.createPublisher(publisher);
		
		assertThat(updatedPublisher, is(equalTo(publisher)));
	}

	private Publisher createPublisher() {
		return new Publisher(5,"PublisherName");
	}
}
