/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptranetconfig;
import java.awt.Color;
import java.awt.TextComponent;
import java.awt.event.*;
/**
 *
 * @author a.sinenko
 */
public class TextChangingEvent implements TextListener{

    @Override
    public void textValueChanged(TextEvent e){
        TextComponent tc = (TextComponent)e.getSource();
        tc.setBackground(Color.red);
    }
    
}
