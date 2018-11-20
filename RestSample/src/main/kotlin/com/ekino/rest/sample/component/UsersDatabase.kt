package com.ekino.rest.sample.component

import com.ekino.rest.sample.model.User
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct


@Component
class UsersDatabase {
    private var users = mutableListOf<User>()

    @PostConstruct
    private fun init(){
        users.add(User("23746546", "Sambarou", "sambarou@samb.fr","pouet123"))
    }

    fun getUsers() = users

    fun addUser(user: User) : Boolean {
        users.firstOrNull { it.id == user.id }?.let {
            return false
        }
        users.add(user)
        return true
    }
}