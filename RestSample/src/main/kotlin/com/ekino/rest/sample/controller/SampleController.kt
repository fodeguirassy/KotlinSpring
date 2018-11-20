package com.ekino.rest.sample.controller

import com.ekino.rest.sample.component.UsersDatabase
import com.ekino.rest.sample.exception.DuplicateUserException
import com.ekino.rest.sample.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController {

    @Autowired
    private lateinit var usersDatabase : UsersDatabase

    @RequestMapping("", method = arrayOf(RequestMethod.GET))
    fun findAllUsers() = usersDatabase.getUsers()

    @RequestMapping("", method = arrayOf(RequestMethod.POST))
    fun addUser(@RequestBody user: User) =
            if (usersDatabase.addUser(user)) user
            else
                throw DuplicateUserException()
}
