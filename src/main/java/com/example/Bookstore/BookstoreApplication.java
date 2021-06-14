package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;




@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);		
	}
	@Bean
	public CommandLineRunner bookDemo(CategoryRepository kategoria, BookRepository kirja, UserRepository kayttaja) {
		return (args) -> {
			
			kategoria.save(new Category("Kauhu"));
			kategoria.save(new Category("Romaani"));
			kategoria.save(new Category("Scifi"));
			
			kirja.save(new Book("Mika", "Waltari", "Sinuhe egyptiläinen", "1-55652-441-2", "1945", kategoria.findByName("Romaani").get(0)));
			kirja.save(new Book("Douglas", "Adams", "Linnunradan käsikirja liftareille", "9789510218440", "1979", kategoria.findByName("Scifi").get(0)));
			kirja.save(new Book("Juha-Matti", "Aho", "Javascript-syventävä", "666-666", "2021", kategoria.findByName("Kauhu").get(0)));
			
			User user1 = new User("user", "$2y$12$TRVZcVf2NmrTIguZcxZrh.rg6nlgQxGwdPo7jXipUSXQUgfJHISjC", "USER");
			User user2 = new User("admin", "$2y$12$JYjBM5joxtP/MGdTqmUSauFlC12DgHCWWGZ65kHYMuahIx7oUKWCu", "ADMIN");
			kayttaja.save(user1);
			kayttaja.save(user2);
			
		};
	}

}
