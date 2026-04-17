import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        System.out.println("Factory Robot Hazard Analyzer");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Arm Precision (0.0 - 1.0): ");
        double armPrecision = sc.nextDouble();

        System.out.print("Enter Worker Density (1 - 20): ");
        int workerDensity = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Machinery State (Worn/Faulty/Critical): ");
        String machineryState = sc.nextLine();

        // UC4 → validation

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            System.out.println("Error: Arm precision must be 0.0-1.0");
        }
        else if (workerDensity < 1 || workerDensity > 20) {
            System.out.println("Error: Worker density must be 1-20");
        }
        else if (!machineryState.equals("Worn") &&
                !machineryState.equals("Faulty") &&
                !machineryState.equals("Critical")) {
            System.out.println("Error: Unsupported machinery state");
        }
        else {
            // UC3 logic inside valid block

            double machineFactor = 0;

            if (machineryState.equals("Worn"))
                machineFactor = 1.3;
            else if (machineryState.equals("Faulty"))
                machineFactor = 2.0;
            else if (machineryState.equals("Critical"))
                machineFactor = 3.0;

            double hazardRisk = ((1 - armPrecision) * 15) + (workerDensity * machineFactor);

            System.out.println("Robot Hazard Risk Score: " + hazardRisk);
        }

        sc.close();
    }
}