package focik.net.progasoffice.userservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class HttpResponse {

    private int status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss", timezone = "Europe/Warsaw")
    private  Date timestamp;
    private  HttpStatus httpStatus;
    private  String reason;
    private  String message;

    public HttpResponse(int status, HttpStatus httpStatus, String reason, String message) {
        this.status = status;
        this.httpStatus = httpStatus;
        this.reason = reason;
        this.message = message;
        this.timestamp = new Date();
    }
}
