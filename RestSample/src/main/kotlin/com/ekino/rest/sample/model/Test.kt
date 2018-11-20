package com.ekino.rest.sample.model

import javax.persistence.*


@Entity
@Table(name = "tests")
class Test {

    @Id
    @TableGenerator(name="TABLE_GEN",table="tests", pkColumnName = "GEN_KEY", pkColumnValue = "MONITOR2012.T_JUST_FOR_TEST", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1 )
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : Long = 0

    var name : String  = ""
    constructor()
    constructor(name : String) : this() {
        this.name = name
    }


}