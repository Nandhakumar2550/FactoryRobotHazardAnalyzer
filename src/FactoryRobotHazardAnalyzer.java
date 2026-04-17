import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        System.out.println("Factory Robot Hazard Analyzer");

        Scanner sc = new Scanner(System.in);

        // UC2 → input
        System.out.print("Enter Arm Precision (0.0 - 1.0): ");
        double armPrecision = sc.nextDouble();

        System.out.print("Enter Worker Density (1 - 20): ");
        int workerDensity = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Machinery State (Worn/Faulty/Critical): ");
        String machineryState = sc.nextLine();

        // UC3 → calculation

        double machineFactor = 0;

        if (machineryState.equals("Worn"))
            machineFactor = 1.3;
        else if (machineryState.equals("Faulty"))
            machineFactor = 2.0;
        else if (machineryState.equals("Critical"))
            machineFactor = 3.0;

        double hazardRisk = ((1 - armPrecision) * 15) + (workerDensity * machineFactor);

        System.out.println("Robot Hazard Risk Score: " + hazardRisk);

        sc.close();
    }
}