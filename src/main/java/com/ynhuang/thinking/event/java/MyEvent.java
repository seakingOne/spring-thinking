package com.ynhuang.thinking.event.java;

import java.util.EventListener;
import java.util.EventObject;
import java.util.Observable;
import java.util.Observer;

/**
 * @author YuHuang
 */
public class MyEvent {

    public static void main(String[] args) {

        MyObservable myObservable = new MyObservable();

        MyObserver myObserver = new MyObserver();

        myObservable.addObserver(myObserver);
        myObservable.publish();

    }

    static class MyObserver implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            EventObject eventObject = (EventObject)arg;
            System.out.println("get messge info from server: " + eventObject);
        }
    }

    static class MyObservable extends Observable implements EventListener {

        @Override
        protected synchronized void setChanged() {
            super.setChanged();
        }

        public void publish() {
            setChanged();

            EventObject eventObject = new EventObject("hello world!");
            this.notifyObservers(eventObject);

            clearChanged();
        }

    }
}
