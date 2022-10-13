package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TextStatisticsApplication extends Application {


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        BorderPane layout = new BorderPane();
        HBox textLayout = new HBox();
        textLayout.setSpacing(10);
        textLayout.getChildren().add(new Label("Letters: 0"));
        textLayout.getChildren().add(new Label("Words: 0"));
        textLayout.getChildren().add(new Label("The longest word is:"));
        
        layout.setCenter(new TextArea(""));
        layout.setBottom(textLayout);
        
        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
        
    }

}
