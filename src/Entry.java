public class Entry {
    private String application;
    private String username;
    private String password;
    private static int entryID;

    public Entry(){
        this.application = " ";
        this.username = " ";
        this.password = " ";
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

    @Override
    public String toString() {
        return "Application/Website: " + application + ", Username " + username + ", Password " + password;
    }
}
