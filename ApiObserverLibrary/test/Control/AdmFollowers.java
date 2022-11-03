/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Celebrity;
import Model.Follower;
import java.util.ArrayList;

/**
 *
 * @author Esteb
 */
public class AdmFollowers {
    private ArrayList<Follower> listaFollowers;
    private static AdmFollowers instance;
    private AdmFollowers(){
        listaFollowers = new ArrayList<>();
    }
    
    public static AdmFollowers getInstance(){
        if(instance ==null ){
            instance = new AdmFollowers();
        }
        return instance;
    }
    public void addFollowers(Follower a){
        listaFollowers.add(a);
    }
    public Follower createFollower(String name){
        return new Follower(name);
    }
    public Follower search(String name){
        for(Follower oneFollower: listaFollowers){
            if(oneFollower.equals(name)){
                return oneFollower;
            }
        }
        return null;
    }
    
}
