// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.open;
import frc.robot.commands.spin;

import frc.robot.commands.close;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Claw;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
 // private Claw o;
// The robot's subsystems and commands are defined here...
  Arm arm = new Arm();
  Claw claw = new Claw();
    open open = new open(claw);
    close close = new close(claw);
  XboxController controller = new XboxController(0);
    final JoystickButton openButton = new JoystickButton(controller, 1); //A
    final JoystickButton closeButton = new JoystickButton(controller, 2); //B
  
  spin spin = new spin(arm, controller);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    // openButton.whileHeld(open);
    // closeButton.whileHeld(close);

     arm.setDefaultCommand(spin);

  }
  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return open;
  }
}
