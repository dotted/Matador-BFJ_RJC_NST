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
public class Brewery extends Field implements ILease {
    
    private Deed deed;
    
    public Brewery(String name, Zone zone, Deed deed)
    {
        super(name,zone);
        this.deed = deed;                
    }
    
    public int getLease()
    {        
        return 1;
    }
    
    public Deed getDeed()
    {
        return this.deed;
    }
}
