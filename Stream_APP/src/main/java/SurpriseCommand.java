public class SurpriseCommand implements Command{
    Integer userId, streamType;

    public SurpriseCommand(Integer userId, Integer streamType) {
        this.userId = userId;
        this.streamType = streamType;
    }
    @Override
    public void execute(Data date) {
        User user = date.getUsers().get(this.userId);
        UserDecorator userDecorator = new UserDecorator(user);
        userDecorator.surprise(date,this.streamType);
    }
}
