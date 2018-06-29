import java.util.ArrayList;
import java.util.List;

public class AsteroidImpactSubject implements IAsteroidImpactSubject {
    private List<IAsteroidImpactObserver> observers;

    public AsteroidImpactSubject() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void attach(IAsteroidImpactObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(IAsteroidImpactObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IAsteroidImpactObserver observer : observers) {
            observer.update();
        }
    }
}
