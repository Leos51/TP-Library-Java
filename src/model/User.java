package model;

import java.time.LocalDate;
import java.util.Date;

import static utils.Validator.isValidEmail;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate registerDate ;

    User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.registerDate = LocalDate.now();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(isValidEmail(email)){
            this.email = email;
        }else{
            System.err.println("Invalid Email");
        }
    }

}
