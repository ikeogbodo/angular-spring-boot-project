package com.ike.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ike.books.entity.Author;
import com.ike.books.entity.Book;
import com.ike.books.entity.Publisher;
import com.ike.books.repository.AuthorRepository;
import com.ike.books.repository.BookRepository;
import com.ike.books.repository.PublisherRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;
    
    @Autowired
    private PublisherRepository publisherRepository;
    
    public Book create(Book book) {
    	Publisher publisher = this.findPublisherById(book.getPublisher());
    	Author author = this.findAuthorById(book.getAuthor());
    	book.setPublishers(publisher);
    	book.setAuthors(author);
   	 	return bookRepository.save(book);
    }

    public Book delete(int id) {
    	System.out.println("In Delete Service");
        Book book = findById(id);
        if(book != null){
        	bookRepository.delete(book);
        }
        return book;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(int id) {
    	return bookRepository.findOne(id);

    }

    public Book update(Book book) {
    	Publisher publisher = this.findPublisherById(book.getPublisher());
    	Author author = this.findAuthorById(book.getAuthor());
    	book.setPublishers(publisher);
    	book.setAuthors(author);    	
        return bookRepository.save(book);
    }
    
    public Publisher createPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public Publisher deletePublisher(int id) {
    	Publisher publisher = findPublisherById(id);
        if(publisher != null){
        	publisherRepository.delete(publisher);
        }
        return publisher;
    }

    public List<Publisher> findAllPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher findPublisherById(int id) {
        return publisherRepository.findOne(id);
    }

    public Publisher updatePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

	public Author createAuthor(Author author) {
		return authorRepository.save(author); 
	}

	public Author deleteAuthor(int id) {
		Author author = findAuthorById(id);
		if (author != null) {
			authorRepository.delete(author);
		}
		return author;
	}

	public List<Author> findAllAuthors() {
		return authorRepository.findAll();
	}

	public Author findAuthorById(int id) {
		return authorRepository.findOne(id);
	}
	
	public Author updateAuthor(Author author) {
		return authorRepository.save(author);
	}

}
