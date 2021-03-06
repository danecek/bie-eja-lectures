/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.ordersclient.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import org.eja.ordersclient.controller.AbstractLibAction.Disable;
import org.eja.ordersclient.ActionsState;

/**
 *
 * @author danecek
 */
public abstract class AbstractLibAction implements Observer {

    interface Disable {

        public void setDisable(boolean b);
    }

    static class LibMenuItem extends MenuItem implements Disable {

        private LibMenuItem(String name) {
            super(name);
        }

    }

    static class LibButton extends Button implements Disable {

        private LibButton(String name) {
            super(name);
        }

    }
    private final String name;
    private final Collection<Disable> items = new ArrayList<>();

    public AbstractLibAction(String name) {
        this.name = name;
        ActionsState.instance.addObserver(this);
    }

    public MenuItem genMenuItem() {
        LibMenuItem mi = new LibMenuItem(name);
        items.add(mi);
        mi.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                execute();
            }
        });
        return mi;
    }

    public Button genButton() {
        LibButton mi = new LibButton(name);
        items.add(mi);
        mi.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                execute();
            }
        });
        return mi;
    }

    public boolean testDisable() {
        return false;
    }

    @Override
    public void update(Observable o, Object arg) {
        boolean d = testDisable();
        for (Disable item : items) {
            item.setDisable(d);
        }
    }

    public abstract void execute();

}
