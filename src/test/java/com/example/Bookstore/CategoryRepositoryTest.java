package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest

class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;
    
    @Test
    public  void findCategory() {
    	Category category = new Category("Huumori");	    	
    	repository.save(category);
    	
    	List<Category> categories = repository.findByName("Huumori");
    	
    	assertThat(categories).hasSize(1);
    	assertThat(categories.get(0).getCategoryid()).isNotNull();
		// TODO Auto-generated method stub

	}
    
    @Test
    public void createNewCategory() {
    	Category category = new Category("Huumori");	    	
    	repository.save(category);
    	assertThat(category.getCategoryid()).isNotNull();
    }
    
    public void deleteCategory() {
    	Category category1 = new Category("Huumori");	    	
    	repository.save(category1);
    	
    	
    	List<Category> categories = repository.findByName("Huumori");
    	assertThat(categories).hasSize(1);
    	Long id = categories.get(0).getCategoryid();
    	repository.deleteById(id);
    	List<Category> newList = repository.findByName("Huumori");
    	assertThat(newList).hasSize(0);
		
	}

}
