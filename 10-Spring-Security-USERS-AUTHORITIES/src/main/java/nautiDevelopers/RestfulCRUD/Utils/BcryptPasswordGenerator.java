package nautiDevelopers.RestfulCRUD.Utils;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BcryptPasswordGenerator {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        System.out.println(passwordEncoder.encode("a12345"));//Password
        System.out.println(passwordEncoder.encode("12345"));
    }
}


