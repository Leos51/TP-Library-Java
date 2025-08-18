package model.person;

import java.time.LocalDate;

import static utils.Validator.isValidEmail;

public class User extends Person {
    private String email;
    private LocalDate registrationDate ;

    User(String firstName, String lastName, String email) {
        super(firstName, lastName);
        this.email = email;
        this.registrationDate = LocalDate.now();
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
