package com.ekino.rest.sample.model


class User {
    lateinit var id : String
    lateinit var name : String
    lateinit var email : String
    lateinit var password : String
    var userShows : MutableList<Show> ? = null

    constructor(
            id: String,
            name: String,
            email: String,
            password: String,
            userShow : MutableList<Show> ? = null
    ) : this() {
        this.id = id
        this.name = name
        this.email = email
        this.password = password
        this.userShows = userShows
    }
    constructor()
}