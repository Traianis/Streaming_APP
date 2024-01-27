public class RecommendCommand implements Command{
    Integer userId, streamType;

    public RecommendCommand(Integer userId, Integer streamGenre) {
        this.userId = userId;
        this.streamType = streamGenre;
    }
    @Override
    public void execute(Data date) {
        User user = date.getUsers().get(this.userId);
        UserDecorator userDecorator = new UserDecorator(user);
        userDecorator.recommand(this.streamType);
    }
}
