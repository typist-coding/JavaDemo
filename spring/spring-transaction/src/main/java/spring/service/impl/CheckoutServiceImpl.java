package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.service.BookService;
import spring.service.CheckoutService;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private BookService bookService;

    @Override
//    @Transactional
    public void checkout(Integer userId, Integer[] bookIds) {
        for (Integer bookId:bookIds){
            bookService.buyBook(userId,bookId);
        }
    }
}
