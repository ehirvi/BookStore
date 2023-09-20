package hh.sof03.bookstore.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.sof03.bookstore.domain.BookRepository;



@Controller
public class BookController {

    @Autowired
    private BookRepository bookRep;

    @GetMapping("/index")
    public String frontPage() {
        return "frontpage";
    }


    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", bookRep.findAll());
        return "booklist";
    }

}
