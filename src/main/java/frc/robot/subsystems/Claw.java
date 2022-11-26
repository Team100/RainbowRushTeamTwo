// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.FRCLib.Motors.FRCTalonSRX;

public class Claw extends SubsystemBase {
  public FRCTalonSRX openMotor;
  public DigitalInput stopButton;

  // Creates a new Claw.
  public Claw() {
    openMotor = new FRCTalonSRX.FRCTalonSRXBuilder(5)
        .withInverted(false)
        .withFeedbackPort(0)
        .withTimeout(10)
        .withCurrentLimitEnabled(false)
        .withCurrentLimit(80)
        .withOpenLoopRampRate(0.0)
        .withPeakOutputForward(1.0)
        .withPeakOutputReverse(-1.0)
        // .withNeutralMode(com.revrobotics.CANSparkMax.IdleMode.kBrake)
        .build();
    addChild("ClawopenMotor", openMotor);
    stopButton = new DigitalInput(3);
    addChild("ClawstopButton", stopButton);
  }

  public void open(double x) {
    openMotor.drivePercentOutput(x);
  }

  public boolean isOpen() {
    return stopButton.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}