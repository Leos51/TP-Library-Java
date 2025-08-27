package model.user;

import utils.RegexPatterns;
import utils.exception.SaisieException;

import static utils.UserInput.capitalize;

public class User {
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) throws SaisieException {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) throws SaisieException {
        firstName = firstName.trim();
        if (firstName == null || firstName.equals("")) {
            throw  new SaisieException("Le prenom ne doit pas etre vide");
        }
        if(!firstName.matches(RegexPatterns.NAME_REGEX)){
            throw new SaisieException("Le prenom doit faire entre 3 et 20 caracteres et ne contenir que des caracteres alphabetiques");
        }
        this.firstName = capitalize(firstName);
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) throws SaisieException {
        lastName = lastName.trim();
        if (lastName == null || lastName.equals("")) {
            throw  new SaisieException("Le nom ne doit pas etre vide");
        }
        if(!lastName.matches(RegexPatterns.NAME_REGEX)){
            throw new SaisieException("Le nom doit faire entre 3 et 20 caracteres et ne contenir que des caracteres alphabetiques");
        }

        this.lastName = capitalize(lastName);
    }

    @Override
    public String toString(){
       return getFirstName() + " " + getLastName();
    }


}
