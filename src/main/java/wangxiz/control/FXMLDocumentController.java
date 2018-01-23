package wangxiz.control;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class FXMLDocumentController {
    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;
    
    @FXML
    private AnchorPane root;

    public static AnchorPane rootP;

    private HamburgerBackArrowBasicTransition transition;

    @FXML
    public void initialize() {
        rootP = root;

        try {
            FXMLLoader loader = new FXMLLoader();
            String fxmlDocPath = "src/main/java/wangxiz/view/SidePanelContent.fxml";
            FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
            VBox box = loader.load(fxmlStream);
            drawer.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
    }

    @FXML
    private void onHamburgerMousePress() {
        transition.setRate(transition.getRate()*-1);
        transition.play();

        if(drawer.isShown()) drawer.close();
        else drawer.open();
    }
}
