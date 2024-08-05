package ticket.booking.irctc.entities;

import java.util.*;
import java.sql.Time;

public class Train {
    private String trainId;

    private String trainNo;

    private List<List<Integer>> seats;

    private Map<String, Time> stationsTimings;

    private List<String> stations;
}
