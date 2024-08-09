package ticket.booking.irctc.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.irctc.entities.Train;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class TrainService {

    private List<Train> trainList;

    //Path to the Local DB
    private static final String TRAIN_PATH = "app/src/main/java/ticket/booking/irctc/localDB/trains.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public TrainService() throws IOException {
        trainList = loadTrains();
    }

    private List<Train> loadTrains() throws IOException {
        File trainFile = new File(TRAIN_PATH);
        return objectMapper.readValue(trainFile, new TypeReference<List<Train>>() {
        });
    }

    public List<Train> searchTrains(String src, String dest) {
        return trainList.stream().filter(train -> validTrain(train, src, dest)).toList();
    }

    private boolean validTrain(Train train, String src, String dest) {
        List<String> stationOrder = train.getStations();

        int sourceIndex = stationOrder.indexOf(src.toLowerCase());
        int destinationIndex = stationOrder.indexOf(dest.toLowerCase());

        return sourceIndex != -1 && destinationIndex != -1 && sourceIndex < destinationIndex;
    }

    public void addTrain(Train train) throws IOException {
        Optional<Train> existingTrain = trainList.stream().filter(t -> train.getTrainId().equalsIgnoreCase(t.getTrainId())).findFirst();
        if (existingTrain.isPresent()) {
            updateTrain(train);
        } else {
            trainList.add(train);
            saveTrainListToFile();
        }
    }

    private void updateTrain(Train updatedTrain) throws IOException {
        OptionalInt index = IntStream.range(0, trainList.size()).filter(t -> trainList.get(t).getTrainId().equalsIgnoreCase(updatedTrain.getTrainId())).findFirst();

        if (index.isPresent()) {
            // If found, replace the existing train with the updated one
            trainList.set(index.getAsInt(), updatedTrain);
            saveTrainListToFile();
        } else {
            // If not found, treat it as adding a new train
            addTrain(updatedTrain);
        }
    }

    public void saveTrainListToFile() throws IOException {
        File trainPath = new File(TRAIN_PATH);
        objectMapper.writeValue(trainPath, trainList);
    }
}
