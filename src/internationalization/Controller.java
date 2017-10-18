/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internationalization;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author marco
 */
public class Controller implements ActionListener{
    View view;
    Locale locale;
    ResourceBundle labels;
    
    public Controller(){
        view = new View();
        view.lenguageButton.addActionListener(this);
        initComponents("es");
        view.setVisible(true);
    }
    
    public void initComponents(String lenguage){
        locale = new Locale(lenguage);
        getResources();
        view.setTitle(labels.getString("title"));
        view.historyLabel.setText(labels.getString("history"));
        view.lenguageButton.setText(labels.getString("button"));
    }
    
    public void getOpcionLenguage(){
        int option = view.lenguageComboBox.getSelectedIndex();
        switch(option){
            case 0:
                initComponents("es");
                break;
            case 1:
                initComponents("en");
                break;
            case 2:
                initComponents("fr");
                break;
        }
    }
    
    public void getResources(){
        labels = ResourceBundle.getBundle("lenguages.lenguage", locale);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.lenguageButton){
            getOpcionLenguage();
        }
    }
}
