package model.person;

import java.util.UUID;

public class Librarian extends Person {
    final private String ID;

    Librarian(String firstName, String lastName) {
        super(firstName, lastName);
        this.ID = UUID.randomUUID().toString();
    }

    public String getId() {
        return ID;
    }

}
