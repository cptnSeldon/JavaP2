package layouts;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * This pane contains whatever will be taking place
 * in the FOREGROUND : dynamic scenery + ragdolls
 * Will be displayed at the same time as BACKGROUND
 * and HUD
 */

/** FOREGROUND LAYOUT : class */
public class ForegroundLayout extends Pane {

    /** constructor */
    public ForegroundLayout(){

        Label text = new Label("\nI am in the Foreground");

        this.getChildren().add(text);
    }

}
