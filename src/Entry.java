public class Entry {
    private String application;
    private String username;
    private String password;

    public Entry(){
        this.application = " ";
        this.username = " ";
        this.password = " ";
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
}
