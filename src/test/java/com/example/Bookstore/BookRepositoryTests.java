package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;



@ExtendWith(SpringExtension.class)
@DataJpaTest
class BookRepositoryTests {

	    @Autowired
	    private BookRepository repository;

	    @Test
	    public void findByLastnameShouldReturnBook() {
	        List<Book> books = repository.findByLastName("Waltari");
	        
	        assertThat(books).hasSize(1);
	        assertThat(books.get(0).getFirstName()).isEqualTo("Mika");
	    }
	   
	    @Test
	    public void createNewBook() {
	    	Book book = new Book("Douglas", "Adams", "Linnunradan käsikirja liftareille", "9789510218440", "1979", new Category("Scifi"));
	    	repository.save(book);
	    	assertThat(book.getId()).isNotNull();
	    	assertThat(book.getCategory()).isNotNull();
	    }
	    
	    @Test
	    public void deleteBook() {
	    	List<Book> books = repository.findByYear("1979"); 
	    	Long id = books.get(0).getId();
	    	assertThat(books).hasSize(1);
	    	repository.deleteById(id);
	    	List<Book> newList = repository.findByYear("1979");
	    	assertThat(newList).hasSize(0);
	    }
	    
	    
	}
