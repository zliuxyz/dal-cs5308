import java.util.ArrayList;

public class Employer {
    ArrayList<IWorker> workers;

    public Employer() {
        workers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            workers.add(new HourlyWorker());
        }
        for (int i = 0; i < 5; i++) {
            workers.add(new SalaryWorker());
        }
    }

    public void outputWageCostsForAllStaff(int hours) {
        float cost = 0.0f;
        for (int i = 0; i < workers.size(); i++) {
            cost += workers.get(i).calculatePay(hours);
        }
        System.out.println("Total wage cost for all staff = $" + cost);
    }
}