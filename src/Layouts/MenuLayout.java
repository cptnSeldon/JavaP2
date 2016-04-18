package Layouts;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * Created by auntfox on 17.04.2016.
 */
public class MenuLayout extends Pane {


    public MenuLayout() {

        Button button = new Button("Menu button");

        this.getChildren().add(button);
    }
}
