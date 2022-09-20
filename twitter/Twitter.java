import java.util.List;

public class Twitter implements IObservable {

    private List<IObserver> observers;
    private List<String> twits;

    public Twitter(){}
    public Twitter(List<IObserver> observers){
        throw new UnsupportedOperationException();
    }

    public List<IObserver> getObservers(){
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }

    @Override
    public void Subscribe(List<IObserver> observer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void Unsubscribe(IObserver observer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void Notify() {
        throw new UnsupportedOperationException();
    }
}
