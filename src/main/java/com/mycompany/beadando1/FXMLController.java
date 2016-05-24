package com.mycompany.beadando1;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;

import com.mycompany.db.Adatbazis;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

    private List<Adatbazis> FelhasznaloLista = FelhasznalDAO.lekerfelhasznalo();

    @FXML
    private Label label;

    @FXML
    private Button buttonregisztracio;

    @FXML
    private Button buttonbelepes;

    @FXML
    private TextField tffelhasznalo;

    @FXML
    private PasswordField tfjelszo;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        boolean val = true;
        for (Adatbazis l : FelhasznaloLista) {
            val = false;
            if (l.getFelhasznalonev().equals(tffelhasznalo.getText())) {
                if (l.getJelszo().equals(tfjelszo.getText())) {

                    Stage stage;
                    Parent root;

                    stage = (Stage) buttonbelepes.getScene().getWindow();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FXMLbellehet.fxml"));
                    root = (Parent) loader.load();
                    loader.<FXMLbellehetController>getController();

                    FXMLbellehetController nev = (FXMLbellehetController) loader.getController();
                    nev.nev(tffelhasznalo.getText());

                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle("Családi Napló");

                    stage.show();

                } else {
                    label.setText("Hibás a jelszó");
                }
            } else {
                label.setText("Érvénytelen felhasználó");
            }
        }
        if (val) {
            label.setText("Nincs regisztrált felhasználó");
        }

    }

    @FXML
    private void handleButtonAction2(ActionEvent event) throws IOException {

        ((Node) (event.getSource())).getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        Stage stage = new Stage();
        Pane parent = loader.load(getClass().getResource("/fxml/FXMLreg.fxml").openStream());
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Regisztráció");
        stage.show();

    }

    @FXML
    private void kilepes(ActionEvent event) {

        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
    }
}
