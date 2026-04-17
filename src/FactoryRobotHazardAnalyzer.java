import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        System.out.println("Factory Robot Hazard Analyzer");

        Scanner sc = new Scanner(System.in);

        try {
            // input
            System.out.print("Enter Arm Precision (0.0 - 1.0): ");
            double armPrecision = sc.nextDouble();

            System.out.print("Enter Worker Density (1 - 20): ");
            int workerDensity = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Machinery State (Worn/Faulty/Critical): ");
            String machineryState = sc.nextLine();

            // call method
            RobotHazardAuditor auditor = new RobotHazardAuditor();

            double risk = auditor.calculateHazardRisk(
                    armPrecision, workerDensity, machineryState);

            System.out.println("Robot Hazard Risk Score: " + risk);

        } catch (RobotSafetyException e) {
            // UC6 → handle exception
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}