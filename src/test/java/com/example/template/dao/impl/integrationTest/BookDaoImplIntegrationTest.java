package com.example.template.dao.impl.integrationTest;

import com.example.template.TestDataUtility;
import com.example.template.dao.AuthorDao;
import com.example.template.dao.impl.BookDaoImpl;
import com.example.template.domain.Author;
import com.example.template.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookDaoImplIntegrationTest {

    private AuthorDao authorDao;
    private BookDaoImpl underTest;

    @Autowired
    public BookDaoImplIntegrationTest(BookDaoImpl underTest, AuthorDao authorDao) {
        this.underTest = underTest;
        this.authorDao = authorDao;
    }

    @Test
    public void TestThatBookCanBeCreatedAndRecalled() {
        Author author = TestDataUtility.createTestAuthorA();
        authorDao.create(author);

        Book book = TestDataUtility.createTestBook();
        book.setAuthorId(author.getId());
        underTest.create(book);
        Optional<Book> results = underTest.findOne(book.getIsbn());

        assertThat(results).isPresent();
        assertThat(results.get()).isEqualTo(book);
    }
}
