package ma.formations.msa.webclientfrontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebClientFrontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebClientFrontendApplication.class, args);
        System.out.println("Application démarrée");
    }

}
