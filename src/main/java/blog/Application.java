package blog;

import blog.model.BlogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


/**
 * Created by sdelight on 5/28/15.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    private BlogRepository repository;

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }

    @Override
    public void run(String... args) throws Exception {
        log.info("starting run method");

        repository.deleteAll();

        // save a couple of customers
        Blog blg = new Blog();
        blg.setId(1);
        blg.setName("First1");
        blg.setContent("Contents1");
        blg.setCreatedDate(new Date());
        repository.save( blg);

        repository.save(new Blog(2,"Second", "Awesome Content",new Date()));

        // fetch all customers
        log.info("Customers found with findAll():");
        log.info("-------------------------------");
        for (Blog blog : repository.findAll()) {
            log.info(blog.getId()+blog.getName()+blog.getContent());
        }
        log.info("");

        // fetch an individual customer
        log.info("Customer found with findByName('First1'):");
        log.info("--------------------------------");
        log.info(repository.findByName("First1").getName());


    }



    }
