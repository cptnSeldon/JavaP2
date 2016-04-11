import javafx.animation.RotateTransition;
import javafx.animation.RotateTransitionBuilder;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by auntfox on 11.04.2016.
 * http://www.javafxapps.in/tutorial/StackPane-Example.html
 */
public class test2 extends Application{

    public static void main(String[] args){

        launch(args);
    }

    ///ATTRIBUTES
    int i = 0;
    private RotateTransition rotateTransition;

    ///OVERWRITTEN METHOD : START
    @Override
    public void start(Stage primaryStage) throws Exception {

        //rootPane : declaration
        final StackPane rootPane = new StackPane();

        //scene : declaration + instantiation
        Scene scene = new Scene(rootPane, 600, 600);
        scene.setFill(Color.CORNFLOWERBLUE);

        //task creation : generating new rectangles
        //after window is opened
        Task t = new Task(){

            //OVERWRITTEN METHOD : CALL -> TASK
            @Override
            protected Object call() throws Exception {

                //storing colors for every new rectangle
                final Color a[] = {
                        Color.BLUEVIOLET, Color.AQUA,
                        Color.BROWN, Color.CRIMSON,
                        Color.BURLYWOOD, Color.CADETBLUE,
                        Color.CHARTREUSE, Color.DARKGOLDENROD,
                        Color.DARKSLATEGREY, Color.STEELBLUE,
                        Color.ORANGERED, Color.GOLD,
                        Color.LIGHTSKYBLUE
                };

                //adding new Rectangles as Children
                for(i = 0; i < a.length; i++){

                    //anon runnable
                    Platform.runLater(new Runnable(){
                        @Override
                        public void run(){

                            //effective adding
                            rootPane.getChildren().add(new Rectangle(600 - (i*50), 600-(i*50), a[i]));
                        }
                    });
                    //gap between generating new rectangles
                    Thread.sleep(500);
                }

                //rotating the entire root element using rotate transition
                rotateTransition = RotateTransitionBuilder.create().node(rootPane)
                        .duration(Duration.seconds(6)).fromAngle(0).toAngle(360)
                        .cycleCount(Timeline.INDEFINITE).autoReverse(true).build();

                rotateTransition.play();

                return null;
            }
        };
        //insert new task t in a new thread and start it
        new Thread(t).start();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
