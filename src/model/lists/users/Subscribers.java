package model.lists.users;

import model.user.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class Subscribers {
    public static List<Subscriber> subscribers = new ArrayList<>();;


    public List<Subscriber> getSubscribers(){
        return subscribers;
    }

    public void setSubscribers(List<Subscriber> subscribers){
        this.subscribers = subscribers;
    }

    public void addSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }


    public static Subscriber findSubscriberByEmail(String email) {
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getEmail().equals(email)) {
                return subscriber;
            }
        }
        return null;
    }

    public static Subscriber findSubscriberByLastName(String lastName) {
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getLastName().equals(lastName)) {
                return subscriber;
            }
        }
        return null;
    }

    public static void removeSubscriber(String email) {
        Subscriber subscriber = findSubscriberByEmail(email);
        subscribers.remove(subscriber);
    }




}
