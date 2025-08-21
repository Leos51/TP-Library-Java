package controller;

import model.lists.users.Subscribers;
import model.user.Subscriber;
import view.Menu;

public class SubscriberController {

    public static void seedSubscriberData() {
        Subscribers.addSubscriber(new Subscriber("Alice", "Dupont", "alice.dupont@email.com"));
        Subscribers.addSubscriber(new Subscriber("Jean", "Martin", "jean.martin@email.com"));
        Subscribers.addSubscriber(new Subscriber("Sophie", "Bernard", "sophie.bernard@email.com"));
        Subscribers.addSubscriber(new Subscriber("Karim", "Bouchard", "karim.bouchard@email.com"));
        Subscribers.addSubscriber(new Subscriber("Léa", "Fontaine", "lea.fontaine@email.com"));
    }

    public static void displaySubscribers(){
        System.out.println("Liste des abonnés");
        System.out.println("----------------");
        for (Subscriber subscriber : Subscribers.getSubscribers()){
            System.out.println(subscriber.toString());
        }
        Menu.displayMainMenu();
    }
}
