package spring.service.impl;

import com.mysql.cj.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.BookDao;
import spring.service.BookService;

import java.util.concurrent.TimeUnit;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
//    @Transactional(
////            readOnly = true//只读
////            timeout = 3//超时
////            noRollbackFor = ArithmeticException.class//回滚
////            noRollbackForClassName = "java.lang.ArithmeticException"//回滚之全类名
////            isolation = Isolation.DEFAULT//事务隔离级别
//            propagation = Propagation.REQUIRES_NEW//事务传播行为
//    )
    public void buyBook(Integer userId, Integer bookId) {
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        //价格
        Integer price = bookDao.getPriceByBookId(bookId);
        //库存
        bookDao.updateStock(bookId);
        //余额
        bookDao.updateBalance(userId, price);

//        System.out.println(1/0);
    }
}
