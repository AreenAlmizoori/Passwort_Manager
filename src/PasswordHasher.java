import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Diese Klasse wandelt Passwörter in sichere Hashwerte um.
 * Das Master-Passwort wird nicht im Klartext gespeichert.
 */
public class PasswordHasher {

    /**
     * Erstellt einen SHA-256 Hash aus einem Passwort.
     *
     * @param password das eingegebene Klartext-Passwort
     * @return Hashwert als String
     */
    public static String hash(String password) {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] hashBytes = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();

            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hash-Algorithmus nicht verfügbar", e);
        }
    }
}
