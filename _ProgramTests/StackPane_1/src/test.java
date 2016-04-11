import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by auntfox on 11.04.2016.
 * http://www.javafxapps.in/tutorial/StackPane-Example.html
 */
public class test extends Application{

    ///MAIN
    public static void main(String[] args){
        launch(args);
    }

    ///START
    @Override
    public void start(Stage primaryStage) throws Exception {

        ///stage title
        primaryStage.setTitle("Hello World");

        ///button
        Button button = new Button();
        button.setText("Say 'Hello World'");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World");
            }
        });

        //stackpane
        StackPane root = new StackPane();

        root.getChildren().add(button);
        primaryStage.setScene(new Scene(root, 300,250));

        primaryStage.show();
    }
}
