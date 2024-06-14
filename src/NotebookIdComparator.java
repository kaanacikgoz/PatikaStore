import java.util.Comparator;

public class NotebookIdComparator implements Comparator<Notebook> {
    @Override
    public int compare(Notebook n1, Notebook n2) {
        return Integer.compare(n1.getId(), n2.getId());
    }
}
