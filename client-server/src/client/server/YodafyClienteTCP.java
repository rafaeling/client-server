/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.server;

/**
 *
 * @author rafaeing
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class YodafyClienteTCP {

	public static void main(String[] args) {
		
		//byte []buferEnvio;
                
                PrintWriter outPrinter;
                BufferedReader inReader;
                
                
                
		String buferRecepcion="";
                
		int bytesLeidos=0;
		
		// Nombre del host donde se ejecuta el servidor:
		String host="localhost";
                
		// Puerto en el que espera el servidor:
		int port=8989;
                
		// Socket para la conexión TCP
		Socket socketServicio=null;
		
		try {
			// Creamos un socket que se conecte a "host" y "port":
                        socketServicio =new Socket (host,port);

                        
			//InputStream inputStream = socketServicio.getInputStream();
			inReader = new BufferedReader(new InputStreamReader(socketServicio.getInputStream()));
                        
                        //OutputStream outputStream = socketServicio.getOutputStream();
                        outPrinter = new PrintWriter(socketServicio.getOutputStream(),true);
			
                        
			// Si queremos enviar una cadena de caracteres por un OutputStream, hay que pasarla primero
			// a un array de bytes:
			//buferEnvio="Al monte del volcán debes ir sin demora\0".getBytes();
			
                        
			// Enviamos el array por el outputStream;
                        
                        //outPrinter.write(buferEnvio,0,buferEnvio.length);
                        //outPrinter.write("Al monte del volcán debes ir sin demora\0");
                        outPrinter.println("Al monte del volcán debes ir sin demora\0");
                        //outputStream.write(buferEnvio,0,buferEnvio.length);
                        
                        
			// Aunque le indiquemos a TCP que queremos enviar varios arrays de bytes, sólo
			// los enviará efectivamente cuando considere que tiene suficientes datos que enviar...
			// Podemos usar "flush()" para obligar a TCP a que no espere para hacer el envío:
			
                        
                        //outputStream.flush();
                          outPrinter.flush();
                        
			// Leemos la respuesta del servidor. Para ello le pasamos un array de bytes, que intentará
			// rellenar. El método "read(...)" devolverá el número de bytes leídos.
			
                        buferRecepcion = inReader.readLine();
                        
                        
                        // Hay que reservar memoria para almacenar lo leído
                        // Intenta leer tantos bytes como posiciones tiene el
                        // array de bytes, aunque es posible que no haya
                        // tantos datos, y sólo se lean bytesLeidos:
                        
			// MOstremos la cadena de caracteres recibidos:
			System.out.println("Recibido: ");
			System.out.print(buferRecepcion);
			
			
			// Una vez terminado el servicio, cerramos el socket (automáticamente se cierran
			// el inpuStream  y el outputStream)
			
                        
                        socketServicio.close();
                        
                        
			// Excepciones:
		} catch (UnknownHostException e) {
			System.err.println("Error: Nombre de host no encontrado.");
		} catch (IOException e) {
			System.err.println("Error de entrada/salida al abrir el socket.");
		}
	}
}
