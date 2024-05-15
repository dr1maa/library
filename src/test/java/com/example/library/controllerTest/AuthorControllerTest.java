package com.example.library.controllerTest;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthorControllerTest {
    @Mock
    private AuthorService authorService;
    @InjectMocks
    private AuthorController authorController;

    @Test
    void testCreateAuthor() {
        Author authorToCreate = new Author();
        authorToCreate.setName("Author1_Test");
        authorToCreate.setNationality("Nationality_Test");


        List<Book> books = new ArrayList<>();

        Book book1 = new Book();
        book1.setTitle("Book 1");
        book1.setPublicationYear(2000);
        books.add(book1);
        authorToCreate.setBooks(books);


        Author createdAuthor = new Author();
        createdAuthor.setAuthorId(1);
        createdAuthor.setNationality("Nationality_Test");
        createdAuthor.setName("Author1_Test");

        when(authorService.createAuthor(any(Author.class))).thenReturn(createdAuthor);

        ResponseEntity<Author> response = authorController.createAuthor(authorToCreate);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdAuthor, response.getBody());
        verify(authorService, times(1)).createAuthor(any(Author.class));
    }
}