package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class Drivebase extends SubsystemBase {
    private TalonFX leftMaster;
    private TalonFX leftFollower;
    private TalonFX leftFollower2;
    private TalonFX rightMaster;
    private TalonFX rightFollower;
    private TalonFX rightFollower2;

    private DoubleSolenoid driveShifter;

    public Drivebase() {
        this.leftMaster = new TalonFX(DriveConstants.leftMasterID);
        this.leftFollower = new TalonFX(DriveConstants.leftFollowerID);
        this.leftFollower2 = new TalonFX(DriveConstants.leftFollower2ID);
        this.rightMaster = new TalonFX(DriveConstants.rightMasterID);
        this.rightFollower = new TalonFX(DriveConstants.rightFollowerID);
        this.rightFollower2 = new TalonFX(DriveConstants.rightFollower2ID);

        this.leftFollower.follow(leftMaster);
        this.leftFollower2.follow(leftMaster);
        this.rightFollower.follow(rightMaster);
        this.rightFollower2.follow(rightMaster);

        this.leftMaster.setInverted(DriveConstants.leftMasterInverted);
        this.leftFollower.setInverted(InvertType.FollowMaster);
        this.leftFollower2.setInverted(InvertType.FollowMaster);
        this.rightMaster.setInverted(DriveConstants.rightMasterInverted);
        this.rightFollower.setInverted(InvertType.FollowMaster);
        this.rightFollower2.setInverted(InvertType.FollowMaster);

        this.driveShifter = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, DriveConstants.kSolenoidForwardID, DriveConstants.kSolenoidReverseID);
    }

    public void drive(double leftVelocity, double rightVelocity) {
        this.leftMaster.set(ControlMode.PercentOutput, leftVelocity);
        this.rightMaster.set(ControlMode.PercentOutput, rightVelocity);
    }

    public void toggleShift() {
        this.driveShifter.toggle();
    }

    public void setShift(boolean shift) {
        if (shift) {
            this.driveShifter.set(Value.kForward);
        } else {
            this.driveShifter.set(Value.kReverse);
        }
    }


}
