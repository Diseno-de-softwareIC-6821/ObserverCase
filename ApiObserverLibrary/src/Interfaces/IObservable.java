/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Observer.AbstractObserver;



/**
 *
 * @author Esteb
 */
public interface IObservable {
    public void addObserver(AbstractObserver observer);       
    public void removeObserver(AbstractObserver observer);       
    public void notifyAllObservers(Object source);   
}
