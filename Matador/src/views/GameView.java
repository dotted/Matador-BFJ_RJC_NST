/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Nicolai
 */
public class GameView implements java.util.Observer {
    
    public int askNumberOfPlayers()
    {
        String question = "How many players will there be?";
        int answer = Integer.parseInt(javax.swing.JOptionPane.showInputDialog(question));
        System.out.println(question+": "+answer);
        return answer;
    }
    
    public ArrayList<String> getNamesOfPlayers(int playerCount)
    {
        ArrayList<String> players = new ArrayList();
        String player;
        for (int i = 0; i < playerCount; i++)
        {
            String question = "What's player "+ (i+1) +" name";
            player = javax.swing.JOptionPane.showInputDialog(question);
            System.out.println("Player " + (i+1) + "'s Name: " +player);
            players.add(player);
        }
        return players;
    }
    
    public void update(Observable obs, Object obj) {

		//who called us and what did they send?
		//System.out.println ("View      : Observable is " + obs.getClass() + ", object passed is " + obj.getClass());

		//model Pull 
		//ignore obj and ask model for value, 
		//to do this, the view has to know about the model (which I decided I didn't want to do)
		//uncomment next line to do Model Pull
    		//myTextField.setText("" + model.getValue());

		//model Push 
		//parse obj
		//myTextField.setText("" + ((Integer)obj).intValue());	//obj is an Object, need to cast to an Integer

    	} //update()
    
}
