package hh.sof03.bookstore;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof03.bookstore.domain.User;
import hh.sof03.bookstore.domain.UserRepository;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void createUser() {
        User user = new User("testUser", "$2a$10$.cdYRVfrZhBbmwlN5qsWQ.6WXxGH53TT4lZ4hcCrTzBtpRWRnBDEG", "test@test.com", "USER");
        userRepository.save(user);
        Assertions.assertThat(user.getId()).isNotNull();
    }

    @Test
    public void deleteUser() {
        User user = new User("testUser", "$2a$10$.cdYRVfrZhBbmwlN5qsWQ.6WXxGH53TT4lZ4hcCrTzBtpRWRnBDEG", "test@test.com", "USER");
        userRepository.save(user);
        long id = user.getId();
        userRepository.delete(user);
        Assertions.assertThat(userRepository.existsById(id)).isFalse();
        
    }

    @Test
    public void searchForUser() {
        User user = userRepository.findByUsername("user");
        Assertions.assertThat(user.getEmail()).isEqualTo("pekka@outlook.com");
    }

}
