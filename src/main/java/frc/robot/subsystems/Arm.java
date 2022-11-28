// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.FRCLib.Motors.FRCTalonFX;

public class Arm extends SubsystemBase {
  public FRCTalonFX verticalMotor;
  public FRCTalonFX horizontalMotor;
  public FRCTalonFX spinMotor;

  /** Creates a new Arm. */
  public Arm() {
    verticalMotor = new FRCTalonFX.FRCTalonFXBuilder(3)
        // .withInverted(false)
        .withFeedbackPort(0)
        .withSensorPhase(false)
        .withTimeout(10)
        .withCurrentLimitEnabled(false)
        .withCurrentLimit(80)
        .withOpenLoopRampRate(0.0)
        .withPeakOutputForward(0.1)
        .withPeakOutputReverse(-0.1)
        // .withNeutralMode()
        .build();
    horizontalMotor = new FRCTalonFX.FRCTalonFXBuilder(7)
        // .withInverted(false)
        .withFeedbackPort(0)
        .withSensorPhase(false)
        .withTimeout(10)
        .withCurrentLimitEnabled(true)
        .withCurrentLimit(10)
        .withOpenLoopRampRate(0.0)
        .withPeakOutputForward(0.1)
        .withPeakOutputReverse(-0.1)
        // .withNeutralMode()
        .build();
    spinMotor = new FRCTalonFX.FRCTalonFXBuilder(4)
        // .withInverted(false)
        .withFeedbackPort(0)
        .withSensorPhase(false)
        .withTimeout(10)
        .withCurrentLimitEnabled(true)
        .withCurrentLimit(10)
        .withOpenLoopRampRate(0.0)
        .withPeakOutputForward(0.1)
        .withPeakOutputReverse(-0.1)
        // .withNeutralMode()
        .build();
    addChild("ArmVerticalMotor", verticalMotor);
    addChild("ArmHorizontalMotor", horizontalMotor);
    addChild("ArmSpinMotor", spinMotor);
  }

  public void spin(double x) {
    spinMotor.drivePercentOutput(x);
  }

  public void driveVertical(double x) {
    verticalMotor.drivePercentOutput(x);
  }

  public void driveHorizontal(double x) {
    horizontalMotor.drivePercentOutput(x);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
