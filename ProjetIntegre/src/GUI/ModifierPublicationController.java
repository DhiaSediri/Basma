/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Publication;
import Services.ServicePublication;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class ModifierPublicationController implements Initializable {

    @FXML
    private TextArea taMessage;
    @FXML
    private Button btnModifier;
    @FXML
    private TextField tfTitre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Modifier(MouseEvent event) throws SQLException {
        int idPublication = 1;
        String titre = tfTitre.getText();
        String contenu = taMessage.getText();

        ServicePublication sp = new ServicePublication();
        Publication p = new Publication(idPublication, titre, contenu);

        sp.update(p);

        
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ForumDashboard.fxml"));
            Parent root = loader.load();

            TransportDashboardController r = loader.getController();
            btnModifier.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    }
    

