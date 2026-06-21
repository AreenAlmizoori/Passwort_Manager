import java.util.Objects;

public class Entry {
    private String application;
    private String username;
    private String password;
    private int id; //ID for an individual Entry object
    /*
        static entry ID, cannot be exclusively assigned to a singular object,
        increased by one for every Entry object created.
    */
    private static int entryID = 0;

    /**
     * Default constructor for an Entry object without specified values for the attributes.
     */
    public Entry(){
        this.application = " ";
        this.username = " ";
        this.password = " ";
        entryID++;
        this.id = entryID;
    }

    /**
     * Constructor for creating an Entry object with specified values for the attributes.
     * @param application name of website/application
     * @param username the user's username
     * @param password the user's password
     * @param id a given ID for the Entry
     */
    public Entry(String application, String username, String password, int id){
        this.application = application;
        this.username = username;
        this.password = password;
        this.id = id;
        entryID++;
    }

    /**
     * returns what is saved inside of application.
     * @return the value of application
     */
    public String getApplication() {
        return application;
    }

    /**
     * sets the value of application.
     * @param application new value for application
     */
    public void setApplication(String application) {
        this.application = application;
    }

    /**
     * returns what is saved inside of username.
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * sets the value of username.
     * @param username new value for username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * returns what is saved inside of password.
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets the value of password.
     * @param password new value for password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * returns what is saved inside entryID.
     * @return the value of entryID
     */
    public static int getEntryID() {
        return entryID;
    }

    /**
     * sets the value of entryID.
     * @param entryID new value for entryID
     */
    public static void setEntryID(int entryID) {
        Entry.entryID = entryID;
    }

    /**
     * returns what is saved inside of id.
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * sets the id for a singular Entry object
     * @param id new value for id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * compares the attributes of two Entry objects to determine when they are the same object
     * @param o   the reference object with which to compare.
     * @return true if all attributes are equal to the attributes of o
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return id == entry.id && Objects.equals(application, entry.application) && Objects.equals(username, entry.username) && Objects.equals(password, entry.password);
    }

    /**
     * returns hash code for an Entry object
     * @return numeric representation of object
     */
    @Override
    public int hashCode() {
        return Objects.hash(application, username, password, id);
    }

    /**
     * String representation of an Entry object
     * @return String of the attributes
     */
    @Override
    public String toString() {
        return "Application/Website: " + application + ", Username " + username + ", Password " + password + ", ID: " + id;
    }
}
