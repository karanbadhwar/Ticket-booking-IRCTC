package ticket.booking.irctc.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.irctc.entities.Train;
import ticket.booking.irctc.entities.User;
import ticket.booking.irctc.util.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserBookingService {

    private User user;
    private List<User> userList;

    //Object Mapping (Reading Data from Json file and mapping it to the classes)
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    //Path to the Local DB
    private static final String USERS_PATH = "app/src/main/java/ticket/booking/irctc/localDB/users.json";

    public UserBookingService(User user) throws IOException {
        this.user = user;
        userList = loadUsers();
    }

    public UserBookingService() throws IOException {
        userList = loadUsers();
    }

    public List<User> loadUsers() throws IOException {
        File users = new File(USERS_PATH);
        //Deserializing the User from localDB
        return OBJECT_MAPPER.readValue(users, new TypeReference<List<User>>() {
        });
    }

    //Login User
    public boolean loginUser() {
        Optional<User> foundUser = userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashedPassword());
        }).findFirst();
        return foundUser.isPresent();
    }

    //SignUp User
    public boolean signUp(User user) {
        try {
            userList.add(user);
            saveUserListToFile();
            return Boolean.TRUE;
        } catch (IOException e) {
            return Boolean.FALSE;
        }
    }

    private void saveUserListToFile() throws IOException {
        File usersFile = new File(USERS_PATH);
        OBJECT_MAPPER.writeValue(usersFile, userList);
    }

    //Fetch Booking
    public void fetchBooking() {
        user.printTickets();
    }

    //Cancel Ticket (Booking)
    public Boolean cancelBooking(String ticketId) throws IOException {
        user.cancelBooking(ticketId);
        saveUserListToFile();
        return Boolean.FALSE;
    }

    public List<Train> getTrains(String source, String destination) {
        try {
            TrainService trainService = new TrainService();
            return trainService.searchTrains(source, destination);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<List<Integer>> fetchSeats(Train train) {
        return train.getSeats();
    }

    public Boolean bookTrainSeat(Train bookedTrain, int row, int col) {
        try {
            TrainService trainService = new TrainService();
            List<List<Integer>> seats = bookedTrain.getSeats();

            if (row >= 0 && row < seats.size() && col >= 0 && col < seats.get(row).size()) {
                if (seats.get(row).get(col) == 0) {
                    seats.get(row).set(col, 1);
                    bookedTrain.setSeats(seats);
                    trainService.addTrain(bookedTrain);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
