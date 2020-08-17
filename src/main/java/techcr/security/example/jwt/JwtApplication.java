package techcr.security.example.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import techcr.security.example.jwt.config.CustomUserDetailsService;
import techcr.security.example.jwt.model.UserDTO;
import techcr.security.example.jwt.repository.UserRepository;

@SpringBootApplication
public class JwtApplication implements CommandLineRunner {

    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        UserDTO admin = new UserDTO();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setRole("ROLE_ADMIN");
        userDetailsService.save(admin);

        UserDTO user = new UserDTO();
        admin.setUsername("user");
        admin.setPassword("user");
        admin.setRole("ROLE_USER");
        userDetailsService.save(admin);
        System.out.println("# of users " + userRepository.count());
    }
}
