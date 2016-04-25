package Layouts;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by auntfox on 17.04.2016.
 */
public class ForegroundLayout extends Pane {


    public ForegroundLayout() {

        Circle circ = new Circle(100., Color.RED);

        this.getChildren().add(circ);
    }
}
