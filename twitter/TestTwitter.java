import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestTwitter {

    Twitter _twitter;

    @BeforeAll
    public void setup(){
        _twitter = new Twitter();
    }

    @Test
    public void Observers_AfterInstanciationWithoutObservers_Succes(){
        //when
        //refere to Setup method
        int exceptedAmountOfObservers = 0;

        //then
        //event is called directly by the assertion

        //when
        assertEquals(exceptedAmountOfObservers, _twitter.getObservers().size());
    }

    @Test
    public void Observers_AfterInstanciationWithObservers_Succes(){
        //when
        int exceptedAmountOfObservers = 10;
        _twitter = new Twitter(GenerateObserver(exceptedAmountOfObservers));

        //then
        //event is called directly by the assertion

        //when
        assertEquals(exceptedAmountOfObservers, _twitter.getObservers().size());
    }

    @Test
    public void Twits_AfterInstanciation_Success()
    {
        //when
        int exceptedAmountOfTwits = 0;
        _twitter = new Twitter();

        //then
        //event is called directly by the assertion

        //when
        assertEquals(exceptedAmountOfTwits, _twitter.getTwits().size());
    }

    @Test
    public void Notify_EmptyListOfSubscriber_ThrowsException()
    {
        //given
        //refere to Setup method

        //when
        //event is called directly by the assertion

        //then
        assertThrows(Twitter.EmptyListOfSubscribersException.class, () -> _twitter.Notify());
    }

    @Test
    public void Subscribe_AddFirstSubscribers_Success()
    {
        //given
        //refere to Setup method
        int expectedAmountOfSubscribers = 15;
        List<IObserver> followers = GenerateObserver(expectedAmountOfSubscribers);

        //when
        _twitter.Subscribe(followers);

        //then
        assertEquals(expectedAmountOfSubscribers, _twitter.getObservers().size());
    }

    @Test
    public void Subscribe_AddSubscribersToExistingList_Success()
    {
        //given
        //refere to Setup method
        int expectedAmountOfSubscribers = 30;
        List<IObserver> followers = GenerateObserver(expectedAmountOfSubscribers / 2);
        _twitter.Subscribe(followers);
        List<IObserver> followers2nd = GenerateObserver(expectedAmountOfSubscribers / 2);

        //when
        _twitter.Subscribe(followers2nd);

        //then
        assertEquals(expectedAmountOfSubscribers, _twitter.getObservers().size());
    }

    @Test
    public void Subscribe_SubscriberAlreadyExists_ThrowsException()
    {
        //given
        //refere to Setup method
        int expectedAmountOfSubscribers = 15;
        List<IObserver> followers = GenerateObserver(expectedAmountOfSubscribers);
        _twitter.Subscribe(followers);
        List<IObserver> followersDuplicate = List.of(followers.get(0));

        //when
        //event is called directly by the assertion

        //then
        assertThrows(Twitter.SubscriberAlreadyExistsException.class, () -> _twitter.Subscribe(followersDuplicate));
    }

    @Test
    public void Unsubscribe_NominalCase_Success()
    {
        //given
        //refer to Setup method
        List<IObserver> followers = GenerateObserver(20);
        _twitter.Subscribe(followers);

        //when
        _twitter.Unsubscribe(followers.get(10));

        //then
        assertEquals(_twitter.getObservers().size() - 1, followers.size());
    }

    @Test
    public void Unsubscribe_EmptyListOfSubscriber_ThrowsException()
    {
        //given
        //refer to Setup method
        Follower followerToRemove = new Follower();

        //when
        //event is called directly by the assertion

        //then
        assertThrows(Twitter.EmptyListOfSubscribersException.class, () -> _twitter.Unsubscribe(followerToRemove));
    }

    @Test
    public void Unsubscribe_SubscriberNotFound_ThrowsException()
    {
        //given
        //refere to Setup method
        IObserver followerNotFound = new Follower();
        _twitter.Subscribe(GenerateObserver(10));

        //when
        //event is called directly by the assertion

        //then
        assertThrows(Twitter.SubscriberNotFoundException.class, () -> _twitter.Unsubscribe(followerNotFound));
    }

    private List<IObserver> GenerateObserver(int amountOfObserverToCreate)
    {
        List<IObserver> observers = new ArrayList<>();
        for (int i = 0; i < amountOfObserverToCreate; i++)
        {
            observers.add(new Follower());
        }
        return observers;
    }

}
