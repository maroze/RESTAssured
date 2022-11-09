import org.testng.annotations.Test;


public class RestAPI {
    UserSteps userSteps = new UserSteps();

    public String name = "olya";
    public String job = "pharmacist";
    @Test
    public void testPost(){
        userSteps.createUser(name,job);
    }
}
