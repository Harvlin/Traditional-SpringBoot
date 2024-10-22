package com.example.template.dao.impl.integrationTest;

import com.example.template.TestDataUtility;
import com.example.template.dao.impl.AuthorDaoImpl;
import com.example.template.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorDaoImplIntegrationTest {

    private AuthorDaoImpl underTest;

    @Autowired
    public AuthorDaoImplIntegrationTest(AuthorDaoImpl underTest) {
        this.underTest = underTest;
    }

    @Test
    public void TestThatAuthorCanBeCratedAndRecalled() {
        Author author = TestDataUtility.createTestAuthorA();
        underTest.create(author);
        Optional<Author> results = underTest.findOne(author.getId());
        assertThat(results).isPresent();
        assertThat(results.get()).isEqualTo(author);
    }

    @Test
    public void testThatMultipleAuthorCanBeCreatedAndRecalled() {
        Author authorA = TestDataUtility.createTestAuthorA();
        underTest.create(authorA);
        Author authorB = TestDataUtility.createTestAuthorB();
        underTest.create(authorB);
        Author authorC = TestDataUtility.createTestAuthorC();
        underTest.create(authorC);

        List<Author> result = underTest.findMany();
        assertThat(result).hasSize(3).containsExactly(authorA, authorB, authorC);
    }
}
