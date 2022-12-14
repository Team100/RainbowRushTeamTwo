// Copyright (c) FIRST and other WPILib contributors.
// spin Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Claw;

public class spin extends CommandBase {
    /** Creates a new spin. */
    Arm arm;
    
    XboxController controller;

    public spin(Arm o, XboxController c) {
        // Use addRequirements() here to declare subsystem dependencies.
        arm = o;
        controller = c;
        //claw = u;

        addRequirements(arm);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        arm.spin(controller.getRightX());
        arm.driveHorizontal(controller.getLeftY());
        arm.driveVertical(controller.getRightY());
       // claw.move(controller.getButtonCount());
        // arm.driveVertical(-controller.getLeftTriggerAxis());

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {

    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;

    }
}
