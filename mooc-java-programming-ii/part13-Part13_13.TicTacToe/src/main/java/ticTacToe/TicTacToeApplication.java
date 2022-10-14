package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class TicTacToeApplication extends Application {


    @Override 
    public void start(Stage window){
        BorderPane layout = new BorderPane();
        Label instructions = new Label();
        instructions.setFont(Font.font("Monospaced", 40));
        
        //set up the grid
        GridPane gameGrid = new GridPane();
        gameGrid.setVgap(10);
        gameGrid.setHgap(10);
        gameGrid.setPadding(new Insets(20,20,20,20));
        
        Turn turn = new Turn();
        
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j++){
                Button btns = new Button();
                gameGrid.add(btns, i, j);
            }
        }
        
        instructions.setText("Turn: " + turn.getTurn());
        
        layout.setTop(instructions);
        layout.setCenter(gameGrid);
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }
    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}
