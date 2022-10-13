package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
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
        Label letters = new Label("Letters: ");
        Label words = new Label("Words: ");
        Label longest = new Label("The longest word is: ");
        TextArea textArea = new TextArea();
        HBox textLayout = new HBox();
        textLayout.setSpacing(10);
        textLayout.getChildren().add(letters);
        textLayout.getChildren().add(words);
        textLayout.getChildren().add(longest);
        
        layout.setCenter(textArea);
        layout.setBottom(textLayout);
        
        textArea.textProperty().addListener((change, oldValue, newValue)->{
            int chars = newValue.length();
            String[] parts = newValue.split(" ");
            int numWords = parts.length;
            String longestWord = Arrays.stream(parts).sorted((s1,s2)->s2.length()-s1.length()).findFirst().get();
        letters.setText("Letters: " + chars);
        words.setText("Words: "+ numWords);
        longest.setText("The longest word is: " + longestWord);
    });
        
        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
        
    }

}
