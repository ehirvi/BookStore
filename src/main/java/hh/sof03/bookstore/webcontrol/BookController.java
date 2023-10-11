package hh.sof03.bookstore.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.CategoryRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRep;
    @Autowired
    private CategoryRepository categoryRep;

    @GetMapping("/index")
    public String frontPage() {
        return "frontpage";
    }

    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", bookRep.findAll());
        return "booklist";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRep.findAll());
        return "addbook";
    }

    @PostMapping("/save")
    public String saveBook(Book book) {
        bookRep.save(book);
        return "redirect:/booklist";
    }


    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        bookRep.deleteById(bookId);
        return "redirect:../booklist";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", bookRep.findById(bookId));
        model.addAttribute("categories", categoryRep.findAll());
        return "editbook";
    }

}
