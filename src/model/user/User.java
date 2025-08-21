package model.user;

import static utils.UserInput.capitalize;

public class User {
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        firstName = firstName.trim();
        if (firstName == null || firstName.equals("")) {
            throw  new IllegalArgumentException("Le prenom ne doit pas etre vide");
        }
        if(!firstName.matches("^[A-Za-z]{3,20}$")){
            throw new IllegalArgumentException("Le prenom doit faire entre 3 et 20 caracteres et ne contenir que des caracteres alphabetiques");
        }
        this.firstName = capitalize(firstName);
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        lastName = lastName.trim();
        if (lastName == null || lastName.equals("")) {
            throw  new IllegalArgumentException("Le nom ne doit pas etre vide");
        }
        if(!lastName.matches("^[A-Za-z]{3,20}$")){
            throw new IllegalArgumentException("Le nom doit faire entre 3 et 20 caracteres et ne contenir que des caracteres alphabetiques");
        }

        this.lastName = capitalize(lastName);
    }

    @Override
    public String toString(){
       return getFirstName() + " " + getLastName();
    }


}
