import java.io.*;

public class UserManager {

    private static final String FILE = "user.txt";

    public void saveUser(User user) {
        try (PrintWriter pw = new PrintWriter(FILE)) {
            pw.println(user.getUsername());
            pw.println(user.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User loadUser() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {

            String username = br.readLine();
            String password = br.readLine();

            return new User(username, password);

        } catch (Exception e) {
            return null;
        }
    }

    public boolean login(String username, String password) {

        User user = loadUser();

        if (user == null) return false;

        return user.getUsername().equals(username)
                && user.getPassword().equals(password);
    }
}