public class RobotHazardAuditor {

    public double calculateHazardRisk(double armPrecision, int workerDensity, String machineryState)
            throws RobotSafetyException {

        validateInputs(armPrecision, workerDensity, machineryState);

        double factor = getMachineRiskFactor(machineryState);

        return ((1 - armPrecision) * 15) + (workerDensity * factor);
    }

    // UC8 → separate validation
    private void validateInputs(double armPrecision, int workerDensity, String state)
            throws RobotSafetyException {

        if (armPrecision < 0.0 || armPrecision > 1.0)
            throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");

        if (workerDensity < 1 || workerDensity > 20)
            throw new RobotSafetyException("Error: Worker density must be 1-20");

        if (!state.equals("Worn") &&
                !state.equals("Faulty") &&
                !state.equals("Critical"))
            throw new RobotSafetyException("Error: Unsupported machinery state");
    }

    // UC8 → mapping method
    private double getMachineRiskFactor(String state) {

        switch (state) {
            case "Worn": return 1.3;
            case "Faulty": return 2.0;
            case "Critical": return 3.0;
        }

        return 0; // unreachable (validated before)
    }
}