import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Category {
    private List<Entry> contents = new ArrayList<>();

//    public Category(){
//        Entry emptyEntry = new Entry(); //empty entry is added whenever a category is created.
//        emptyEntry.setApplication("");
//        emptyEntry.setUsername("");
//        emptyEntry.setPassword("");
//        contents.add(emptyEntry);
//    }

    public void addEntry(Entry entry){
        contents.add(entry);
    }

    public List<Entry> getContents() {
        return contents;
    }

    public void removeEntry(Entry entry){
        if(contents.contains(entry)){
            contents.remove(entry);
        }else{
            System.out.println("This category has no such entry.");
        }
    }

    @Override
    public String toString() {
        return "List of Entries: " + contents;
    }
}
