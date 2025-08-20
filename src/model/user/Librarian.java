package model.user;

import java.util.UUID;

public class Librarian extends User {
    final private String ID;
    private int i = 0;

    Librarian(String firstName, String lastName) {
        super(firstName, lastName);
        this.ID = "LIB" + i++;
    }

    public String getId() {
        return ID;
    }

    @Override
    public String toString(){
        return super.toString() + " - ID: " + getId();
    }

}
