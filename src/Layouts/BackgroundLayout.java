package Layouts;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by auntfox on 17.04.2016.
 */
public class BackgroundLayout extends Pane{

    public BackgroundLayout(){

        Rectangle rect = new Rectangle(500.,500.);
        rect.setFill(Color.GREEN);

        this.getChildren().add(rect);

    }

}
