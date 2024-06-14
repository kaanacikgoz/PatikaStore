import java.util.Comparator;

public class NotebookNameComparator implements Comparator<Notebook> {

    @Override
    public int compare(Notebook n1, Notebook n2) {
        return n1.getBrand().getName().compareTo(n2.getBrand().getName());
    }

}

