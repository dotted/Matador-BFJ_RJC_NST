package dk.mercantec.hot.java.vitreher.matador.dataStructures;

/**
 *
 * @author Nicolai
 */
public class Deed {

    private int deedPrice;
    private int pawnPrice;
    private int owner;

    public Deed(int deedPrice, int pawnPrice)
    {
        this.deedPrice = deedPrice;
        this.pawnPrice = pawnPrice;
    }

    public int getDeedPrice()
    {
        return this.deedPrice;
    }

    public int getPawnPrice()
    {
        return this.pawnPrice;
    }
    
   public void setOwner(int player)
   {
       this.owner = player;
   }
   
   public int getOwner()
   {
       return this.owner;
   }
}
