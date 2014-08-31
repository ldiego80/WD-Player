/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reproductor;

/**
 *
 * @author Way
 */
import java.io.File; 
import java.io.PrintStream; 
import java.util.Map; 
import javazoom.jlgui.basicplayer.*; 

public class PlayerD implements BasicPlayerListener {
    private PrintStream out = null;//Stream para el Debbugging(println)... 
     
    BasicPlayer player = new BasicPlayer();//Instancia de BasicPlayer 
    
    public PlayerD() {//Constructor de la clase 
        player.addBasicPlayerListener(this); 

        out = System.out; 
       

    } 
    BasicController control = (BasicController) player;//Controlador para player 
     
     
    //Metodos sobreescritos: 

    public void opened(Object stream, Map properties) { 

        display("opened : " + properties.toString()); 
    } 

    public void progress(int bytesread, long microseconds, byte[] pcmdata, Map properties) { 
       
        display("progress : " + properties.toString()); 
    } 

    public void stateUpdated(BasicPlayerEvent event) { 
        display("stateUpdated : " + event.toString()); 
        
    } 

    public void setController(BasicController controller) { 
        display("setController : " + controller); 
    } 

    public void display(String msg) { 
        if (out != null) { 
            out.println(msg); 
        } 
    } 
     
   
}
