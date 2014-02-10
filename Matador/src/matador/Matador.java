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
public class Matador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Zone zone = new Zone();
        Start startField = new Start("start", zone, 4000);
        Parking parkingField = new Parking("parking", zone, 4000);
        System.out.println(startField.getReward());
        System.out.println(parkingField.getReward());
    }
    
}
