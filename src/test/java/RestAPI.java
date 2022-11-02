import org.testng.annotations.Test;

public class RestAPI {
    STEPUser stepUser = new STEPUser();
    @Test
    public void testPost(){
        stepUser.createUser("olya","pharmacist");
    }
}
