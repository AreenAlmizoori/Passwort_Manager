import java.util.Set;

public class Category {
    private Set<Entry> contents;

    public Category(){
        Entry emptyEntry = new Entry();
        contents.add(emptyEntry);
    }
}
