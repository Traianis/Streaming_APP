public class DeleteCommand implements Command {
    Integer streamerId, streamId;

    public DeleteCommand(Integer streamerId, Integer streamId) {
        this.streamerId = streamerId;
        this.streamId = streamId;
    }

    @Override
    public void execute(Data data) {
        Streamer streamer = data.getStreamers().get(this.streamerId);
        StreamerDecorator streamerDecorator = new StreamerDecorator(streamer);
        streamerDecorator.delete(data,this.streamId);
    }
}
