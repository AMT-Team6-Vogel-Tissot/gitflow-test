import java.util.List;

public class Twitter implements IObservable {

    private List<IObserver> observers;
    private List<String> twits;

    public Twitter(){}
    public Twitter(List<IObserver> observers){
        throw new RuntimeException();
    }

    public List<IObserver> getObservers(){
        throw new RuntimeException();
    }

    public String getLastTwit(){
        throw new RuntimeException();
    }

    public void post(String twit){
        throw new RuntimeException();
    }

    private boolean exists(IObserver followerToFind){
        throw new RuntimeException();
    }

    public List<String> getTwits(){
        throw new RuntimeException();
    }

    @Override
    public void Subscribe(List<IObserver> observer) {
        throw new RuntimeException();
    }

    @Override
    public void Unsubscribe(IObserver observer) {
        throw new RuntimeException();
    }

    @Override
    public void Notify() {
        throw new RuntimeException();
    }
}
