package com.ike.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ike.books.entity.Author;
import com.ike.books.entity.Publisher;
import com.ike.books.repository.AuthorRepository;
import com.ike.books.repository.PublisherRepository;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    
    @Autowired
    public void setAuthorRepository(AuthorRepository author_Repository) {
    	authorRepository = author_Repository;
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
