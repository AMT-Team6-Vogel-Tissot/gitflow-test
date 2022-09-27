package src;

import java.util.List;

public interface IObservable {
    //Subscribe an Observer to an Observable
    void Subscribe(List<IObserver> observer) throws Twitter.SubscriberAlreadyExistsException;

    //Unsubscribe an Observer from an Observable
    void Unsubscribe(IObserver observer) throws Twitter.EmptyListOfSubscribersException, Twitter.SubscriberNotFoundException;

    //Notify all Observers about a post, an event and any kind of updates
    void Notify() throws Twitter.EmptyListOfSubscribersException;
}
