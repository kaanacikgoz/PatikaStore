import java.util.Comparator;

public class PhoneIdComparator implements Comparator<Phone> {
    @Override
    public int compare(Phone p1, Phone p2) {
        return Integer.compare(p1.getId(),p2.getId());
    }
}
