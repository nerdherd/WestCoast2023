package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;

public class Drive extends CommandBase {
    private Drivebase drivebase;
    private DoubleSupplier leftStick;
    private DoubleSupplier rightStick;

    public Drive(Drivebase drivebase, DoubleSupplier leftSupplier, DoubleSupplier rightSupplier) {
        this.drivebase = drivebase;
        this.leftStick = leftSupplier;
        this.rightStick = rightSupplier;
        addRequirements(drivebase);
        
    }

    @Override
    public void execute() {
        drivebase.drive(leftStick.getAsDouble(), rightStick.getAsDouble());
    } 
}
