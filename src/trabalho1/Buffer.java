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

    public Buffer() {
        this.valor = 0;
        this.ocupado = false;
    }

    public synchronized void escrever(int i) {

        while (this.ocupado) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.ocupado = true;
        this.valor = this.valor + i;
        System.out.println("Escreveu: " + this.valor);
        notifyAll();
    }

    public synchronized int ler() {
        while (!this.ocupado) {
            try {
                if (this.valor == 0) {
                    wait();
                }
            } catch (InterruptedException e) {

            }
        }
        this.ocupado = false;
        if (this.valor != 0) {
            System.out.println("Leu 0: " + this.valor);
        }
        this.valor = 0;
        notify();

        return this.valor;
    }

}
