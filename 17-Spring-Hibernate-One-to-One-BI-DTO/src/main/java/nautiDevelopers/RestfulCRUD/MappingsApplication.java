package nautiDevelopers.RestfulCRUD;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MappingsApplication {

	@Bean
	public ModelMapper modelMapper() {//Configuring Model Mapper Class
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(MappingsApplication.class, args);
	}
}
