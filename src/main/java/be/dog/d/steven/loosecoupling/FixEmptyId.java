package be.dog.d.steven.loosecoupling;

import be.dog.d.steven.loosecoupling.model.Book;

import java.util.List;

public interface FixEmptyId {
    List<Book> removeEmptyId(List<Book> books);
}
