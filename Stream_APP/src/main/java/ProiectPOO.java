import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Handler;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.text.StringTokenizer;

public class ProiectPOO {
    public static void main(String[] args) {
        if (args == null) {
            System.out.println("Nothing to read here");
            return;
        }
        Data data = Data.getInstance();
        FactoryCommand factoryCommand = FactoryCommand.getInstance();
        FactoryUtilizator factoryUtilizator = FactoryUtilizator.getInstance();
        Read reader = new Read();
        reader.readStreamers(factoryUtilizator,data, args[0]);
        reader.readStreams(data, args[1]);
        reader.readUsers(factoryUtilizator,data, args[2]);
        reader.readCommands(factoryCommand, args[3], data);
        data.getStreamers().clear();
        data.getStreams().clear();
        data.getUsers().clear();
    }
}

class Read {
    //Citirea streamerilor din fisier
    void readStreamers(FactoryUtilizator factoryUtilizator,Data data, String file) {
        try {
            FileReader filereader = new FileReader("src/main/resources/" + file);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            csvReader.skip(1);
            while ((nextRecord = csvReader.readNext()) != null) {
                Integer streamerType = Integer.valueOf(nextRecord[0]);
                Integer id = Integer.valueOf(nextRecord[1]);
                String name = nextRecord[2];
                Streamer streamer = (Streamer) factoryUtilizator.createUtilizator("streamer", id, name, streamerType);
                data.getStreamers().put(streamer.getId(), streamer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Citirea streamurilor din fisier
    void readStreams(Data data, String file) {
        try {
            FileReader filereader = new FileReader("src/main/resources/" + file);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            csvReader.skip(1);
            while ((nextRecord = csvReader.readNext()) != null) {
                Integer streamType = Integer.valueOf(nextRecord[0]);
                Integer id = Integer.valueOf(nextRecord[1]);
                Integer streamGenre = Integer.valueOf(nextRecord[2]);
                Long noOfStreams = Long.valueOf(nextRecord[3]);
                Integer streamerId = Integer.valueOf(nextRecord[4]);
                Long length = Long.valueOf(nextRecord[5]);
                Long dataAdded = Long.valueOf(nextRecord[6]);
                String name = nextRecord[7];
                Streamer streamer = data.getStreamers().get(streamerId);
                Stream stream = new Stream(streamType, id, streamGenre, noOfStreams, streamerId, length, dataAdded, name, streamer.getName());
                streamer.add(stream);
                data.getStreams().add(stream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Map.Entry<Integer, Streamer> streamerEntry : data.getStreamers().entrySet()) {
            Streamer streamer = streamerEntry.getValue();
            Collections.reverse(streamer.getStreams());
        }
    }

    //Citirea userilor din fisier
    void readUsers(FactoryUtilizator factoryUtilizator, Data data, String file) {
        try {
            FileReader filereader = new FileReader("src/main/resources/" + file);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            csvReader.skip(1);
            while ((nextRecord = csvReader.readNext()) != null) {
                Integer id = Integer.valueOf(nextRecord[0]);
                String name = nextRecord[1];
                User user = (User) factoryUtilizator.createUtilizator("user", id, name, -1);
                ArrayList<Streamer> streamers = user.getStreamers();
                StringTokenizer st = new StringTokenizer(nextRecord[2], " ");
                while (st.hasNext()) {
                    Integer streamId = Integer.valueOf(st.nextToken());
                    Stream stream = data.findStream(streamId);
                    Streamer streamer = user.findStreamer(stream.getStreamerId());
                    user.getStreamHashMap().put(stream.getId(), stream);
                    user.getStreamArrayList().add(streamId);
                    if (streamer == null) {
                        streamer = data.getStreamers().get(stream.getStreamerId());
                        streamers.add(streamer);
                    }
                }
                data.getUsers().put(user.getId(), user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Citirea comenzilor
    void readCommands(FactoryCommand factoryCommand, String file, Data data) {
        String line = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/main/resources/" + file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                if (((line = br.readLine()) == null))
                    break;
                Command command = factoryCommand.createCommand(line);
                command.execute(data);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
