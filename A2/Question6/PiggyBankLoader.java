public class PiggyBankLoader {
    int numPennies;
    int numDimes;
    int numNickels;
    int numQuarters;

    public void load() {
        try {
            Scanner in = new Scanner(new FileReader("piggybank.txt"));
            numPennies = Integer.parseInt(in.next());
            numDimes = Integer.parseInt(in.next());
            numNickels = Integer.parseInt(in.next());
            numQuarters = Integer.parseInt(in.next());
        } catch (Exception e) {
            System.out.println("I am a bad programmer that hid an exception.");
        }
    }

    public int getNumPennies() {
        return numPennies;
    }

    public int getNumDimes() {
        return numDimes;
    }

    public int getNumNickels() {
        return numNickels;
    }

    public int getNumQuarters() {
        return numQuarters;
    }
}