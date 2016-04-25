package Layouts;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * Created by auntfox on 17.04.2016.
 */
public class HUDLayout extends Pane {


    public HUDLayout() {

        Label text = new Label("HUD");

        this.getChildren().add(text);

    }
}
