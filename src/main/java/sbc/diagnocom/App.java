package sbc.diagnocom;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {
    protected static final Stack<String> encadenamientos = new Stack<>();
    protected static final DiagnoComBR br = new DiagnoComBR();

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("cover"), 800, 500);
        stage.getIcons().add(new Image("https://cdn.pixabay.com/photo/2019/11/06/05/47/stethoscope-4605241_1280.png"));
        stage.setTitle("DiagnoCom");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    static void setRoot(String fxml, int width, int height, String title) throws IOException {
        scene.setRoot(loadFXML(fxml));
        scene.getWindow().setHeight(height);
        scene.getWindow().setWidth(width);
        Stage s = (Stage) scene.getWindow();
        s.setTitle(title);
        
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}