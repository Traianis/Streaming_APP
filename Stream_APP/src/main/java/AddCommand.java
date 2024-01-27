import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddCommand implements Command {
    private Integer streamerId, streamType, streamId, streamGenre;
    private Long length;
    private String name;

    public AddCommand(Integer streamerId, Integer streamType,
                      Integer streamId, Integer streamGenre, Long length, String name) {
        this.streamerId = streamerId;
        this.streamType = streamType;
        this.streamId = streamId;
        this.streamGenre = streamGenre;
        this.length = length;
        this.name = name;
    }

    @Override
    public void execute(Data date) {
        Streamer streamer = date.getStreamers().get(this.streamerId);
        long millis = System.currentTimeMillis()/1000;
        Stream stream = new Stream(this.streamType,this.streamId,this.streamGenre,
                0L,this.streamerId,this.length,millis,this.name,streamer.getName());
        streamer.add(stream);
        date.getStreams().add(stream);
    }
}
