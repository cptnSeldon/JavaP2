import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
    //represents game's gameLayouts (Menu, BG, FG, HUD)
    StackPane gameLayouts;
    StackPane menuLayouts;
    //represents scenes : menu + in game states
    Scene menuScene;
    Scene inGameScene;
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
        menuLayouts = new StackPane();
        gameLayouts = new StackPane();
        //initialize scenes
        menuScene = new Scene(menuLayouts);
        inGameScene = new Scene(gameLayouts);
        //set default scene
        //window.setScene(menuScene);
        window.setScene(inGameScene);

        /** SETTINGS */
        //new gameLayouts in its specific stackpane :
        //      BG, FG, HUD
        gameLayouts.getChildren().add(new BackgroundLayout());
        gameLayouts.getChildren().add(new ForegroundLayout());
        gameLayouts.getChildren().add(new HUDLayout());
        //new menuLayout in its specific stackpane
        menuLayouts.getChildren().add(new MenuLayout());

        /** show window */
        window.show();
    }

    /** APPLICATION LAUNCHING */
    public static void main(String[] args){

        launch(args);
    }

}
