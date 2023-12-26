package com.example.ldabackend;

import com.example.ldabackend.model.TechnologyList;
import com.example.ldabackend.repository.ListRepository;
import com.example.ldabackend.repository.LoginRepository;
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

    @Autowired
    LoginRepository loginRepository;
    
    @Override
    public void run(String... args) throws Exception {

        TechnologyList technologyList1 = TechnologyList.builder()
                .id(1)
                .name("Spring Boot")
                .description("Details")
                .categoryId(2)
                .build();

        TechnologyList technologyList2 = TechnologyList.builder()
                .id(2)
                .name("Angular")
                .description("Details")
                .categoryId(1)
                .build();

        TechnologyList technologyList3 = TechnologyList.builder()
                .id(3)
                .name("Docker")
                .description("Details")
                .categoryId(3)
                .build();

        Listrepository.save(technologyList1);
        Listrepository.save(technologyList2);
        Listrepository.save(technologyList3);
    }

}
