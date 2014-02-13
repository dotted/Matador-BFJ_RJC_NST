package dk.mercantec.hot.java.vitreher.matador.dataStructures;

/**
 *
 * @author Nicolai
 */
public class Field {
    private String zone;
    private String name;

    public Field(String name, String zone)
    {
        this.name = name;
        this.zone = zone;
    }

    public String getName()
    {
        return this.name;
    }
    
   public String getZone()
   {
       return this.zone;
   }
}
