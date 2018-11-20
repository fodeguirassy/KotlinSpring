package entity

import javax.persistence.*
@Entity
class User (){
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id : Long = 0
    var name : String = ""
    var email : String = ""
    var password = ""
}



