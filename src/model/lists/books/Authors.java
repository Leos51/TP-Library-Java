package model.lists.books;

import model.book.Author;

import java.util.ArrayList;
import java.util.List;

public class Authors {
    List<Author> authors =  new ArrayList<>();

    public List<Author> getAuthors(){
        return authors;
    }
    public void setAuthors(List<Author> authors){
        this.authors = authors;
    }
    public void addAuthor(Author author){
        authors.add(author);
    }
    public void removeAuthor(Author author){
        authors.remove(author);
    }

}
