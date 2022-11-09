import model.CreateUserResponse;
public class UserSteps {
    APIUser apiUser = new APIUser();

    public void createUser(String name, String job) {
        CreateUserResponse model = new CreateUserResponse(name, job);
        apiUser.createUser(model);
    }
}
