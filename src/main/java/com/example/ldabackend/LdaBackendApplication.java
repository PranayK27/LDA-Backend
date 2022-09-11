package com.example.ldabackend;

import com.example.ldabackend.model.TechnologyList;
import com.example.ldabackend.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LdaBackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LdaBackendApplication.class, args);
    }

    @Autowired
    ListRepository Listrepository;
    
    @Override
    public void run(String... args) throws Exception {

        TechnologyList technologyList1 = TechnologyList.builder()
                .id(1)
                .name("Spring Boot")
                .description("Spring Boot is an open source Java-based framework used to create a micro Service. It is developed by Pivotal Team and is used to build stand-alone and production ready spring applications.")
                .categoryId(2014)
                .build();

        TechnologyList technologyList2 = TechnologyList.builder()
                .id(2)
                .name("Angular")
                .description("Angular is a TypeScript-based free and open-source web application framework led by the Angular Team at Google and by a community of individuals and corporations. Angular is a complete rewrite from the same team that built AngularJS.")
                .categoryId(2016)
                .build();

        TechnologyList technologyList3 = TechnologyList.builder()
                .id(3)
                .name("Docker")
                .description("Docker is a set of platform as a service products that use OS-level virtualization to deliver software in packages called containers. The service has both free and premium tiers. The software that hosts the containers is called Docker Engine.")
                .categoryId(2013)
                .build();

        Listrepository.save(technologyList1);
        Listrepository.save(technologyList2);
        Listrepository.save(technologyList3);
    }

}
