package com.example.bookfarm.Book;

import com.example.bookfarm.Author.Author;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    private final BookRepository bookRepository;
    private final BookServiceImpl bookService;


    public BookController(BookRepository bookRepository, BookServiceImpl bookService) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }



    @GetMapping("/books")
    Iterable<Book> allBooks(){
        return bookService.getBook();
    }


    @GetMapping("/books/{id}")
    Book  oneBook(@PathVariable Long id){
        return bookRepository.findById(id).orElseThrow(()->new BookNotFoundException(id));
    }

    @PostMapping("/books")

    @DeleteMapping("/books/{id}")
    void deleteAuthor(@PathVariable Long id){
        bookRepository.deleteById(id);
    }
    @PutMapping("books/{id}")
    Book replaceAuthor(@RequestBody Book newBook, @PathVariable Long id){
        return bookRepository.findById(id).map(book ->{
            book.setTitle(newBook.getTitle());
            book.setAuthor(newBook.getAuthor());
            book.setIsbn(newBook.getIsbn());
            book.setLength(newBook.getLength());
            book.setSubjects(newBook.getSubjects());
            return bookRepository.save(newBook);
        }).orElseGet(()->{newBook.setBookId(id);
            return bookRepository.save(newBook);
        });

    }
}
