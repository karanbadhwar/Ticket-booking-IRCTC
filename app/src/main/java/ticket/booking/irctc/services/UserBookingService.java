package ticket.booking.irctc.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.irctc.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserBookingService {

    private User user;
    private List<User> userList;

    //Object Mapping (Reading Data from Json file and mapping it to the classes)
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    //Path to the Local DB
    private static final String USERS_PATH = "../localDB/users.json";

    public UserBookingService(User user) throws IOException
    {
        this.user = user;
        File users = new File(USERS_PATH);

        //Deserializing the User from localDB
        userList = OBJECT_MAPPER.readValue(users, new TypeReference<List<User>>() {});
    }
}
