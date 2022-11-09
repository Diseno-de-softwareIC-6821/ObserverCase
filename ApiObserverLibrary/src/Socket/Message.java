/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socket;

import java.io.Serializable;
import java.net.Socket;

/**
 *
 * @author Esteb
 */
public class Message implements Serializable{
    private String idSource;
    private Object body;
    private String idDestination;
    private String codeRequest;

   
    private Message(String idSource, Object message, String idDestination, String codeRequest){
        this.idSource = idSource;
        this.body  = message;
        this.idDestination = idDestination;
        this.codeRequest = codeRequest;
    }
    private Message(Object message, String idDestination){
        this.body = message;
        this.idDestination = idDestination;
    }

    public String getIdSource() {
        return idSource;
    }

    public Object getBody() {
        return body;
    }

    public String getIdDestination() {
        return idDestination;
    }

    public String getCodeRequest() {
        return codeRequest;
    }
    
    //request builder 
    public static class MessageBuilder{
        private String idSource;
        private Object body;
        private String idDestination;
        private String codeRequest;
        
        public MessageBuilder(){}
        
        public MessageBuilder setSource(String id){
            this.idSource = id;
            return this;
        }
        public MessageBuilder setDestination(String id ){
            this.idDestination = id;
            return this;
        }
        
        public MessageBuilder setBody(Object message){
            this.body = message;
            return this;
        }
        public MessageBuilder setCodeRequest(String code){
            this.codeRequest = code;
            return this;
        }
        public Message build(){
            return new Message(idSource, body, idDestination, codeRequest);
        }
        
        
    }


}
