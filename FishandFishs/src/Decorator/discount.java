/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

/**
 *
 * @author eliasvidal
 */
public class discount extends Decorator{
    
    public discount(ITotal total) {
        super(total);
    }
    
    @Override
    public double total(){
        return super.total() * 0.8;
    }
    
}
