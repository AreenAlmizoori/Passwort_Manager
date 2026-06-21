import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Category {
    private List<Entry> contents = new ArrayList<>(); //list of entries

    /**
     * adds a new Entry object to contents.
     * @param entry an Entry Object to be added
     */
    public void addEntry(Entry entry){
        contents.add(entry);
    }

    /**
     * returns what is saved inside of contents.
     * @return the value of contents
     */
    public List<Entry> getContents() {
        return contents;
    }

    /**
     * removes an Entry object if it is inside of contents.
     * if the given Entry object is not found within contents, then a message will be printed in the console.
     * @param entry an Entry object to be removed
     */
    public void removeEntry(Entry entry){
        if(contents.contains(entry)){
            contents.remove(entry);
            int oldID = Entry.getEntryID();
            Entry.setEntryID(oldID-1);
        }else{
            System.out.println("This category has no such entry.");
        }
    }

    /**
     * prints a Category object in the console
     * @return a String of the attribute(s)
     */
    @Override
    public String toString() {
        return "List of Entries: " + contents;
    }
}
