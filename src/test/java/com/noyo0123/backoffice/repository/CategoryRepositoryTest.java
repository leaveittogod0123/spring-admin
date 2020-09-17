package com.noyo0123.backoffice.repository;

import com.noyo0123.backoffice.BackofficeApplicationTests;
import com.noyo0123.backoffice.model.entity.Category;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends BackofficeApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test // junit!
    public void create() {
        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createAt = LocalDateTime.now();
        String createBy = "AdminServer";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createAt);
        category.setCreatedBy(createBy);

        Category newCategory = categoryRepository.save(category);

        Assert.assertNotNull(newCategory);
        Assert.assertEquals(newCategory.getType(), type);
        Assert.assertEquals(newCategory.getTitle(), title);
    }

    @Test
    public void read() {

        String type = "COMPUTER";

        Optional<Category> category = categoryRepository.findByType(type);

        category.ifPresent(c -> {
            Assert.assertEquals(c.getType(), type);
        });
    }
}
