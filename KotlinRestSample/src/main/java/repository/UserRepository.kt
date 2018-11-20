package repository

import entity.User
import org.springframework.data.repository.CrudRepository


interface UserRepository : CrudRepository<User, Long>