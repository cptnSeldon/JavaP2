import Layouts.*;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import test.Ragdoll;


/**
 * Created by auntfox on 17.04.2016.
 */
public class Game extends Application{

    Stage window;
    StackPane layouts;
    Scene mainScene;

    ForegroundLayout foregroundLayout;

    public Game() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        layouts = new StackPane();

        mainScene = new Scene(layouts);
        window.setScene(mainScene);

        /** new layouts into stackpane */
        foregroundLayout = new ForegroundLayout();
        //SwingNode swingNode= new SwingNode();
        //foregroundLayout.getChildren().add(swingNode);
        layouts.getChildren().add(new BackgroundLayout());
        layouts.getChildren().add(foregroundLayout);
        layouts.getChildren().add(new HUDLayout());
        layouts.getChildren().add(new MenuLayout());

        //needs modifications
        //Ragdoll simulation = new Ragdoll();
        //swingNode.setContent(simulation);
        //simulation.run();
        window.show();

    }

    public static void main(String[] args){

        launch(args);

    }

}
