/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package matador;

import java.util.HashMap;

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

        Player test = new Player();
        HashMap<Integer, Integer> housePrice = new HashMap<Integer, Integer>();
        housePrice.put(1, 2000);
        housePrice.put(2, 3000);
        UpgradeableDeed test1 = new UpgradeableDeed(1000, 2000,test, housePrice);
        System.out.println(test1.getHousePrice());

        Zone zone = new Zone();
        Start startField = new Start("start", zone, 4000);
        Parking parkingField = new Parking("parking", zone, 4000);
        System.out.println(startField.getReward());
        System.out.println(parkingField.getReward());

    }
    
}
