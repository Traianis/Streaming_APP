import java.util.ArrayList;

public class ListenCommand implements Command {
    Integer userId, streamId;

    public ListenCommand(Integer userId, Integer streamId) {
        this.userId = userId;
        this.streamId = streamId;
    }

    @Override
    public void execute(Data data) {
        User user = data.getUsers().get(this.userId);
        Stream stream = data.findStream(this.streamId);
        stream.playStream();
        user.add(stream);
        Streamer streamer = user.findStreamer(stream.getStreamerId());
        if (streamer == null)
            user.getStreamers().add(data.getStreamers().get(stream.getStreamerId()));
    }
}
