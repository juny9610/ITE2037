import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
	private ArrayList<Observer> observers = new ArrayList<>();
	
	public abstract int getNumber();
	public abstract void execute();
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		Iterator<Observer> it = observers.iterator();
		while(it.hasNext()) {
			Observer o = (Observer)it.next();
			o.update(this);
		}
	}
}
