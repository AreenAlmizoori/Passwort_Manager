import java.util.List;
import java.util.Set;

public class Category {
    private List<Entry> contents;

//    public Category(){
//        Entry emptyEntry = new Entry(); //empty entry is added whenever a category is created.
//        emptyEntry.setApplication("");
//        emptyEntry.setUsername("");
//        emptyEntry.setPassword("");
//        contents.add(emptyEntry);
//    }

    void addEntry(Entry entry){
        contents.add(entry);
    }

    public List<Entry> getContents() {
        return contents;
    }
}
