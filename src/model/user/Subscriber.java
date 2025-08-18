package model.user;

import java.time.LocalDate;

import static utils.Validator.isValidEmail;

public class Subscriber extends User {
    private String email;
    private LocalDate registrationDate ;

    Subscriber(String firstName, String lastName, String email) {
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
