package layouts;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * This pane contains whatever will be taking place
 * in the BAKCGROUND : static scenery
 * Will be displayed at the same time as FOREGROUND
 * and HUD
 */

/** BACKGROUND LAYOUT : class */
public class BackgroundLayout extends Pane {


    /** constructor */
    public BackgroundLayout(){

        Label text = new Label("I am in the Background");

        this.getChildren().add(text);

    }
}
