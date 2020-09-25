package be.dog.d.steven.loosecoupling;

import be.dog.d.steven.loosecoupling.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LooseCouplingApplication {

    static Book book1 = new Book(1,"Animal Farm");
    static Book book2 = new Book(3, "Shades of gay");
    static Book book3 = new Book(5, "Bible");

    public static void main(String[] args) {

        List<Book> books= new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        // Without SPRING
//        BookSearchImpl oldIdSearch = new BookSearchImpl(new RemoveEmptyIdAlgorithm());
//        BookSearchImpl latestIdSearch = new BookSearchImpl(new BetterWayToRemoveEmptyId());

        ConfigurableApplicationContext applicationContext = SpringApplication.run(LooseCouplingApplication.class, args);
        BookSearchImpl bookSearch = applicationContext.getBean(BookSearchImpl.class);


        /**
         * Including Empty Id
         */
        // Without SPRING
//        Book oldLast = oldIdSearch.getLastId(books);
//        Book oldResult = oldIdSearch.findBookById(books, 3);
//
//        Book last = latestIdSearch.getLastId(books);
//        Book result = latestIdSearch.findBookById(books, 3);

        // With SPRING beans
        Book oldLast = bookSearch.getLastId(books);
        Book oldResult = bookSearch.findBookById(books, 3);

        Book last = bookSearch.getLastId(books);
        Book result = bookSearch.findBookById(books, 3);

        System.out.println(oldLast);
        System.out.println(oldResult);

        System.out.println(last);
        System.out.println(result);

        /**
         * Without Empty Id
         */
        // Without SPRING
//        oldLast = oldIdSearch.getLastIdWithoutEmpties(books);
//        oldResult = oldIdSearch.findBookByIdWithoutEmpties(books, 3);
//
//        last = latestIdSearch.getLastIdWithoutEmpties(books);
//        result = latestIdSearch.findBookByIdWithoutEmpties(books, 3);

        // With SPRING beans
        oldLast = bookSearch.getLastIdWithoutEmpties(books);
        oldResult = bookSearch.findBookByIdWithoutEmpties(books, 3);

        last = bookSearch.getLastIdWithoutEmpties(books);
        result = bookSearch.findBookByIdWithoutEmpties(books, 3);

        System.out.println(oldLast);
        System.out.println(oldResult);

        System.out.println(last);
        System.out.println(result);
    }

}
