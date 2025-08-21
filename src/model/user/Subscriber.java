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
        email = email
                .trim()
                .toLowerCase();
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Email invalide");
        }
            this.email = email;
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
