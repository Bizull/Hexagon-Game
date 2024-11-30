package org.example.projectdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GameModel extends Application {
    static class ButtonHandler implements EventHandler<ActionEvent> {
        private Stage stage;

        public ButtonHandler(Stage stage) {
            this.stage = stage;
        }

        @Override
        public void handle(ActionEvent event) {
            try {
                new SelectBoard().start(new Stage());
                stage.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    @Override
    public void start(Stage stage) throws Exception {
        EntryScreen entryScreen = new EntryScreen();
        entryScreen.start(new Stage());
        Button btn1 = entryScreen.btn1;
        btn1.setOnAction(new ButtonHandler(stage));

        if (entryScreen.isButtonClicked()) {
            stage.close();
        }
    }
}
