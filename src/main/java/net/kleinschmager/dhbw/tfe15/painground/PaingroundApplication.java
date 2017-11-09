/**
 * copyright by Robert Kleinschmager
 */
package net.kleinschmager.dhbw.tfe15.painground;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import net.kleinschmager.dhbw.tfe15.painground.persistence.model.MemberProfile;
import net.kleinschmager.dhbw.tfe15.painground.persistence.repository.MemberProfileRepository;

@SpringBootApplication
public class PaingroundApplication {
	
	private static final Logger log = LoggerFactory.getLogger(PaingroundApplication.class);


	/**
	 * the main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(PaingroundApplication.class, args);
	}
	
	/**
	 * Using the CommandLineRunner feature of spring-boot
	 * 
	 * The annotation @Bean ensures, that my {@link CommandLineRunner} is in the spring context, 
	 * spring-boot ensures, that this runner is executed 
	 *  
	 */
	@Bean
	public CommandLineRunner loadData(MemberProfileRepository repository) {
		return (args) -> {
			/// STEP 1
			
			// save a couple of profiles
			repository.save(new MemberProfile("robkle", "Kleinschmager"));
			repository.save(new MemberProfile("mickni", "Knight"));
			repository.save(new MemberProfile("geolaf", "Laforge"));
			repository.save(new MemberProfile("Nicolai1992", "Vajenbranch3wm"));
			repository.save(new MemberProfile("jjulianf", "Foeth"));
			repository.save(new MemberProfile("jf", "ff"));
			repository.save(new MemberProfile("nv", "rebase"));
			repository.save(new MemberProfile("jf", "master3wm"));

			repository.save(new MemberProfile("jf", "3wm"));

			
			// STEP Uebung Rebase
			
			// fetch all profiles
			log.info("MemberProfiles found with findAll():");
			log.info("-------------------------------");
			for (MemberProfile profile : repository.findAll()) {
				log.info(profile.toString());
			}
			log.info("");

			// STEP 3
			
			// fetch an individual customer by ID
			MemberProfile profile = repository.findOne(1L);
			log.info("Profile found with findOne(1L):");
			log.info("--------------------------------");
			log.info(profile.toString());
			log.info("");

		};
	}
}
