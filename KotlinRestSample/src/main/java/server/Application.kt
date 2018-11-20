package server

import entity.User
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import repository.UserRepository



@SpringBootApplication
@EnableAutoConfiguration
class Application {

    @Bean
    fun init(repository: UserRepository) = CommandLineRunner {
            repository.save(User().apply {
                name = "Sambarou"
            })
    }
}
