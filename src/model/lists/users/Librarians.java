package model.lists.users;

import model.user.Librarian;

import java.util.ArrayList;
import java.util.List;

public class Librarians {
    List<Librarian> librarians = new ArrayList<>();

    public List<Librarian> getLibrarians(){
        return librarians;
    }
    public void setLibrarians(List<Librarian> librarians){
        this.librarians = librarians;
    }
    public void addLibrarian(Librarian librarian){
        this.librarians.add(librarian);
    }
    public void removeLibrarian(Librarian librarian){
        this.librarians.remove(librarian);
    }
}
