package nautiDevelopers.RestfulCRUD.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig implements WebMvcConfigurer {

    //CORS
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow all endpoints
                .allowedOrigins("http://localhost:3000") // Allow requests from localhost:3000 (React app)
                .allowedMethods("*") // Allow necessary HTTP methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Allow credentials (cookies, etc.)
    }

    //USERS and ROLES
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource); // For taking data from the database.
    } //Now, we are using DATABASE Official Tables => "users" and "authorities"
//From the tables: Saurab is an employee, Anu is a Manager, and Akshit is Admin.

    //The below code will help us to create our own login form.
    // Security filter chain configuration
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Define access rules based on roles
        http.authorizeHttpRequests (configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/college").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/college/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/college").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/college").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/college**").hasRole("ADMIN")
                        .anyRequest().authenticated());

        //From Above: Saurab is an employee, Anu is a Manager, and Akshit is Admin.

        //Use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());
        // Disable Cross Site Request Forgery (CSRF) protection for simplicity (for API requests)
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}

// Note: Go to Postman, authorization and Basic Auth:
// Now, you can log in with different users (ABOVE) using Database tables.

