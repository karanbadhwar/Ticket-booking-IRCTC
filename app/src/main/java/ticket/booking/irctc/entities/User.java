package ticket.booking.irctc.entities;

import java.util.List;

public class User {
    private String name;

    private String password;

    private String hashedPassword;

    private List<Ticket> ticketsBooked;

    private String userId;

    public String getName(){
        return this.name;
    }

    public String getPassword()
    {
        return this.password;
    }
}
