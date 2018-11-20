package controller

import entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.web.bind.annotation.*
import repository.UserRepository


@RestController
@RequestMapping("/users")
class UserController(val repository: UserRepository) {

    @GetMapping
    fun findAll() = repository.findAll()

    @PostMapping
    fun addCustomer(@RequestBody user : User) = repository.save(user)


}