package sali.gymi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sali.gymi.domain.Liike;
import sali.gymi.domain.LiikeRepository;
import sali.gymi.domain.Sali;
import sali.gymi.domain.SaliRepository;
import sali.gymi.domain.UserRepository;
import sali.gymi.domain.User;
import sali.gymi.domain.Visit;
import sali.gymi.domain.VisitRepository;


@SpringBootApplication
public class GymiApplication {
	private static final Logger log = LoggerFactory.getLogger(GymiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GymiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner gymiDemo(SaliRepository saliRepository, LiikeRepository liikeRepository, UserRepository userRepository, VisitRepository visitRepository) {
		return (args) -> {
			
			log.info("Save movements");
			liikeRepository.save(new Liike("Penkki"));
			liikeRepository.save(new Liike("MAVE"));
			liikeRepository.save(new Liike("SJ-MAVE"));
			liikeRepository.save(new Liike("Hauiskääntö"));
			liikeRepository.save(new Liike("Kyykky"));
			liikeRepository.save(new Liike("Pystypunnerus Kp"));
			liikeRepository.save(new Liike("Pystypunnerrus tanko"));
			liikeRepository.save(new Liike("Push-Down"));
			liikeRepository.save(new Liike("Viparit sivulle"));
			liikeRepository.save(new Liike("Ylätalja"));
			liikeRepository.save(new Liike("Alatalja"));
			liikeRepository.save(new Liike("Dippi"));
			
			log.info("Save dates");
			visitRepository.save(new Visit("21.12.2018"));

			log.info("Examples");
			saliRepository.save(new Sali("eka", "6", "30", "asd", "ENs kerralla enemmän päinoja", liikeRepository.findByLiikeName("Penkki").get(0)));
			saliRepository.save(new Sali("toka", "10", "15", "100", "Vikat kovempaa", liikeRepository.findByLiikeName("MAVE").get(0)));

			log.info("Example users");
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "admin@admin.com");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "user@user.com");
			userRepository.save(user1);
			userRepository.save(user2);
			
						
			
						
			log.info("Gym visits");
			for (Sali sali : saliRepository.findAll()) {
				log.info(sali.toString());
			}

		};
	}
}
