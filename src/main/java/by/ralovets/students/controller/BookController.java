package by.ralovets.students.controller;

import by.ralovets.students.entity.User;
import by.ralovets.students.service.BookService;
import by.ralovets.students.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final Set<String> books = ConcurrentHashMap.newKeySet();

    private final UserService userService;
    private final BookService bookService;

    {
        books.add("Пушкин");
        books.add("Плюшкин");
        books.add("Есенин");
    }

    @GetMapping
    public List<String> findAll() {
        final User user = userService.getCurrentUser();

        return bookService.findBooksByUser(user);
    }

    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable String name) {
        books.remove(name);
    }
}