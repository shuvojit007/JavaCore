package Design_Pattern.Observer_Pattern;

public interface Observable {
    //resgister all the observer
    public void registerObserver(Observer observer);

    public void notifyObservers();
    public void removeObserver(Observer observer);
}
