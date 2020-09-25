package be.dog.d.steven.loosecoupling;

import be.dog.d.steven.loosecoupling.model.Book;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class RemoveEmptyIdAlgorithm implements FixEmptyId{
    public List<Book> removeEmptyId(List<Book> books){

        Collections.sort(books);

        for (int i = 0; i < books.size(); i++) {
            books.get(i).setId(i);
        }
        
        return books;
    }
}