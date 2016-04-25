import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import layouts.BackgroundLayout;
import layouts.ForegroundLayout;
import layouts.HUDLayout;
import layouts.MenuLayout;

/**
 * This is where the game will be initialized
 * Settings :
 *      Stage - window
 *      StackPane - gameLayouts
 *      Scene - displays Menu depending on state
 *      Scene - in game - displays BG, FG and HUD
 *
 *      GameLoop start
 */

/** GAME : class */
public class Game extends Application {

    /** attributes */
    //represents game window
    Stage window;
    //represents game's layouts (Menu, BG, FG, HUD)
    StackPane layouts;
    //represents scenes : menu + in game states
    Scene mainScene;
    //

    /** constructor */
    public Game(){

    }

    /** Application : start */
    @Override
    public void start(Stage primaryStage) throws Exception {

        /** INITIALIZATION */
        //easier to recall : primaryStage -> window
        window = primaryStage;
        //initialize layouts
        layouts = new StackPane();
        //initialize scenes
        mainScene = new Scene(layouts);
        //set default scene
        window.setScene(mainScene);

        /** SETTINGS */
        //set game layouts
        layouts.getChildren().add(new BackgroundLayout());
        layouts.getChildren().add(new ForegroundLayout());
        layouts.getChildren().add(new HUDLayout());
        //set menu layout
        layouts.getChildren().add(new MenuLayout());

        /** show window */
        window.show();
    }

    /** APPLICATION LAUNCHING */
    public static void main(String[] args){

        launch(args);
    }

}
