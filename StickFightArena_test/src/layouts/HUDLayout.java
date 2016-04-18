package layouts;

/**
 * This pane contains whatever will be shown to the screen
 * when there's a specific event in the BACKGROUND like
 * a collision, game over, etc
 * Will be displayed at the same time as FOREGROUND
 * and BACKGROUND
 */

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/** HUD LAYOUT : class */
public class HUDLayout extends Pane {

    /** constructor */
    public HUDLayout(){

        Label text = new Label("\n\nI am in the HUD");

        this.getChildren().add(text);
    }
}
