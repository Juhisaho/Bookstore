package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;




@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);		
	}
	@Bean
	public CommandLineRunner bookDemo(CategoryRepository kategoria, BookRepository kirja) {
		return (args) -> {
			
			kategoria.save(new Category("Kauhu"));
			kategoria.save(new Category("Romaani"));
			kategoria.save(new Category("Scifi"));
			
			kirja.save(new Book("Mika", "Waltari", "Sinuhe egyptiläinen", "1-55652-441-2", "1945", kategoria.findByName("Romaani").get(0)));
			kirja.save(new Book("Douglas", "Adams", "Linnunradan käsikirja liftareille", "9789510218440", "1979", kategoria.findByName("Scifi").get(0)));
			kirja.save(new Book("Juha-Matti", "Aho", "Javascript-syventävä", "666-666", "2021", kategoria.findByName("Kauhu").get(0)));
			
			
			
		};
	}

}
