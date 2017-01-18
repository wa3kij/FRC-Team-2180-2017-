// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2180.StrongHold;

import org.usfirst.frc2180.StrongHold.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc2180.StrongHold.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton brake1;
    public static Joystick left;
    public JoystickButton brake2;
    public static Joystick right;
    public JoystickButton open;
    public JoystickButton close;
    public Joystick payload;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        payload = new Joystick(2);
        
        close = new JoystickButton(payload, 1);
        close.whenPressed(new SolenoidClose());
        open = new JoystickButton(payload, 1);
        open.whenPressed(new SolenoidOpen());
        right = new Joystick(1);
        
        brake2 = new JoystickButton(right, 1);
        brake2.whileHeld(new Brake());
        left = new Joystick(0);
        
        brake1 = new JoystickButton(left, 1);
        brake1.whileHeld(new Brake());


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("DriveWithJoystick", new DriveWithJoystick());
        SmartDashboard.putData("Pick Up", new PickUp());
        SmartDashboard.putData("Launcher", new Launcher());
        SmartDashboard.putData("Climber", new Climber());
        SmartDashboard.putData("SolenoidOpen", new SolenoidOpen());
        SmartDashboard.putData("SolenoidClose", new SolenoidClose());
        SmartDashboard.putData("Brake", new Brake());
        SmartDashboard.putData("TurnLeft", new TurnLeft());
        SmartDashboard.putData("TurnRight", new TurnRight());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getLeft() {
        return left;
    }

    public Joystick getRight() {
        return right;
    }

    public Joystick getPayload() {
        return payload;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
