package wangxiz;

import com.jfoenix.controls.JFXDecorator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import wangxiz.control.FXMLDocumentController;

import java.io.FileInputStream;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        String fxmlDocPath = "src/main/java/wangxiz/view/FXMLDocument.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
        Parent root = loader.load(fxmlStream);

//        JFXDecorator decorator = new JFXDecorator(stage, root);
//        decorator.setCustomMaximize(true);
//        Scene scene = new Scene(decorator);

        Scene scene = new Scene(root);

        FXMLDocumentController controller = loader.getController();
        controller.setPrimaryState(stage);

        stage.setTitle("Navigation Drawer");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
