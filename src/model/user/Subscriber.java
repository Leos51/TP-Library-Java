package model.user;

import java.time.LocalDate;

import static utils.DateFormat.format;
import static utils.validator.Validator.isValidEmail;

public class Subscriber extends User {
    private String email;
    private LocalDate registrationDate;

    public Subscriber(String firstName, String lastName, String email) {
        super(firstName, lastName);
        this.email = email;
        this.registrationDate = LocalDate.now();
    }

    public Subscriber(String firstName, String lastName, String email, LocalDate registrationDate) {
        super(firstName, lastName);
        this.email = email;
        this.registrationDate = registrationDate;
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

    public String getRegistrationDate() {
        return format(registrationDate);
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString(){
        return super.toString() + " - Date d'inscription: " + getRegistrationDate();
    }
}
