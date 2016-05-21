/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beadando1;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.mycompany.db.EgysegesEntitasKezelo;
import com.mycompany.db.EgysegesLekerdezes;
import com.mycompany.db.Naplok;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gégény István
 */
public class FXMLszerkesztesController implements Initializable {

	 private List<Naplok> NaploLista = new ArrayList<>();
	 private EgysegesLekerdezes jegyzetek = new EgysegesLekerdezes();
	 String felhasznalo;
	 ArrayList <String> elemek = new ArrayList<>();
	 
     @FXML
    private Button  buttonkorabbivissza;

    @FXML
    private Button mentes;

   
    @FXML
    private Label cim;
    
   @FXML
   private TextArea textarea;
    
    
    
    
     @FXML
     private void vissza(ActionEvent event) throws IOException {
      
    	 
    	 Stage stage;
         Parent root;

         stage = (Stage) buttonkorabbivissza.getScene().getWindow();

        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FXMLkorabbi.fxml"));
         root = (Parent) loader.load();
         loader.<FXMLkorabbiController>getController();
         
         
         
        
         
         
         
         for (Naplok l : NaploLista)
   			if (l.getFelhasznalonev().equals(felhasznalo)) {
   						elemek.add(l.getCim());
         
   			}
         
         
       
         
         
         
         FXMLkorabbiController kor = (FXMLkorabbiController) loader.getController();
         
          kor.menu(elemek,felhasznalo);
         Scene scene = new Scene(root);
         
         stage.setScene(scene);
     
         stage.show();  
    	 
    	 
    	 
    	 
  
    }
    
     
     @FXML
     private void mentes(ActionEvent event) throws IOException {
    	
     for( Naplok l: NaploLista)
    	 if ( l.getCim().equals(cim.getText())){
    		 
    		 l.setJegyzet(textarea.getText());
    		 EgysegesEntitasKezelo es = new EgysegesEntitasKezelo();
    		 es.em.merge(l);
    		 es.em.getTransaction().commit();
  			 es.em.close();    		 
    	 }
    	 
    	 
    	 
    	 
    	 
    	 
    }
    
    
   
    
    
    public void nev(String nev, String szoveg, String cime){
    	felhasznalo=nev;
    	textarea.setText(szoveg);
    	cim.setText(cime);
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	NaploLista = jegyzetek.eddigiJegyzetek();
    }    
    
}
