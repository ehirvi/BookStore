package hh.sof03.bookstore.webcontrol;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@CrossOrigin
@Controller
public class BookRestController {
    
    @Autowired
    private BookRepository bookRepo;

    @GetMapping(value="/books")
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) bookRepo.findAll();
    }


    @GetMapping(value="/books/{id}")
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
        return bookRepo.findById(bookId);
    } 
    


}
