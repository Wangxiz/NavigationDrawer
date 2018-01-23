package wangxiz.control;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FXMLDocumentController {
    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;
    
    @FXML
    private AnchorPane root;

    public static AnchorPane rootP;

    private Stage primaryState;

    public void setPrimaryState(Stage primaryState) {
        this.primaryState = primaryState;
    }

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

        drawer.setOnDrawerOpening(e -> {
            Transition animation = hamburger.getAnimation();
            animation.setRate(1);
            animation.play();
        });

        drawer.setOnDrawerClosing(e -> {
            Transition animation = hamburger.getAnimation();
            animation.setRate(-1);
            animation.play();
        });
    }

    @FXML
    private void onHamburgerMousePress() {
        if(drawer.isHidden() || drawer.isHiding()) drawer.open();
        else drawer.close();
    }

    @FXML
    private void handleFullScreen() {
        if(primaryState.isFullScreen()) {
            primaryState.setFullScreen(false);
        }
        else {
            primaryState.setFullScreen(true);
        }
    }
}