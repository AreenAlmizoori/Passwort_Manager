import java.util.Objects;

public class Entry {
    private String application;
    private String username;
    private String password;
    private int id;
    private static int entryID = 0;

    public Entry(){
        this.application = " ";
        this.username = " ";
        this.password = " ";
        entryID++;
        this.id = entryID;
    }

    public Entry(String application, String username, String password, int id){
        this.application = application;
        this.username = username;
        this.password = password;
        this.id = id;
        entryID++;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getEntryID() {
        return entryID;
    }

    public static void setEntryID(int entryID) {
        Entry.entryID = entryID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return id == entry.id && Objects.equals(application, entry.application) && Objects.equals(username, entry.username) && Objects.equals(password, entry.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(application, username, password, id);
    }

    @Override
    public String toString() {
        return "Application/Website: " + application + ", Username " + username + ", Password " + password + ", ID: " + id;
    }
}
