/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package matador;

/**
 *
 * @author Nicolai
 */
public class Field extends java.util.Observable {
    private Zone zone;
    private String name;
    
    public Field(String name, Zone zone)
    {
        this.name = name;
        this.zone = zone;
    }
    
    public String getName()
    {
        return this.name;
    }
}
