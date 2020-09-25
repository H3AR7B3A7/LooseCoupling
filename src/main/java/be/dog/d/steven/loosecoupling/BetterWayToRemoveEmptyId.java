package be.dog.d.steven.loosecoupling;

import be.dog.d.steven.loosecoupling.model.Book;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Primary
public class BetterWayToRemoveEmptyId implements FixEmptyId{
    public List<Book> removeEmptyId(List<Book> books){

        Collections.sort(books);

        int i = 0;
        for(Book book : books){
            book.setId(i++);
        }

        return books;
    }
}
