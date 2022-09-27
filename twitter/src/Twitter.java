package src;

import java.util.ArrayList;
import java.util.List;

public class Twitter implements IObservable {

    private List<IObserver> observers;
    private List<String> twits;

    public Twitter(){
        observers = new ArrayList<>();
        twits = new ArrayList<>();
    }
    public Twitter(List<IObserver> observers){

        this.observers = observers;
        twits = new ArrayList<>();
    }

    public List<IObserver> getObservers(){
        return observers;
    }

    public String getLastTwit(){
        throw new UnsupportedOperationException();
    }

    public void post(String twit){
        throw new RuntimeException();
    }

    private boolean exists(IObserver followerToFind){
        throw new UnsupportedOperationException();
    }

    public List<String> getTwits(){
        return twits;
    }

    @Override
    public void Subscribe(List<IObserver> observer) throws SubscriberAlreadyExistsException {
        for(IObserver o : observer){
            if(observers.contains(o)){
                throw new SubscriberAlreadyExistsException();
            }else {
                observers.add(o);
            }
        }
    }

    @Override
    public void Unsubscribe(IObserver observer) throws EmptyListOfSubscribersException, SubscriberNotFoundException {
        if(observers.isEmpty()) {
            throw new EmptyListOfSubscribersException();
        }

        if(!observers.remove(observer)) {
            throw new SubscriberNotFoundException();
        }
    }

    @Override
    public void Notify() throws EmptyListOfSubscribersException {
        throw new EmptyListOfSubscribersException();
    }

    public static class TwitterException extends Exception{}
    public static class EmptyListOfSubscribersException extends TwitterException{}
    public static class SubscriberAlreadyExistsException extends TwitterException{}
    public static class SubscriberNotFoundException extends TwitterException{}


}
