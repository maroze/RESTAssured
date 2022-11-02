import model.UserRequestModel;
public class STEPUser {
    APIUser apiUser = new APIUser();

    public void createUser(String name, String job) {
        UserRequestModel model = new UserRequestModel(name,job);
        apiUser.createUser(model);
    }
}
