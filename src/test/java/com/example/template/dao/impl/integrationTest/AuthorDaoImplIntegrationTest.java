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
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) // to clean populated data after each method
public class AuthorDaoImplIntegrationTest {

    private AuthorDaoImpl underTest;

    @Autowired
    public AuthorDaoImplIntegrationTest(AuthorDaoImpl underTest) {
        this.underTest = underTest;
    }


    // Test the create and find one
    @Test
    public void TestThatAuthorCanBeCratedAndRecalled() {
        Author authorA = TestDataUtility.createTestAuthorA();
        underTest.create(authorA);
        Optional<Author> results = underTest.findOne(authorA.getId());
        assertThat(results).isPresent();
        assertThat(results.get()).isEqualTo(authorA);
    }


    // To test find many
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


    // to test full update
    @Test
    public void testThatAuthorCanBeUpdated() {
        Author authorA = TestDataUtility.createTestAuthorA();
        underTest.create(authorA);

        authorA.setName("UPDATED");
        underTest.fullUpdate(authorA.getId(), authorA);

        Optional<Author> result = underTest.findOne(authorA.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorA);

    }

    // to test delete
    @Test
    public void testThatAuthorCanBeDeleted() {
        Author authorA = TestDataUtility.createTestAuthorA();
        underTest.create(authorA);
        underTest.delete(authorA.getId());
        underTest.findOne(authorA.getId());

        Optional<Author> result = underTest.findOne(authorA.getId());
        assertThat(result).isEmpty();
    }
}
