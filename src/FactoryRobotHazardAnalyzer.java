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

        // UC5 → use separate class
        RobotHazardAuditor auditor = new RobotHazardAuditor();

        double risk = auditor.calculateHazardRisk(armPrecision, workerDensity, machineryState);

        if (risk != -1)
            System.out.println("Robot Hazard Risk Score: " + risk);

        sc.close();
    }
}