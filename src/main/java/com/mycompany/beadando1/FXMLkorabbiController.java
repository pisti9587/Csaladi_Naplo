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

import com.mycompany.db.Adatbazis;
import com.mycompany.db.EgysegesLekerdezes;
import com.mycompany.db.FelhasznalDAO;
import com.mycompany.db.Naplok;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gégény István
 */
public class FXMLkorabbiController implements Initializable {

    private List<Naplok> NaploLista = FelhasznalDAO.lekerjegyzet();
    String felhasznalo;
    String cime;

    @FXML
    private Button buttonkorabbivissza;

    @FXML
    private Button buttonkorabbibetoltes;

    @FXML
    private Label labelkorabbi;

    @FXML
    private ChoiceBox<String> choiceBox = new ChoiceBox<>();

    @FXML
    private void vissza(ActionEvent event) throws IOException {

        Stage stage;
        Parent root;

        stage = (Stage) buttonkorabbivissza.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FXMLbellehet.fxml"));
        root = (Parent) loader.load();
        loader.<FXMLbellehetController>getController();

        FXMLbellehetController nev = (FXMLbellehetController) loader.getController();
        nev.nev(felhasznalo);

        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    @FXML
    private void betoltes(ActionEvent event) throws IOException {
        for (Naplok l : NaploLista) {
            if (l.getCim().equals(choiceBox.getValue())) {
                labelkorabbi.setText(l.getJegyzet());
                cime = choiceBox.getValue();
            }
        }
    }

    public void menu(ArrayList<String> lista, String felhasznal) {
        for (int i = 0; i < lista.size(); ++i) {
            choiceBox.getItems().add(lista.get(i));

        }
        felhasznalo = felhasznal;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
