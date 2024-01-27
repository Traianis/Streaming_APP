import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListCommand implements Command {
    Integer id;

    public ListCommand(Integer id) {
        this.id = id;
    }

    @Override
    public void execute(Data date) {
        Streamer streamer = date.getStreamers().get(this.id);
        if (streamer != null) {
            streamer.listeaza();
        } else {
            User user = date.getUsers().get(this.id);
            user.listeaza();
        }
    }
}
