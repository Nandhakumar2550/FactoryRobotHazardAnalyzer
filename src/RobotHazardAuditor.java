public class RobotHazardAuditor {

    public double calculateHazardRisk(double armPrecision, int workerDensity, String machineryState)
            throws RobotSafetyException {

        // validation
        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
        }

        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException("Error: Worker density must be 1-20");
        }

        // UC7 → mapping using helper method
        double factor = getMachineRiskFactor(machineryState);

        // calculation
        return ((1 - armPrecision) * 15) + (workerDensity * factor);
    }

    // UC7 → separate mapping logic
    private double getMachineRiskFactor(String state) throws RobotSafetyException {

        switch (state) {

            case "Worn":
                return 1.3;

            case "Faulty":
                return 2.0;

            case "Critical":
                return 3.0;

            default:
                throw new RobotSafetyException("Error: Unsupported machinery state");
        }
    }
}