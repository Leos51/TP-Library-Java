package controller;

import model.book.Book;
import model.user.Subscriber;

import java.time.LocalDate;

import static model.lists.books.Books.books;
import static model.lists.users.Subscribers.subscribers;
import static view.Menu.displayMenu;

public class SubscriberController {

    public static void seedSubscriberData() {
        subscribers.add(new Subscriber("Alice", "Dupont", "alice.dupont@email.com"));
        subscribers.add(new Subscriber("Jean", "Martin", "jean.martin@email.com"));
        subscribers.add(new Subscriber("Sophie", "Bernard", "sophie.bernard@email.com"));
        subscribers.add(new Subscriber("Karim", "Bouchard", "karim.bouchard@email.com"));
        subscribers.add(new Subscriber("Léa", "Fontaine", "lea.fontaine@email.com"));
    }

    public static void displaySubscribers(){
        System.out.println("Liste des abonnés");
        System.out.println("----------------");
        for (Subscriber subscriber : subscribers){
            System.out.println(subscriber.toString());
        }
        displayMenu();
    }
}
