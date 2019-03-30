package Modele;

import java.util.ArrayList;

public class Observable {
	
	private ArrayList<Observer> observers;
	
	public Observable() {
		this.observers = new ArrayList<Observer>();
	}
	
    void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
    
    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

}
