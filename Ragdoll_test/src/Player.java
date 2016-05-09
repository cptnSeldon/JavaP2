import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.dynamics.World;
import org.dyn4j.dynamics.joint.RevoluteJoint;
import org.dyn4j.geometry.Convex;
import org.dyn4j.geometry.Geometry;
import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Vector2;

public class Player {
    //Stickman

    double rHead = 0.35;
    double rHand = 0.2;

    double hTrunk = 2.5;
    double wTrunk = 0.25;

    double hMember = 0.15;
    double wMember = 1.5;

    double stickman1x = 1;
    double stickman1y = 0;

    World world;

    Body trunk;

    public static int keyStatments;

    public Player(double stickman1x, double stickman1y, World world) {
        this.stickman1x = stickman1x;
        this.stickman1y = stickman1y;
        this.world = world;

        // Head
        Body head = new SimulationBody();
        Convex c = Geometry.createCircle(rHead);
        BodyFixture bf = new BodyFixture(c);
        head.addFixture(bf);
        head.setMass(MassType.NORMAL);
        head.translate(stickman1x+0, stickman1y+hTrunk/2+rHead);
        world.addBody(head);

        trunk = new SimulationBody();
        c = Geometry.createRectangle(wTrunk, hTrunk);
        bf = new BodyFixture(c);
        trunk.addFixture(bf);
        trunk.setMass(MassType.NORMAL);
        trunk.translate(stickman1x, stickman1y);
        world.addBody(trunk);


        //left Arm
        Body leftArm = new SimulationBody();
        c = Geometry.createRectangle(wMember, hMember);
        bf = new BodyFixture(c);
        leftArm.addFixture(bf);
        leftArm.setMass(MassType.NORMAL);
        leftArm.translate(new Vector2(stickman1x-wTrunk/2-wMember/2, stickman1y+hTrunk/2*0.75));
        world.addBody(leftArm);


        //right Arm
        Body rightArm = new SimulationBody();
        c = Geometry.createRectangle(wMember, hMember);
        bf = new BodyFixture(c);
        rightArm.addFixture(bf);
        rightArm.setMass(MassType.NORMAL);
        rightArm.translate(new Vector2(stickman1x+wTrunk/2+wMember/2, stickman1y+hTrunk/2*0.75));
        world.addBody(rightArm);


        Body rightHand = new SimulationBody();
        c = Geometry.createCircle(rHand);
        bf = new BodyFixture(c);
        rightHand.addFixture(bf);
        rightHand.setMass(MassType.NORMAL);
        rightHand.translate(new Vector2(stickman1x+wTrunk/2+wMember, stickman1y+hTrunk/2*0.75));
        world.addBody(rightHand);

        RevoluteJoint rightArmRightHand = new RevoluteJoint(rightArm, rightHand, new Vector2(stickman1x+wTrunk/2+wMember, stickman1y+hTrunk/2*0.75));
        world.addJoint(rightArmRightHand);

        Body leftHand = new SimulationBody();
        c = Geometry.createCircle(rHand);
        bf = new BodyFixture(c);
        leftHand.addFixture(bf);
        leftHand.setMass(MassType.NORMAL);
        leftHand.translate(new Vector2(stickman1x-wTrunk/2-wMember, stickman1y+hTrunk/2*0.75));
        world.addBody(leftHand);

        RevoluteJoint leftHandLeftArm = new RevoluteJoint(leftArm, leftHand, new Vector2(stickman1x-wTrunk/2-wMember, stickman1y+hTrunk/2*0.75));
        world.addJoint(leftHandLeftArm);



        Body leftLeg = new SimulationBody();
        c = Geometry.createRectangle(wMember, hMember);
        bf = new BodyFixture(c);
        leftLeg.addFixture(bf);
        leftLeg.setMass(MassType.NORMAL);
        leftLeg.translate(new Vector2(stickman1x-wTrunk/2-wMember/2, stickman1y-hTrunk/2));
        world.addBody(leftLeg);

        Body leftFoot = new SimulationBody();
        c = Geometry.createCircle(rHand);
        bf = new BodyFixture(c);
        leftFoot.addFixture(bf);
        leftFoot.setMass(MassType.NORMAL);
        leftFoot.translate(new Vector2(stickman1x-wTrunk/2-wMember, stickman1y-hTrunk/2));
        world.addBody(leftFoot);

        RevoluteJoint leftFootLeftLeg = new RevoluteJoint(leftLeg, leftFoot, new Vector2(stickman1x-wTrunk/2-wMember, stickman1y-hTrunk/2));
        world.addJoint(leftFootLeftLeg);


        Body rightLeg = new SimulationBody();
        c = Geometry.createRectangle(wMember, hMember);
        bf = new BodyFixture(c);
        rightLeg.addFixture(bf);
        rightLeg.setMass(MassType.NORMAL);
        rightLeg.translate(new Vector2(stickman1x+wTrunk/2+wMember/2, stickman1y-hTrunk/2));
        world.addBody(rightLeg);

        Body rightFoot = new SimulationBody();
        c = Geometry.createCircle(rHand);
        bf = new BodyFixture(c);
        rightFoot.addFixture(bf);
        rightFoot.setMass(MassType.NORMAL);
        rightFoot.translate(new Vector2(stickman1x+wTrunk/2+wMember, stickman1y-hTrunk/2));
        world.addBody(rightFoot);

        RevoluteJoint rightFootRightLeg = new RevoluteJoint(rightLeg, rightFoot, new Vector2(stickman1x+wTrunk/2+wMember, stickman1y-hTrunk/2));
        world.addJoint(rightFootRightLeg);




        //trunk - head joint

        RevoluteJoint trunkHead = new RevoluteJoint(trunk, head, new Vector2(stickman1x+0,stickman1y+hTrunk/2));
        trunkHead.setLimitEnabled(true);
        trunkHead.setLimits(Math.toRadians(-45.0), Math.toRadians(45.0));
        //trunkHead.setReferenceAngle(Math.toRadians(0.0));
        trunkHead.setMotorEnabled(false);
        trunkHead.setMotorSpeed(Math.toRadians(0.0));
        trunkHead.setMaximumMotorTorque(0.0);
        trunkHead.setCollisionAllowed(false);
        world.addJoint(trunkHead);

        RevoluteJoint trunkLeftArm = new RevoluteJoint(trunk, leftArm, new Vector2(stickman1x-wTrunk/2, stickman1y+hTrunk/2*0.75));
        trunkLeftArm.setLimitEnabled(true);
        trunkLeftArm.setLimits(Math.toRadians(-45.0), Math.toRadians(45.0));
        //trunkHead.setReferenceAngle(Math.toRadians(0.0));
        trunkLeftArm.setMotorEnabled(false);
        trunkLeftArm.setMotorSpeed(Math.toRadians(0.0));
        trunkLeftArm.setMaximumMotorTorque(0.0);
        trunkLeftArm.setCollisionAllowed(false);
        world.addJoint(trunkLeftArm);

        RevoluteJoint trunkRightArm = new RevoluteJoint(trunk, rightArm, new Vector2(stickman1x+wTrunk/2, stickman1y+hTrunk/2*0.75));
        trunkRightArm.setLimitEnabled(true);
        trunkRightArm.setLimits(Math.toRadians(-45.0), Math.toRadians(45.0));
        //trunkRightArm.setReferenceAngle(Math.toRadians(0.0));
        trunkRightArm.setMotorEnabled(false);
        trunkRightArm.setMotorSpeed(Math.toRadians(0.0));
        trunkRightArm.setMaximumMotorTorque(0.0);
        trunkRightArm.setCollisionAllowed(false);
        world.addJoint(trunkRightArm);

        RevoluteJoint trunkLeftLeg = new RevoluteJoint(trunk, leftLeg, new Vector2(stickman1x-wTrunk/2, stickman1y-hTrunk/2));
        trunkLeftLeg.setLimitEnabled(true);
        trunkLeftLeg.setLimits(Math.toRadians(-30.0), Math.toRadians(45.0));
        trunkLeftLeg.setReferenceAngle(Math.toRadians(-45.0));
        trunkLeftLeg.setMotorEnabled(false);
        trunkLeftLeg.setMotorSpeed(Math.toRadians(0.0));
        trunkLeftLeg.setMaximumMotorTorque(0.0);
        trunkLeftLeg.setCollisionAllowed(false);
        world.addJoint(trunkLeftLeg);

        RevoluteJoint trunkRightLeg = new RevoluteJoint(trunk, rightLeg, new Vector2(stickman1x+wTrunk/2, stickman1y-hTrunk/2));
        trunkRightLeg.setLimitEnabled(true);
        trunkRightLeg.setLimits(Math.toRadians(-30.0), Math.toRadians(45.0));
        trunkRightLeg.setReferenceAngle(Math.toRadians(45.0));
        trunkRightLeg.setMotorEnabled(false);
        trunkRightLeg.setMotorSpeed(Math.toRadians(0.0));
        trunkRightLeg.setMaximumMotorTorque(0.0);
        trunkRightLeg.setCollisionAllowed(false);
        world.addJoint(trunkRightLeg);
    }

    Body getGravityCenter(){
        return trunk;
    }


}
