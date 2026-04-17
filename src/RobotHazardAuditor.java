public class RobotHazardAuditor {

    // UC5 → method for calculation + validation
    public double calculateHazardRisk(double armPrecision, int workerDensity, String machineryState) {

        // validation
        if (armPrecision < 0.0 || armPrecision > 1.0) {
            System.out.println("Error: Arm precision must be 0.0-1.0");
            return -1;
        }

        if (workerDensity < 1 || workerDensity > 20) {
            System.out.println("Error: Worker density must be 1-20");
            return -1;
        }

        if (!machineryState.equals("Worn") &&
                !machineryState.equals("Faulty") &&
                !machineryState.equals("Critical")) {
            System.out.println("Error: Unsupported machinery state");
            return -1;
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