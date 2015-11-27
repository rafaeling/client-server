/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.server;

/**
 *
 * @author rafae
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//
// YodafyServidorIterativo
// (CC) jjramos, 2012
//
public class YodafyServidorIterativo {

	public static void main(String[] args) {
	
            // Puerto de escucha
            int port=888;
            // array de bytes auxiliar para recibir o enviar datos.
            byte []buffer=new byte[256];
            // Número de bytes leídos
            
            int bytesLeidos=0;
            
            ServerSocket serverSocket;
            Socket socketServicio;
            
                
            try {
			// Abrimos el socket en modo pasivo, escuchando el en puerto indicado por "port"
			//////////////////////////////////////////////////
			// ...serverSocket=... (completar)
			//////////////////////////////////////////////////
			 serverSocket = new ServerSocket(port);
                        
			// Mientras ... siempre!
			do {
				
				// Aceptamos una nueva conexión con accept()
				/////////////////////////////////////////////////
				// socketServicio=... (completar)
				//////////////////////////////////////////////////
				
                                socketServicio = serverSocket.accept();
                                
				// Creamos un objeto de la clase ProcesadorYodafy, pasándole como 
				// argumento el nuevo socket, para que realice el procesamiento
				// Este esquema permite que se puedan usar hebras más fácilmente.
				ProcesadorYodafy procesador=new ProcesadorYodafy(socketServicio);
				procesador.procesa();
                                
				
			} while (true);
			
		} catch (IOException e) {
                System.out.println("Error: no se pudo atender en el puerto "+port);
                }

	}

}
