package ticket.booking.irctc.util;

import org.mindrot.jbcrypt.BCrypt;

public class UserServiceUtil {

    //Hashing Password
    public static String hashPassword(String plainPassword)
    {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    //Checking Password
    public static boolean checkPassword(String plainPassword, String hashedPassword)
    {
        return BCrypt.checkpw(plainPassword,hashedPassword);
    }
}
