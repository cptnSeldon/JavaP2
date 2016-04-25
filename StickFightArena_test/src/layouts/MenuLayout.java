package layouts;

/**
 * This pane contains all the MENU items
 * Will be displayed when :
 *      Application begins
 *      Game is paused
 *      Game is over
 * Contains these Panes:
 *      INIT
 *      ABOUT
 *      IN GAME
 *      PAUSE
 *      GAME OVER
 */

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/** MENU LAYOUT : class */
public class MenuLayout extends BorderPane{

    //   BorderPane :
    //      top
    // left center right
    //     bottom
    /** attributes */
    //border pane
    BorderPane root;
    //hbox
    HBox logo;
    //vboxes
    VBox center;
    VBox bottom;
    /** constructor */
    public MenuLayout(){

    }
}
