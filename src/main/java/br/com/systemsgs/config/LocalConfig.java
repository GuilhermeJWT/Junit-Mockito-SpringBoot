package br.com.systemsgs.config;

import br.com.systemsgs.domain.ModelUser;
import br.com.systemsgs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public void startDB(){
        ModelUser usuario = new ModelUser(null, "Guilherme", "gui@gmail.com", "123");
        repository.save(usuario);
    }

}
