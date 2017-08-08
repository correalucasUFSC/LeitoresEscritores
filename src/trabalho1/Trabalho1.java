/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author angelo.leal
 */
public class Trabalho1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Buffer buffer = new Buffer();
        ExecutorService executer_leitores = Executors.newFixedThreadPool(4);
        ScheduledExecutorService executer_escritor = Executors.newScheduledThreadPool(1);
        
        
        
        for (int i = 0; i < 120; i++){
            executer_escritor.scheduleAtFixedRate(new Escritor(buffer), 0, 1, TimeUnit.MILLISECONDS);
            
            executer_leitores.execute(new Leitor(buffer));
        }
        
        executer_escritor.shutdownNow();
        executer_leitores.shutdownNow();
        
    }
    
}
