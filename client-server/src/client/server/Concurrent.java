/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.server;

/**
 *
 * @author rafaeling
 */
public class Concurrent {
      public static void main(String[] args){
          
        YodafyServidorIterativo servidor= new YodafyServidorIterativo();
        
        YodafyClienteTCP cliente1= new YodafyClienteTCP();
        YodafyClienteTCP cliente2= new YodafyClienteTCP();
        YodafyClienteTCP cliente3= new YodafyClienteTCP();
        YodafyClienteTCP cliente4= new YodafyClienteTCP();
        YodafyClienteTCP cliente5= new YodafyClienteTCP();
        YodafyClienteTCP cliente6= new YodafyClienteTCP();
        YodafyClienteTCP cliente7= new YodafyClienteTCP();
        
        
        
        servidor.start();
        
        
        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();
        cliente6.start();
        cliente7.start();
        
    }
}
