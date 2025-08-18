package model;

import java.util.UUID;

public class Librarian {
    private String firstName;
    private String lastName;
    final private String ID;

    Librarian(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = UUID.randomUUID().toString();
    }
    public String getFirstName() {
        return firstName;

    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return ID;
    }

}
