import java.io.*;
import java.util.Scanner;

public class PiggyBank {
    int numPennies;
    int numDimes;
    int numNickels;
    int numQuarters;

    public PiggyBank() {
        numPennies = 0;
        numDimes = 0;
        numNickels = 0;
        numQuarters = 0;
    }

    public void addPenny() {
        numPennies += 1;
    }

    public void addDime() {
        numDimes += 1;
    }

    public void addNickel() {
        numNickels += 1;
    }

    public void addQuarter() {
        numQuarters += 1;
    }
}