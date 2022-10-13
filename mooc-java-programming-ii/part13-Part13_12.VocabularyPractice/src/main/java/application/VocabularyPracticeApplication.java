package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


// END SOLUTION
public class VocabularyPracticeApplication extends Application{
    private Dictionary dictionary;
    
    @Override
    public void start(Stage stage) {
        PracticeView practiceView = new PracticeView(dictionary);
        InputView inputView = new InputView(dictionary);
        
        BorderPane layout = new BorderPane();
        
        HBox menu = new HBox();
        menu.setPadding(new Insets(20,20,20,20));
        menu.setSpacing(10);
        
        Button enterBtn = new Button("Enter new words");
        Button practiceBtn = new Button("Practice");
        
        menu.getChildren().addAll(enterBtn, practiceBtn);
        layout.setTop(menu);
        
        enterBtn.setOnAction((event)-> layout.setCenter(inputView.getView()));
        practiceBtn.setOnAction((event)->layout.setCenter(practiceView.getView()));
        
        layout.setCenter(inputView.getView());
        
        Scene view = new Scene(layout, 400,300);
        
        stage.setScene(view);
        stage.show();
        
        
    }

    public static void main(String[] args) {
    }
}
