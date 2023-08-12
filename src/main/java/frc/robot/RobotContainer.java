// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.Drive;
import frc.robot.subsystems.AirCompressor;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Reportable.LOG_LEVEL;

public class RobotContainer {
  public Drivebase drivebase = new Drivebase();
  public AirCompressor airCompressor = new AirCompressor();
  
  public CommandPS4Controller driver = new CommandPS4Controller(OIConstants.kDriverPort);
  public CommandPS4Controller operator = new CommandPS4Controller(OIConstants.kOperatorPort);

  public RobotContainer() {
    configureBindings();
    initShuffleboard();
  }

  private void configureBindings() {
    drivebase.setDefaultCommand(new Drive(drivebase, () -> -driver.getHID().getLeftY(), () -> driver.getHID().getRightY()));

    driver.triangle().onTrue(Commands.runOnce(drivebase::toggleShift));
    driver.square().onTrue(Commands.runOnce(() -> drivebase.setShift(true)));
    driver.circle().onTrue(Commands.runOnce(() -> drivebase.setShift(false)));
  }

  public void initShuffleboard() {
    airCompressor.initShuffleboard(LOG_LEVEL.MEDIUM);
    drivebase.initShuffleboard(LOG_LEVEL.MEDIUM);
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
