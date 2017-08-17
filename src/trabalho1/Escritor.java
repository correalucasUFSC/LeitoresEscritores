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
public class Escritor implements Runnable{
    
    private Buffer buffer;
    private static int i = 0;
    
    public Escritor (Buffer buffer){
        this.buffer = buffer;
    }
    
    @Override
    public void run (){
        for(int i = 0; i < 120; i++){
                    this.buffer.escrever(i);        

        }
    }
    
}
