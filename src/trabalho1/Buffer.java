/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angelo.leal
 */
public class Buffer {
    
    private int valor;
    private boolean ocupado;
    
    public Buffer(){
        this.valor = 0;
        this.ocupado = false;
    }

    public synchronized void escrever(int i) {
        if(this.ocupado){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.ocupado = true;
            this.valor++;
            System.out.println("Escreveu: " + this.valor);
            notifyAll();
            this.ocupado = false;
        }
    }
    
    public synchronized int ler(){
        try {
            if(this.valor == 0) {
                wait();
            } else {
                this.valor = 0;
                notify();
                System.out.println("Leu 0: " + this.valor);
            }
            
        }
        catch(InterruptedException e) {
            
        }
        return this.valor;
    }
    
    
}
