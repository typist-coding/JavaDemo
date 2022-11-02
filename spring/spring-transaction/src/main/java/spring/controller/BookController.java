package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.service.BookService;
import spring.service.CheckoutService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CheckoutService checkoutService;

    public void buyBook(Integer userId,Integer bookId){
        bookService.buyBook(userId, bookId);
    }

    public void Checkout(Integer userId,Integer[] bookIds){
        checkoutService.checkout(userId,bookIds);
    }
}
