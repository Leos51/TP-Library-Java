package model.user;

import java.util.UUID;

public class Librarian extends User {
    final private String ID;

    public Librarian(String firstName, String lastName) {
        super(firstName, lastName);
        this.ID = UUID.randomUUID().toString();
    }

    public String getId() {
        return ID;
    }

    @Override
    public String toString(){
        return super.toString() + " - ID: " + getId();
    }

}
