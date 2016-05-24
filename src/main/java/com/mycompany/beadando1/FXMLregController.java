/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beadando1;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.mycompany.db.Adatbazis;
import com.mycompany.db.EgysegesEntitasKezelo;
import com.mycompany.db.EgysegesLekerdezes;
import com.mycompany.db.FelhasznalDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gégény István
 */
public class FXMLregController implements Initializable {

    private List<Adatbazis> FelhasznaloLista = FelhasznalDAO.lekerfelhasznalo();

    @FXML
    private TextField tfregfelhasznalo;

    @FXML
    private PasswordField tfregjelszo;

    @FXML
    private CheckBox cbregelfogad;

    @FXML
    private Button buttonregregisztracio;

    @FXML
    private Button buttonregmegse;

    @FXML
    private Label uzenet;

    @FXML
    private void megse(ActionEvent event) throws IOException {

        Stage stage;
        Parent root;

        stage = (Stage) buttonregmegse.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
        root = (Parent) loader.load();
        loader.<FXMLController>getController();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Családi Napló");

        stage.show();
    }

    @FXML
    private void regisztracio(ActionEvent event) throws NoSuchAlgorithmException, IOException {

        for (Adatbazis l : FelhasznaloLista) {
            if (tfregfelhasznalo.getText().equals(l.getFelhasznalonev())) {
                uzenet.setText("Már van ilyen regisztrált felhasználó.");
                tfregfelhasznalo.clear();
                tfregjelszo.clear();
                return;
            }
        }
        if (tfregfelhasznalo.getText().isEmpty() == true || tfregjelszo.getText().isEmpty() == true) {
            uzenet.setText("Kérem írjon be felhasználónevet és jelszót!");
            return;
        } else {
            if (cbregelfogad.isSelected()) {

                FelhasznalDAO.felhasznaloHozzaad(tfregfelhasznalo.getText(), tfregjelszo.getText());
                ((Node) (event.getSource())).getScene().getWindow().hide();

                Stage stage;
                Parent root;

                stage = (Stage) buttonregregisztracio.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                root = (Parent) loader.load();
                loader.<FXMLController>getController();

                Scene scene = new Scene(root);
                stage.setScene(scene);

                stage.show();

            } else {
                uzenet.setText("Kérem fogadja el a feltételeket");
                return;

            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
