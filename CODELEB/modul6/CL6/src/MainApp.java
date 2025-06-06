import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        TebakAngkaView view = new TebakAngkaView();
        Scene scene = new Scene(view.getView(), 300, 200);

        primaryStage.setTitle("Game Tebak Angka");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
