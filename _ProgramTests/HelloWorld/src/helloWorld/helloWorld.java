package helloWorld;

/**
 * Created by auntfox on 13.03.2016.
 *
 * JavaFX : using JBox2D
 *
 * from :
 * http://thisiswhatiknowabout.blogspot.ch/2011/12/jbox2d-tutorial-creating-object-body.html
 *
 */

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.*;


public class helloWorld {

    /**
     * @param args
     */
    public static void main(String[] args){

        /** WORLD */
        ///gravity
        Vec2 gravity = new Vec2(0.0f, -10.0f);
        ///world
        World world = new World(gravity);

        /** BODY */
        BodyDef bd = new BodyDef();
        bd.position.set(50,50);
        bd.type = BodyType.DYNAMIC;
            ///can be static, dynamic or kinematic
                ///move under simulation
                ///respond to the force + move accordingly
                ///can be moved manually
                ///ALWAYS non-zero mass -> if 0 => 1kg mass
                ///collides with all types of body
                ///example : ball, box
        /** BODY SHAPE */
        ///polygon shape
        //PolygonShape dynamicBox = new PolygonShape();
        //dynamicBox.setAsBox(1.0f,1.0f);
        ///circle shape
        CircleShape cs = new CircleShape();
        cs.m_radius = 0.5f;
        /** FIXTURE OF THE BODY */
        FixtureDef fd = new FixtureDef();
        fd.shape = cs;
        fd.density = 0.5f;
        fd.friction = 0.3f;
        fd.restitution = 0.5f;

        /** CREATE BODY + ADD FIXTURE TO IT */
        Body body = world.createBody(bd);
        body.createFixture(fd);

        /****************
         *  SIMULATION  *
         ****************/

        ///defines how much simulation should advance in one second
        //// -> 60Hz
        float timeStep = 1.0f / 60.f;
        ///defines how accurately velocity is simulated
        ////high value : accurate velocity / decreases performance
        ////recommended : 6
        int velocityIterations = 6;
        ///similar to velocity
        ////high value : more accurate position / decreases performance
        ////recommended : 3
        int positionIterations = 2;

        for(int i = 0; i < 60; ++i){

            world.step(timeStep, velocityIterations, positionIterations);
            Vec2 position = body.getPosition();
            float angle = body.getAngle();
            System.out.printf("%4.2f %4.2f %4.2f\n", position.x, position.y, angle);
        }

    }

}
