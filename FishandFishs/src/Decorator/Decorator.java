/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

/**
 *
 * @author eliasvidal
 */
public abstract class Decorator implements ITotal{

    public ITotal total;
    
    public Decorator(ITotal total){
        this.total = total;
    }
    
    @Override
    public double total() {
        return total.total();
    }
    
}
