import Layouts.BackgroundLayout;
import Layouts.IGameLayout;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

/**
 * Created by auntfox on 17.04.2016.
 */
public class Game {

    StackPane layouts;

    public Game() {

        layouts = new StackPane();

        layouts.getChildren().add(new BackgroundLayout());
    }

    public static void main(String[] args){


    }

}
