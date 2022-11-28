// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Claw;

public class close extends CommandBase {
  /** Creates a new open. */
  Claw openMotor;
  
  public close(Claw o  ) {
    // Use addRequirements() here to declare subsystem dependencies.
    openMotor = o;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(openMotor.isOpen()== true){
      openMotor.open(-0.2);
    }else{
      openMotor.open(0);
    }
      
   
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    openMotor.open(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;

  }
}
