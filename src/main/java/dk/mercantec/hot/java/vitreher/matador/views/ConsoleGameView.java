package dk.mercantec.hot.java.vitreher.matador.views;

import dk.mercantec.hot.java.vitreher.matador.controllers.ConsoleGameController;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by BFJ on 14-02-14.
 */
public class ConsoleGameView implements Observer {

    public void addController(ActionListener controller) {
        controller.actionPerformed();
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
