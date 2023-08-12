package frc.robot;

public class Constants {
    public class OIConstants {
        public static final int kDriverPort = 0;
        public static final int kOperatorPort = 1;
    }

    public class DriveConstants {
        public static final int leftMasterID = 11;
        public static final int leftFollowerID = 12;
        public static final int leftFollower2ID = 13;
        public static final int rightMasterID = 21;
        public static final int rightFollowerID = 22;
        public static final int rightFollower2ID = 23;

        public static final int kSolenoidForwardID = 0;
        public static final int kSolenoidReverseID = 1;
        public static final int kSolenoidForwardID2 = 2;
        public static final int kSolenoidReverseID2 = 3;

        public static final boolean leftMasterInverted = true;
        public static final boolean rightMasterInverted = true;
    }

    public class PneumaticsConstants {
        public static final int kPCMPort = 0; // 0 for CTRE from SensorUtil.getDefaultCTREPCMModule();
        public static final int kPressureSensorPort = 3;

    }
}
