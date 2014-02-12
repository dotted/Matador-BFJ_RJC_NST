/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package matador;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Nicolai
 */
public class GameBoard extends java.util.Observable {
    
    private HashMap<Zone, Field[]> fieldsZone;
    private HashMap<Player, Field> playersPosition;
    private ArrayList<Field> fields;
    
    /**
     * This will create an GameBoard object which will set
     * the start position of every player upon creation,
     * it will store information about the players current position
     * and which fields are contained on the GameBoard and the
     * games players.
     * @param fieldsZone
     * @param startField
     * @param players
     * @param fields 
     */
    
    public GameBoard(HashMap fieldsZone, Field startField, Player[] players, ArrayList<Field> fields)
    {
        this.fieldsZone = fieldsZone;
        this.fields = fields;
        for (Player player : players) 
        {
            this.playersPosition.put(player, startField);
        }        
    }
    
    /**
     * This will return the Fields
     * which are located in the asked Zone
     * @param zone
     * @return Field[]
     */
    
    public Field[] getFieldsInZone(Zone zone)
    {
        return this.fieldsZone.get(zone);
    }
    
    /**
     * This method will update the position of
     * a player in the playersPosition hashmap
     * @param eyes
     * @param player 
     */
    public void movePlayer(IDice eyes,Player player)
    {
        Field currentField = this.playersPosition.get(player);
        int currentIndex = this.fields.indexOf(currentField);
        int newIndex = currentIndex + eyes.getEyes();
        if (newIndex > this.fields.size())
            newIndex /= this.fields.size();
        Field newField = this.fields.get(newIndex);
        this.playersPosition.put(player, newField);
    }
    
    /**
     * This method will return the list of
     * field in GameBoard
     * @return ArrayList<Field>
     */
    public ArrayList<Field> getFields()
    {
        return this.fields;
    }
    
}
