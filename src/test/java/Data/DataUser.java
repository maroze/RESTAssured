package Data;

import lombok.*;

@Data
public class DataUser {
    private String login="";
    private String password="";
    private String code="";
    private String item="";
    private String text="";

    public DataUser() {
    }

}
