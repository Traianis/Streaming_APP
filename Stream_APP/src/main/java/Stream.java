public class Stream {
    private Integer streamType, streamerId, streamGenre, id;
    public Long noOfStreams, length, dateAdded;
    private String name, streamerName;

    public Stream() {
        this(-1, -1, -1, -1L, -1,
                -1L, -1L, "Unknown", "Unknown");
    }

    public Stream(Integer streamType, Integer id, Integer streamGenre, Long noOfStreams,
                  Integer streamerId, Long length, Long dateAdded, String name, String streamerName) {
        this.streamType = streamType;
        this.streamerId = streamerId;
        this.streamGenre = streamGenre;
        this.id = id;
        this.noOfStreams = noOfStreams;
        this.length = length;
        this.dateAdded = dateAdded;
        this.name = name;
        this.streamerName = streamerName;
    }

    public Integer getStreamType() {
        return streamType;
    }

    public void setStreamType(Integer streamType) {
        this.streamType = streamType;
    }

    public Integer getStreamerId() {
        return streamerId;
    }

    public void setStreamerId(Integer streamerId) {
        this.streamerId = streamerId;
    }

    public Integer getStreamGenre() {
        return streamGenre;
    }

    public void setStreamGenre(Integer streamGenre) {
        this.streamGenre = streamGenre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getNoOfStreams() {
        return noOfStreams;
    }

    public void setNoOfStreams(Long noOfStreams) {
        this.noOfStreams = noOfStreams;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Long getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Long dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreamerName() {
        return streamerName;
    }

    public void setStreamerName(String streamerName) {
        this.streamerName = streamerName;
    }

    public void playStream() {
        this.noOfStreams++;
    }
}
