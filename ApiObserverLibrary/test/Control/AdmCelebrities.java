/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Celebrity;
import java.util.ArrayList;

/**
 *
 * @author Esteb
 */
public class AdmCelebrities {
    private ArrayList<Celebrity> listaCelebridades;
    private static AdmCelebrities instance;
    private AdmCelebrities(){
        listaCelebridades = new ArrayList<>();
    }
    
    public static AdmCelebrities getInstance(){
        if(instance ==null ){
            instance = new AdmCelebrities();
        }
        return instance;
    }
    public void addCelebrity(Celebrity a){
        listaCelebridades.add(a);
    }
    public Celebrity createCelebrity(String name){
        return new Celebrity(name);
    }
    public Celebrity search(String name){
        for(Celebrity oneCelebrity: listaCelebridades){
            if(oneCelebrity.equals(name)){
                return oneCelebrity;
            }
        }
        return null;
    }
    public void inactivate(Celebrity celebrity){ //darse de baja
        celebrity.setState(false);
    }
}
