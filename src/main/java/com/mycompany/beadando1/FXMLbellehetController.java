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
import com.mycompany.db.FelhasznalDAO;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gégény István
 */
public class FXMLbellehetController implements Initializable {

    private List<Naplok> NaploLista = FelhasznalDAO.lekerjegyzet();
    ArrayList<String> elemek = new ArrayList<>();

    @FXML
    private Button buttonbellementes;

    @FXML
    private Button buttonbellekilepes;

    @FXML
    private Button buttonbellekorabbi;

    @FXML
    private TextField tfbellecim;

    @FXML
    private TextArea tabelleszoveg;

    @FXML
    private Label labelbellefelhaszn;

    @FXML
    private Label uzenet;

    @FXML
    private void kilepes(ActionEvent event) throws IOException {

        Stage stage;
        Parent root;

        stage = (Stage) buttonbellekilepes.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
        root = (Parent) loader.load();
        loader.<FXMLController>getController();

        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    @FXML
    private void korabbi(ActionEvent event) throws IOException {

        Stage stage;
        Parent root;

        stage = (Stage) buttonbellekorabbi.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FXMLkorabbi.fxml"));
        root = (Parent) loader.load();
        loader.<FXMLkorabbiController>getController();

        for (Naplok l : NaploLista) {
            if (l.getFelhasznalonev().equals(labelbellefelhaszn.getText())) {
                elemek.add(l.getCim());

            }
        }

        FXMLkorabbiController kor = (FXMLkorabbiController) loader.getController();

        kor.menu(elemek, labelbellefelhaszn.getText());
        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.show();
    }

    @FXML
    private void mentes(ActionEvent event) throws IOException {

        if (tfbellecim.getText().isEmpty() == true || tabelleszoveg.getText().isEmpty() == true) {
            uzenet.setText("Kérem töltse ki a mezőket");
            return;
        } else {
            uzenet.setText("");

            FelhasznalDAO.jegyzetHozzaad(labelbellefelhaszn.getText(), tfbellecim.getText(), tabelleszoveg.getText());

            elemek.add(tfbellecim.getText());

        }

        tfbellecim.setText(null);
        tabelleszoveg.setText(null);

    }

    public void nev(String nev) {
        labelbellefelhaszn.setText(nev);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
