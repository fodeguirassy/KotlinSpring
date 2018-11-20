package com.ekino.rest.sample.controller

import com.ekino.rest.sample.component.TestDAO
import com.ekino.rest.sample.model.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody



@Controller
class TestController {

    @Autowired
    private lateinit var testDao : TestDAO

    @RequestMapping("/", method = arrayOf(RequestMethod.POST))
    fun createTest(@RequestBody name : String) : Long {
        try {
            testDao.create(Test(name = name))
        }catch (ex : Exception){
            println("FAILED TO CREATE TEST ERROR IS $ex")
        }
        return 0
    }
}