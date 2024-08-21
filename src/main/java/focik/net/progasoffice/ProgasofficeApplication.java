package focik.net.progasoffice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProgasofficeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgasofficeApplication.class, args);
	}

}
