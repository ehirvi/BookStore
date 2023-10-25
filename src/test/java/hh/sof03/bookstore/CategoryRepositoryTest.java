package hh.sof03.bookstore;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void createNewCategory() {
        Category category = new Category("Drama");
        categoryRepository.save(category);
        Assertions.assertThat(category.getCategoryid()).isNotNull();
    }

    @Test
    public void deleteCategory() {
        Category category = new Category("Drama");
        categoryRepository.save(category);
        long id = category.getCategoryid();
        categoryRepository.delete(category);
        Assertions.assertThat(categoryRepository.existsById(id)).isFalse();
    }

}
