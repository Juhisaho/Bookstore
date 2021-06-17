package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest

class UserRepositoryTests {
	
    @Autowired
    private UserRepository repository;
    
    @Test
    public void createNewUser( ) {
    	User user = new User("Juhis", "$2y$12$kPL.4u7OrSd9IF5EssLDYO1giqlpsKaWWXTcCwRmiRpxDxTRdd.Vy", "ADMIN");
		repository.save(user);
		assertThat(user.getRole()).isNotNull();
    }
    
    @Test
    public  void findUser() {
    	User user = new User("Juhis", "$2y$12$kPL.4u7OrSd9IF5EssLDYO1giqlpsKaWWXTcCwRmiRpxDxTRdd.Vy", "ADMIN");
		repository.save(user);
    	User user1 = repository.findByUsername("Juhis");
    	
    	assertThat(user1.getRole()).isEqualTo("ADMIN");
    	//assertThat(user1.getRole()).isNotNull();
		// TODO Auto-generated method stub
	}
    
    @Test
    public void deleteUser() {
    	User user = new User("Juhis", "$2y$12$kPL.4u7OrSd9IF5EssLDYO1giqlpsKaWWXTcCwRmiRpxDxTRdd.Vy", "ADMIN");
		repository.save(user);
		User user1 = repository.findByUsername("Juhis");
		Long id = user1.getId();
		repository.deleteById(id);
		User user2 = repository.findByUsername("Juhis");
		assertThat(user2).isNull();
    }
    
    
}