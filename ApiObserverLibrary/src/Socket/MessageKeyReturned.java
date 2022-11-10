/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socket;

/**
 *
 * @author Esteb
 */
public class MessageKeyReturned extends abstractMessage<String>{
    
    public MessageKeyReturned(String idString){
        super(idString);
    }
    
    @Override
    public String doSomething() {
        return this.getIdDestination();
    }
    
}
