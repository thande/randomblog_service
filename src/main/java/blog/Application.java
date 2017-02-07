package blog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Created by sdelight on 5/28/15.
 */
@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }

/*
    @Bean
    public CommandLineRunner demo(BlogRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Blog("Jack", "Bauer"));
            repository.save(new Blog("Chloe", "O'Brian"));
            repository.save(new Blog("Kim", "Bauer"));
            repository.save(new Blog("David", "Palmer"));
            repository.save(new Blog("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Blog blog : repository.findAll()) {
                log.info(Blog.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Blog blog = repository.findOne(1L);
            log.info("Customer found with findOne(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            for (Customer bauer : repository.findByLastName("Bauer")) {
                log.info(bauer.toString());
            }
            log.info("");
        };
    }
*/



    }
