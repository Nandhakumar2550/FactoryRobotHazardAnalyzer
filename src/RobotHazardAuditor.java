public class RobotHazardAuditor {

    // UC6 → throws exception
    public double calculateHazardRisk(double armPrecision, int workerDensity, String machineryState)
            throws RobotSafetyException {

        // validation → throw exception

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
        }

        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException("Error: Worker density must be 1-20");
        }

        if (!machineryState.equals("Worn") &&
                !machineryState.equals("Faulty") &&
                !machineryState.equals("Critical")) {
            throw new RobotSafetyException("Error: Unsupported machinery state");
        }

        // mapping
        double factor = 0;

        if (machineryState.equals("Worn"))
            factor = 1.3;
        else if (machineryState.equals("Faulty"))
            factor = 2.0;
        else if (machineryState.equals("Critical"))
            factor = 3.0;

        // calculation
        return ((1 - armPrecision) * 15) + (workerDensity * factor);
    }
}