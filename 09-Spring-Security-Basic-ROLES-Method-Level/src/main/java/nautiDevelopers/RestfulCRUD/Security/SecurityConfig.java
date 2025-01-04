package nautiDevelopers.RestfulCRUD.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableMethodSecurity
@Configuration
public class SecurityConfig {

    /*
    Note: Do not use this, the problem with this method is you have to manually add
    {bcrypt} prefix to your password.
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
     */

    //Better
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public UserDetailsManager userDetailsManager() {
        UserDetails Saurab = User.builder()
                .username("Saurab")
                .password(passwordEncoder().encode("s12345"))
                .roles("EMPLOYEE")
                .build();
        UserDetails Anu = User.builder()
                .username("Anu")
                .password(passwordEncoder().encode("a12345"))
                .roles("EMPLOYEE", "MANAGER")
                .build();
        UserDetails Akshit = User.builder()
                .username("Akshit")
                .password(passwordEncoder().encode("a12345"))
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(Saurab, Anu, Akshit);
    }
    //From Above: Saurab is an employee, Anu is a Manager, and Akshit is Admin.

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //Go to "Controller"
        http.authorizeHttpRequests (authorize ->
                authorize
//                        .requestMatchers(HttpMethod.GET, "/api/college").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.GET, "/api/college/**").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.POST, "/api/college").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.PUT, "/api/college").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.DELETE, "/api/college**").hasRole("ADMIN")
                        .anyRequest().authenticated());
                        http.httpBasic(Customizer.withDefaults()); // use HTTP Basic authentication
                        http.csrf(AbstractHttpConfigurer::disable);// disable Cross Site Request Forgery (CSRF)
                        return http.build();
    }
}

//Note in the next session we will avoid the above hard coding and use Database.

// Note: Go to the "Postman", authorization and Basic Auth:
// Now, you can log in with different users (ABOVE).

