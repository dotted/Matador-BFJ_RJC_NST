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
public class Shipping extends Field implements ILease {
    
    private static int[] leasePrices;
    private Deed deed;
    
    public Shipping(String name, Zone zone, Deed deed, int[] leasePrices)
    {
        super(name, zone);
        this.deed = deed;
        this.leasePrices = leasePrices;       
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
