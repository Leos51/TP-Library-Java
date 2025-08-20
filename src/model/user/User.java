<<<<<<<< HEAD:src/model/person/Person.java
package model.person;

public class Person {
    private String firstName;
    private String lastName;

    Person(String firstName, String lastName) {
========
package model.user;

public class User {
    private String firstName;
    private String lastName;

    User(String firstName, String lastName) {
>>>>>>>> 439b7c9 (end of day):src/model/user/User.java
        this.firstName = firstName;
        this.lastName = lastName;
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

<<<<<<<< HEAD:src/model/person/Person.java
========
    @Override
    public String toString(){
       return getFirstName() + " " + getLastName();
    }
>>>>>>>> 439b7c9 (end of day):src/model/user/User.java


}
