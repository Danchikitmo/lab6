package managers.comparators;

import Data.LabWork;

import java.util.Comparator;

public class LabWorkComparator implements Comparator<LabWork> {
    @Override
    public int compare(LabWork o1, LabWork o2) {
        String passportID1 = o1.getAuthor().getPassportID();
        String passportID2 = o2.getAuthor().getPassportID();

        return passportID1.compareTo(passportID2);
    }
}
