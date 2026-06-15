import java.util.Set;

public class Category {
    private Set<Entry> contents;

    public Category(){
        Entry emptyEntry = new Entry(); //empty entry is added whenever a category is created.
        contents.add(emptyEntry);
    }

    void addEntry(Entry entry){
        contents.add(entry);
    }

    public Set<Entry> getContents() {
        return contents;
    }
}
