/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

/**
 *
 * @author Esteb
 */
public interface IObservable {
    public void addObserver(IObserver observer);       
    public void removeObserver(IObserver observer);       
    public void notifyAllObservers(Object source);   
}
