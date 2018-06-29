import java.util.List;

public interface IAsteroidImpactSubject {
    void attach(IAsteroidImpactObserver observer);

    void detach(IAsteroidImpactObserver observer);

    void notifyObservers();
}
