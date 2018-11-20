package com.ekino.rest.sample.exception

import com.ekino.rest.sample.model.User
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Duplicate user")
class DuplicateUserException : RuntimeException()