package be.dog.d.steven.loosecoupling;

import be.dog.d.steven.loosecoupling.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookSearchImpl {

    @Autowired
    private FixEmptyId fixEmptyId;

    public BookSearchImpl(FixEmptyId fixEmptyId) {
        this.fixEmptyId = fixEmptyId;
    }


    public Book getLastId(List<Book> books){

        int i = books.size()-1;

        return books.get(i);
    }

    public Book findBookById(List<Book> books, int id){

        for(Book book : books){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }
    public Book getLastIdWithoutEmpties(List<Book> books){

        books = fixEmptyId.removeEmptyId(books);

        int i = books.size()-1;

        return books.get(i);
    }

    public Book findBookByIdWithoutEmpties(List<Book> books, int id){

        books = fixEmptyId.removeEmptyId(books);

        for(Book book : books){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }

}
