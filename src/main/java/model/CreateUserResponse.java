package model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import utils.DataDeserializer;

import java.time.LocalDateTime;

@Data
public class CreateUserResponse {
    private String name;
    private String job;
    private int id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = DataDeserializer.class)
    private LocalDateTime createdAt;

    public CreateUserResponse(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
