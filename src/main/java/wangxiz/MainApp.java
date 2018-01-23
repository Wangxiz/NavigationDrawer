package wangxiz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class MainApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        String fxmlDocPath = "src/main/java/wangxiz/view/FXMLDocument.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
        Parent root = loader.load(fxmlStream);
        
        Scene scene = new Scene(root);

        stage.setTitle("Navigation Drawer");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
