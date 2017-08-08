/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

/**
 *
 * @author angelo.leal
 */
public class Leitor implements Runnable{
    
    private Buffer buffer;
    
    public Leitor (Buffer buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void run (){
        this.buffer.ler();
    }

}
